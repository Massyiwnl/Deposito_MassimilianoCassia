package com.example.demo.model;

public class Numeri {
    private Long id;
    private double valore;

    // Costruttori
    public Numeri() {}
    public Numeri(Long id, double valore) {
        this.id = id;
        this.valore = valore;
    }

    // Getter e Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getValore() { return valore; }
    public void setValore(double valore) { this.valore = valore; }
}
