package br.com.renanfreitas.todos.desafio_todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.renanfreitas.todos.desafio_todolist.entity.Todo;
import br.com.renanfreitas.todos.desafio_todolist.service.TodoService;

@RestController
@RequestMapping
public class todoController {
    private TodoService todoService;
    
    public todoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List<Todo> Create(@RequestBody Todo todo){
        return todoService.create(todo);    
    }

    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }

    @PutMapping
    List<Todo> update(Todo todo){
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }
}
