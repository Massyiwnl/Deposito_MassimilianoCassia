package com.example.todolist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.todolist.model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
// Tutti i metodi CRUD già pronti!
}
