package com.example.todolist.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.model.Commento;
import com.example.todolist.service.CommentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/commenti")
@RequiredArgsConstructor
public class CommentoController {

    private final CommentoService commentoService;

    @GetMapping
    public List<Commento> getAllCommenti() {
        return commentoService.findAll();
    }

    @GetMapping("/{id}")
    public Commento getCommentoById(@PathVariable Long id) {
        return commentoService.findById(id);
    }

    @PostMapping
    public Commento createCommento(@RequestBody Commento commento) {
        return commentoService.save(commento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommento(@PathVariable Long id) {
        commentoService.delete(id);
        return ResponseEntity.ok("Commento eliminato");
    }
}