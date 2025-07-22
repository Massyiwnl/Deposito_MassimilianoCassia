package com.example.libreria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libreria {
    private String titolo;
    private String autore;
    private double prezzo;
}
