package com.turismo.service;

import com.turismo.model.*;
import com.turismo.repository.*;
import org.springframework.stereotype.Service;
import java.text.NumberFormat;
import java.util.Locale;

@Service
public class PacoteService {

    private final ClienteRepository clienteRepo;
    private final TransporteRepository transporteRepo;
    private final HospedagemRepository hospedagemRepo;
    private final PacoteRepository pacoteRepo;
    private final VendaRepository vendaRepo;

    public PacoteService(ClienteRepository clienteRepo,
                         TransporteRepository transporteRepo,
                         HospedagemRepository hospedagemRepo,
                         PacoteRepository pacoteRepo,
                         VendaRepository vendaRepo) {
        this.clienteRepo = clienteRepo;
        this.transporteRepo = transporteRepo;
        this.hospedagemRepo = hospedagemRepo;
        this.pacoteRepo = pacoteRepo;
        this.vendaRepo = vendaRepo;
    }

    public Venda criarPacoteNacional(String tipoTransporte, double valorTransporte,
                                     String descricaoHospedagem, double valorDiaria,
                                     String destino, int quantidadeDias,
                                     double margemLucro, double taxasAdicionais,
                                     String nomeCliente, String formaPagamento) {

        validarEntrada(valorTransporte, valorDiaria, quantidadeDias, margemLucro, taxasAdicionais, nomeCliente, formaPagamento);

        Transporte transporte = new Transporte();
        transporte.setTipo(tipoTransporte);
        transporte.setValor(valorTransporte);
        transporteRepo.save(transporte);

        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setDescricao(descricaoHospedagem);
        hospedagem.setValorDiaria(valorDiaria);
        hospedagemRepo.save(hospedagem);

        Pacote pacote = new Pacote();
        pacote.setTransporte(transporte);
        pacote.setHospedagem(hospedagem);
        pacote.setDestino(destino);
        pacote.setQuantidadeDias(quantidadeDias);
        pacote.setMargemLucro(margemLucro);
        pacote.setTaxasAdicionais(taxasAdicionais);
        pacoteRepo.save(pacote);

        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);
        cliente.setFormaPagamento(formaPagamento);
        clienteRepo.save(cliente);

        double total = valorTransporte + (valorDiaria * quantidadeDias) + taxasAdicionais;
        total += total * (margemLucro / 100);

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setPacote(pacote);
        venda.setTotal(total);
        vendaRepo.save(venda);

        return venda;
    }

    public Venda criarPacoteInternacional(String tipoTransporte, double valorTransporte,
                                          String descricaoHospedagem, double valorDiaria,
                                          String destino, int quantidadeDias,
                                          double margemLucro, double taxasAdicionais,
                                          String nomeCliente, String formaPagamento,
                                          double cotacaoDolar) {

        validarEntrada(valorTransporte, valorDiaria, quantidadeDias, margemLucro, taxasAdicionais, nomeCliente, formaPagamento);

        Transporte transporte = new Transporte();
        transporte.setTipo(tipoTransporte);
        transporte.setValor(valorTransporte);
        transporteRepo.save(transporte);

        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setDescricao(descricaoHospedagem);
        hospedagem.setValorDiaria(valorDiaria);
        hospedagemRepo.save(hospedagem);

        Pacote pacote = new Pacote();
        pacote.setTransporte(transporte);
        pacote.setHospedagem(hospedagem);
        pacote.setDestino(destino);
        pacote.setQuantidadeDias(quantidadeDias);
        pacote.setMargemLucro(margemLucro);
        pacote.setTaxasAdicionais(taxasAdicionais);
        pacoteRepo.save(pacote);

        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);
        cliente.setFormaPagamento(formaPagamento);
        clienteRepo.save(cliente);

        double totalUSD = valorTransporte + (valorDiaria * quantidadeDias) + taxasAdicionais;
        totalUSD += totalUSD * (margemLucro / 100);
        double totalBRL = totalUSD * cotacaoDolar;

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setPacote(pacote);
        venda.setTotalUSD(totalUSD);
        venda.setTotalBRL(totalBRL);
        vendaRepo.save(venda);

        return venda;
    }

    private void validarEntrada(double valorTransporte, double valorDiaria, int quantidadeDias,
                                double margemLucro, double taxasAdicionais, String nomeCliente,
                                String formaPagamento) {
        if (quantidadeDias <= 0) throw new IllegalArgumentException("Quantidade de dias inválida.");
        if (valorTransporte < 0 || valorDiaria < 0 || margemLucro < 0 || taxasAdicionais < 0)
            throw new IllegalArgumentException("Valores não podem ser negativos.");
        if (nomeCliente == null || nomeCliente.isBlank())
            throw new IllegalArgumentException("Nome do cliente é obrigatório.");
        if (formaPagamento == null || formaPagamento.isBlank())
            throw new IllegalArgumentException("Forma de pagamento é obrigatória.");
    }

    public String formatarMoeda(double valor) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(valor);
    }
}
