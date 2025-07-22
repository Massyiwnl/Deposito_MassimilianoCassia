package com.example.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todolist.model.Utente;
import com.example.todolist.repository.UtenteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtenteService {

private final UtenteRepository utenteRepository;

public List<Utente> findAll() {
return utenteRepository.findAll();
}

public Utente findById(Long id) {
return utenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Utente non trovato"));
}

public Utente save(Utente utente) {
return utenteRepository.save(utente);
}

public void delete(Long id) {
utenteRepository.deleteById(id);
}
}