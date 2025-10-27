package com.turismo.model;

public class PacoteInternacional {

    private String tipoTransporte;
    private double valorTransporte;
    private String descricaoHospedagem;
    private double valorDiaria;
    private String destino;
    private int quantidadeDias;
    private double margemLucro;
    private double taxasAdicionais;
    private double cotacaoDolar;
    private String formaPagamento;
    private String nomeCliente;

    // Campos calculados
    private double totalDolar;
    private double totalReal;

    // Getters e Setters
    public String getTipoTransporte() { return tipoTransporte; }
    public void setTipoTransporte(String tipoTransporte) { this.tipoTransporte = tipoTransporte; }

    public double getValorTransporte() { return valorTransporte; }
    public void setValorTransporte(double valorTransporte) { this.valorTransporte = valorTransporte; }

    public String getDescricaoHospedagem() { return descricaoHospedagem; }
    public void setDescricaoHospedagem(String descricaoHospedagem) { this.descricaoHospedagem = descricaoHospedagem; }

    public double getValorDiaria() { return valorDiaria; }
    public void setValorDiaria(double valorDiaria) { this.valorDiaria = valorDiaria; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public int getQuantidadeDias() { return quantidadeDias; }
    public void setQuantidadeDias(int quantidadeDias) { this.quantidadeDias = quantidadeDias; }

    public double getMargemLucro() { return margemLucro; }
    public void setMargemLucro(double margemLucro) { this.margemLucro = margemLucro; }

    public double getTaxasAdicionais() { return taxasAdicionais; }
    public void setTaxasAdicionais(double taxasAdicionais) { this.taxasAdicionais = taxasAdicionais; }

    public double getCotacaoDolar() { return cotacaoDolar; }
    public void setCotacaoDolar(double cotacaoDolar) { this.cotacaoDolar = cotacaoDolar; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public double getTotalDolar() { return totalDolar; }
    public void setTotalDolar(double totalDolar) { this.totalDolar = totalDolar; }

    public double getTotalReal() { return totalReal; }
    public void setTotalReal(double totalReal) { this.totalReal = totalReal; }
}
