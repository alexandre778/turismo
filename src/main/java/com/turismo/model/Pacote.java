package com.turismo.model;

import jakarta.persistence.*;

@Entity
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Transporte transporte;

    @ManyToOne
    private Hospedagem hospedagem;

    private String destino;
    private int quantidadeDias;
    private double margemLucro;
    private double taxasAdicionais;

    // Getters e setters
    public Long getId() { return id; }

    public Transporte getTransporte() { return transporte; }
    public void setTransporte(Transporte transporte) { this.transporte = transporte; }

    public Hospedagem getHospedagem() { return hospedagem; }
    public void setHospedagem(Hospedagem hospedagem) { this.hospedagem = hospedagem; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public int getQuantidadeDias() { return quantidadeDias; }
    public void setQuantidadeDias(int quantidadeDias) { this.quantidadeDias = quantidadeDias; }

    public double getMargemLucro() { return margemLucro; }
    public void setMargemLucro(double margemLucro) { this.margemLucro = margemLucro; }

    public double getTaxasAdicionais() { return taxasAdicionais; }
    public void setTaxasAdicionais(double taxasAdicionais) { this.taxasAdicionais = taxasAdicionais; }
}
