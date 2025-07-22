package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
}

