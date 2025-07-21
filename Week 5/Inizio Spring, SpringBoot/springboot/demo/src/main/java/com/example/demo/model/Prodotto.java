package com.example.demo.model;

public class Prodotto {
private Long id;
private String nome;
private double prezzo;

// Costruttori
public Prodotto() {}
public Prodotto(Long id, String nome, double prezzo) {
this.id = id;
this.nome = nome;
this.prezzo = prezzo;
}

// Getter e Setter
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getNome() { return nome; }
public void setNome(String nome) { this.nome = nome; }

public double getPrezzo() { return prezzo; }
public void setPrezzo(double prezzo) { this.prezzo = prezzo; }
}