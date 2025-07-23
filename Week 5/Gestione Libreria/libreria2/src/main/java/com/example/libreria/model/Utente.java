package com.example.libreria.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il nome dell'utente è obbligatorio")
    @Size(min = 2, max = 50, message = "Il nome deve essere tra 2 e 50 caratteri")
    @Column(nullable = false)
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recensione> recensioni;
}


