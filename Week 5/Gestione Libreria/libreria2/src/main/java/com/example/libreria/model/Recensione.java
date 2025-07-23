package com.example.libreria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "recensioni")
@Getter
public class Recensione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il testo della recensione è obbligatorio")
    @Size(min = 3, max = 500, message = "Il testo deve essere tra 3 e 500 caratteri")
    @Column(nullable = false)
    private String testo;

    @NotNull(message = "Il libro è obbligatorio")
    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    @NotNull(message = "L'utente è obbligatorio")
    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;
}

