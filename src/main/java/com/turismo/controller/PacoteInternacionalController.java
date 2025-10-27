
package com.turismo.controller;

import com.turismo.model.*;
import com.turismo.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacote/internacional")
public class PacoteInternacionalController {

    private final ClienteRepository clienteRepo;
    private final TransporteRepository transporteRepo;
    private final HospedagemRepository hospedagemRepo;
    private final PacoteRepository pacoteRepo;
    private final VendaRepository vendaRepo;

    public PacoteInternacionalController(ClienteRepository clienteRepo, TransporteRepository transporteRepo,
                                         HospedagemRepository hospedagemRepo, PacoteRepository pacoteRepo,
                                         VendaRepository vendaRepo) {
        this.clienteRepo = clienteRepo;
        this.transporteRepo = transporteRepo;
        this.hospedagemRepo = hospedagemRepo;
        this.pacoteRepo = pacoteRepo;
        this.vendaRepo = vendaRepo;
    }

    @GetMapping
    public String mostrarFormulario() {
        return "pacote-internacional";
    }

    @PostMapping("/calcular")
    public String calcularPacoteInternacional(@RequestParam String tipoTransporte,
                                              @RequestParam double valorTransporte,
                                              @RequestParam String descricaoHospedagem,
                                              @RequestParam double valorDiaria,
                                              @RequestParam String destino,
                                              @RequestParam int quantidadeDias,
                                              @RequestParam double margemLucro,
                                              @RequestParam double taxasAdicionais,
                                              @RequestParam String nomeCliente,
                                              @RequestParam String formaPagamento,
                                              @RequestParam double cotacaoDolar,
                                              Model model) {

        // Criar e salvar Transporte
        Transporte transporte = new Transporte();
        transporte.setTipo(tipoTransporte);
        transporte.setValor(valorTransporte);
        transporteRepo.save(transporte);

        // Criar e salvar Hospedagem
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setDescricao(descricaoHospedagem);
        hospedagem.setValorDiaria(valorDiaria);
        hospedagemRepo.save(hospedagem);

        // Criar e salvar Pacote
        Pacote pacote = new Pacote();
        pacote.setTransporte(transporte);
        pacote.setHospedagem(hospedagem);
        pacote.setDestino(destino);
        pacote.setQuantidadeDias(quantidadeDias);
        pacote.setMargemLucro(margemLucro);
        pacote.setTaxasAdicionais(taxasAdicionais);
        pacoteRepo.save(pacote);

        // Criar e salvar Cliente
        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);
        cliente.setFormaPagamento(formaPagamento);
        clienteRepo.save(cliente);

        // Calcular total em USD e BRL
        double totalUSD = valorTransporte + (valorDiaria * quantidadeDias) + taxasAdicionais;
        totalUSD += totalUSD * (margemLucro / 100);
        double totalBRL = totalUSD * cotacaoDolar;

        // Criar e salvar Venda
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setPacote(pacote);
        venda.setTotalUSD(totalUSD);
        venda.setTotalBRL(totalBRL);
        vendaRepo.save(venda);

        // Enviar dados para a view
        model.addAttribute("cliente", nomeCliente);
        model.addAttribute("destino", destino);
        model.addAttribute("dias", quantidadeDias);
        model.addAttribute("formaPagamento", formaPagamento);
        model.addAttribute("totalUSD", String.format("%.2f", totalUSD));
        model.addAttribute("totalBRL", String.format("%.2f", totalBRL));

        return "resultado-internacional";
    }
}
