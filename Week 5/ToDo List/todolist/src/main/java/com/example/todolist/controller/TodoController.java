package com.example.todolist.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.model.Commento;
import com.example.todolist.model.Todo;
import com.example.todolist.service.CommentoService;
import com.example.todolist.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final CommentoService commentoService;

    @GetMapping
    public List<Todo> getAllTodo() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo modificato) {
        Todo esistente = todoService.findById(id);
        esistente.setDescrizione(modificato.getDescrizione());
        esistente.setCompletato(modificato.isCompletato());
        return todoService.save(esistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.ok("ToDo eliminato");
    }

    //  ENDPOINT SPECIFICO: tutti i commenti legati a un ToDo
    @GetMapping("/{id}/commenti")
    public List<Commento> getCommentiByTodo(@PathVariable Long id) {
        return commentoService.findByTodoId(id);
    }
}