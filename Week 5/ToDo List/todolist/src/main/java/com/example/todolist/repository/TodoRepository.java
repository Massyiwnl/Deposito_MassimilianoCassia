package com.example.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
List<Todo> findByUtenteId(Long utenteId);
}