package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

 private final TodoRepository todoRepository;

 @Autowired
 public TodoService(TodoRepository todoRepository) {
     this.todoRepository = todoRepository;
 }

 public List<Todo> getAllTodos() {
     return todoRepository.findAll();
 }

 public Todo getTodoById(Long id) {
     return todoRepository.findById(id).orElse(null);
 }

 public Todo addTodo(Todo todo) {
     return todoRepository.save(todo);
 }

 public Todo updateTodo(Long id, Todo updatedTodo) {
     Todo existingTodo = todoRepository.findById(id).orElse(null);
     if (existingTodo != null) {
         existingTodo.setTitle(updatedTodo.getTitle());
         existingTodo.setDescription(updatedTodo.getDescription());
         existingTodo.setCompleted(updatedTodo.isCompleted());
         todoRepository.save(existingTodo);
     }
     return existingTodo;
 }

 public void deleteTodo(Long id) {
     todoRepository.deleteById(id);
 }
}


