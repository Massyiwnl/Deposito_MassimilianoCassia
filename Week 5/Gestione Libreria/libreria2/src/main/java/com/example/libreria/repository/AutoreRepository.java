package com.example.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libreria.model.Autore;

public interface AutoreRepository extends JpaRepository<Autore, Long> {}
