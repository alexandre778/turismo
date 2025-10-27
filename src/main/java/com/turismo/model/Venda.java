package com.turismo.model;

import jakarta.persistence.*;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Pacote pacote;

    private double total;     // Para pacotes nacionais
    private double totalUSD;  // Para pacotes internacionais
    private double totalBRL;  // Para pacotes internacionais

    // Getters e setters
    public Long getId() { return id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Pacote getPacote() { return pacote; }
    public void setPacote(Pacote pacote) { this.pacote = pacote; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public double getTotalUSD() { return totalUSD; }
    public void setTotalUSD(double totalUSD) { this.totalUSD = totalUSD; }

    public double getTotalBRL() { return totalBRL; }
    public void setTotalBRL(double totalBRL) { this.totalBRL = totalBRL; }
}
