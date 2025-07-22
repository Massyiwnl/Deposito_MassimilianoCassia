package com.example.libreria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Il titolo è obbligatoria")
    @Column(name = "titolo", nullable = false, length = 100)
    @Size(min = 2, max = 100, message = "Il titolo deve essere tra 2 e 100 caratteri")
    private String titolo;
    @NotBlank(message = "L'autore è obbligatoria")
    @Column(name = "autore", nullable = false, length = 100)
    @Size(min = 2, max = 100, message = "L'autore deve essere tra 2 e 100 caratteri")
    private String autore;
    
    @NotNull(message = "Il prezzo non può essere nullo")
    private double prezzo;

    public Libro(String titolo, String autore, double prezzo) {
    this.titolo = titolo;
    this.autore = autore;
    this.prezzo = prezzo;
}
     
}
