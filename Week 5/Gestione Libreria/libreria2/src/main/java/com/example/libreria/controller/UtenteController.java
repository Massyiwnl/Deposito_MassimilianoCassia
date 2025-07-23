package com.example.libreria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libreria.model.Utente;
import com.example.libreria.service.UtenteService;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    private final UtenteService utenteService;

    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping
    public List<Utente> getAll() {
        return utenteService.findAll();
    }

    @GetMapping("/{id}")
    public Utente getById(@PathVariable Long id) {
        return utenteService.findById(id).orElse(null);
    }

    @PostMapping
    public Utente create(@RequestBody Utente utente) {
        return utenteService.save(utente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        utenteService.deleteById(id);
    }
}
