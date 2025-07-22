package com.example.todolist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.todolist.model.Todo;
import com.example.todolist.repository.TodoRepository;

@Service
public class TodoService {


    private final TodoRepository repo;

    public TodoService(TodoRepository repo) {
    this.repo = repo;
    }

    public List<Todo> getAll() {
        List<Todo> lista = new ArrayList<>();
        repo.findAll().forEach(lista::add);
        return lista;
        }

    public Optional<Todo> getById(Long id) {
        return repo.findById(id);
    }

   public Todo create(Todo nuovo) {
        return repo.save(nuovo);
    }

    public Optional<Todo> update(Long id, Todo modificato) {
        return repo.findById(id).map(t -> {
        t.setDescrizione(modificato.getDescrizione());
        t.setCompletato(modificato.isCompletato());
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
