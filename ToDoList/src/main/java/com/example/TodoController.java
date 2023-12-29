package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

 private final TodoService todoService;

 @Autowired
 public TodoController(TodoService todoService) {
     this.todoService = todoService;
 }

 @GetMapping
 public List<Todo> getAllTodos() {
     return todoService.getAllTodos();
 }
 
 @GetMapping("/{id}")
 public Todo getTodoById(@PathVariable Long id) {
     return todoService.getTodoById(id);
 }

 @PostMapping
 public Todo addTodo(@RequestBody Todo todo) {
     return todoService.addTodo(todo);
 }
 
 
 

 @PutMapping("/{id}")
 public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
     return todoService.updateTodo(id, updatedTodo);
 }

 @DeleteMapping("/{id}")
 public void deleteTodo(@PathVariable Long id) {
     todoService.deleteTodo(id);
 }
}

