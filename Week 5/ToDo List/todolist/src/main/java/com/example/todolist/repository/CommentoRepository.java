package com.example.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.model.Commento;

public interface CommentoRepository extends JpaRepository<Commento, Long> {
List<Commento> findByTodoId(Long todoId);
}