package com.example.libreria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.libreria.model.Libreria;

@Service
public class LibreriaService {
    private final List<Libreria> libri = new ArrayList<>();

    public List<Libreria> getAll() {
        return libri;
    }

    public Optional<Libreria> getByTitolo(String titolo) {
        if (titolo == null) return Optional.empty();
        return libri.stream()
                .filter(l -> l.getTitolo() != null && l.getTitolo().equalsIgnoreCase(titolo))
                .findFirst();
    }

    public Libreria create(Libreria nuovo) {
        // Puoi aggiungere anche qui una validazione se vuoi!
        libri.add(nuovo);
        return nuovo;
    }

    public Optional<Libreria> update(String titolo, Libreria modificato) {
        if (titolo == null) return Optional.empty();
        return getByTitolo(titolo).map(libro -> {
            // Aggiorna solo i campi diversi da null (opzionale)
            if (modificato.getAutore() != null) libro.setAutore(modificato.getAutore());
            libro.setPrezzo(modificato.getPrezzo());
            return libro;
        });
    }

    public boolean delete(String titolo) {
        if (titolo == null) return false;
        return libri.removeIf(l -> l.getTitolo() != null && l.getTitolo().equalsIgnoreCase(titolo));
    }
}
