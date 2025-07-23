package com.example.libreria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.libreria.model.Recensione;
import com.example.libreria.repository.RecensioneRepository;

@Service
public class RecensioneService {

    private final RecensioneRepository recensioneRepository;

    public RecensioneService(RecensioneRepository recensioneRepository) {
        this.recensioneRepository = recensioneRepository;
    }

    public List<Recensione> findAll() {
        return recensioneRepository.findAll();
    }

    public Optional<Recensione> findById(Long id) {
        return recensioneRepository.findById(id);
    }

    public Recensione save(Recensione recensione) {
        return recensioneRepository.save(recensione);
    }

    public void deleteById(Long id) {
        recensioneRepository.deleteById(id);
    }
}
