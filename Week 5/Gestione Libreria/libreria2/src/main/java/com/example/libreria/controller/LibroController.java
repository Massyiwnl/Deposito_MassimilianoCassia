package com.example.libreria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libreria.model.Libro;
import com.example.libreria.service.LibroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/libri")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> getAll() {
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Libro getById(@PathVariable Long id) {
        return libroService.findById(id).orElse(null);
    }

    @PostMapping
    public Libro create(@RequestBody @Valid Libro libro) {
        return libroService.save(libro);
    }

    @PutMapping("/{id}")
    public Libro update(@PathVariable Long id, @RequestBody @Valid Libro libro) {
        libro.setId(id);
        return libroService.save(libro);
    }

    

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        libroService.deleteById(id);
    }
}
