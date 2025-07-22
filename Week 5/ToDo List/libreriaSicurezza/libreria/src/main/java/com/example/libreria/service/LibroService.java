package com.example.libreria.service;

import com.example.libreria.model.Libro;
import com.example.libreria.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibroService {

private final LibroRepository repo;
public LibroService(LibroRepository repo){
    this.repo = repo;
} 


public List<Libro> getAll() {
List<Libro> lista = new ArrayList<>();
repo.findAll().forEach(lista::add);
return lista;
}

public Optional<Libro> getById(Long id) {
return repo.findById(id);
}

public Libro create(Libro nuovo) {
return repo.save(nuovo);
}

public Optional<Libro> update(Long id, Libro modificato) {
return repo.findById(id).map(t -> {
t.setTitolo(modificato.getTitolo());
t.setAutore(modificato.getAutore());
t.setPrezzo(modificato.getPrezzo());
return repo.save(t);
});
}

public boolean delete(Long id) {
if (repo.existsById(id)) {
repo.deleteById(id);
return true;
}
return false;
}
}
    
