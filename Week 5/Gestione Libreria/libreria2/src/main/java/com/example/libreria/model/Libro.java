package com.example.libreria.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Getter
@Table(name = "libri")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il titolo del libro è obbligatorio")
    @Size(min = 1, max = 100, message = "Il titolo deve essere tra 1 e 100 caratteri")
    @Column(nullable = false)
    private String titolo;

    @NotNull(message = "L'autore è obbligatorio")
    @ManyToOne
    @JoinColumn(name = "autore_id", nullable = false)
    private Autore autore;

    @JsonIgnore
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recensione> recensioni;
}

