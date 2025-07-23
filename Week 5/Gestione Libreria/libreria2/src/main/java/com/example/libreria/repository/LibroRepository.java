package com.example.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libreria.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {}
