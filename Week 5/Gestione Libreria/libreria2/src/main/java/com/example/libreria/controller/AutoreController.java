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

import com.example.libreria.model.Autore;
import com.example.libreria.service.AutoreService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/autori")
public class AutoreController {

    private final AutoreService autoreService;

    public AutoreController(AutoreService autoreService) {
        this.autoreService = autoreService;
    }

    @GetMapping
    public List<Autore> getAll() {
        return autoreService.findAll();
    }

    @GetMapping("/{id}")
    public Autore getById(@PathVariable Long id) {
        return autoreService.findById(id).orElse(null);
    }

    @PostMapping
    public Autore create(@RequestBody @Valid Autore autore) {
        return autoreService.save(autore);
    }

    @PutMapping("/{id}")
    public Autore update(@PathVariable Long id, @RequestBody @Valid Autore autore) {
        autore.setId(id);
        return autoreService.save(autore);
    }

    

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        autoreService.deleteById(id);
    }
}
