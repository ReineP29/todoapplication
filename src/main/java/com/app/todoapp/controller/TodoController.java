package com.app.todoapp.controller;

import com.app.todoapp.dto.TodoDto;
import com.app.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping
    public ResponseEntity<List<TodoDto>> getTodos(){
        return new ResponseEntity<>(service.getTodos(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addTodo(@RequestBody TodoDto dto){
        return new ResponseEntity<>(service.addTodo(dto), HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{id}")
    public void deleteTodo(@PathVariable Long id){
         service.deleteTodo(id);
    }

    @PatchMapping(value="/{id}")
    public void updateTodo(@PathVariable Long id, @RequestBody TodoDto dto){
        service.updateTodo(id,dto);
    }

}
