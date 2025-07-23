package com.example.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libreria.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {}
