package com.example.libreria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.libreria.model.Autore;
import com.example.libreria.repository.AutoreRepository;

@Service
public class AutoreService {

    private final AutoreRepository autoreRepository;

    public AutoreService(AutoreRepository autoreRepository) {
        this.autoreRepository = autoreRepository;
    }

    public List<Autore> findAll() {
        return autoreRepository.findAll();
    }

    public Optional<Autore> findById(Long id) {
        return autoreRepository.findById(id);
    }

    public Autore save(Autore autore) {
        return autoreRepository.save(autore);
    }

    public void deleteById(Long id) {
        autoreRepository.deleteById(id);
    }
}
