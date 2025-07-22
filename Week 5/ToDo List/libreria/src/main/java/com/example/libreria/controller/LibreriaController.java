package com.example.libreria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libreria.model.Libreria;
import com.example.libreria.service.LibreriaService;

@RestController
@RequestMapping("/api/libreria")
public class LibreriaController {

    private final LibreriaService service;

    public LibreriaController(LibreriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Libreria> getAll() {
        return service.getAll();
    }

    @GetMapping("/{titolo}")
    public ResponseEntity<Libreria> getByTitolo(@PathVariable String titolo) {
        return service.getByTitolo(titolo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libreria> create(@RequestBody Libreria nuovo) {
        // Validazione di base per evitare libri con titolo nullo/vuoto
        if (nuovo.getTitolo() == null || nuovo.getTitolo().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Libreria creato = service.create(nuovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    @PutMapping("/{titolo}")
    public ResponseEntity<Libreria> update(@PathVariable String titolo, @RequestBody Libreria modificato) {
        if (titolo == null || titolo.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        return service.update(titolo, modificato)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{titolo}")
    public ResponseEntity<Void> delete(@PathVariable String titolo) {
        if (titolo == null || titolo.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        boolean rimosso = service.delete(titolo);
        return rimosso ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
