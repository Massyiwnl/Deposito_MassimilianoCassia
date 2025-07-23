package com.example.libreria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libreria.model.Recensione;
import com.example.libreria.service.RecensioneService;

@RestController
@RequestMapping("/recensioni")
public class RecensioneController {

    private final RecensioneService recensioneService;

    public RecensioneController(RecensioneService recensioneService) {
        this.recensioneService = recensioneService;
    }

    @GetMapping
    public List<Recensione> getAll() {
        return recensioneService.findAll();
    }

    @GetMapping("/{id}")
    public Recensione getById(@PathVariable Long id) {
        return recensioneService.findById(id).orElse(null);
    }

    @PostMapping
    public Recensione create(@RequestBody Recensione recensione) {
        return recensioneService.save(recensione);
    }

    

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recensioneService.deleteById(id);
    }
}
