package com.app.todoapp.service.impl;

import com.app.todoapp.dto.TodoDto;
import com.app.todoapp.entity.Todo;
import com.app.todoapp.repository.TodoRepository;
import com.app.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository repo;


    @Override
    public List<TodoDto> getTodos() {
        return repo.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public TodoDto addTodo(TodoDto dto) {
        if(dto.getTitle().isBlank()){
            throw new IllegalArgumentException("Enter a valid title");
        }
        dto.setCompleted(false);
        Todo newTodo= convertToTodo(dto);
        newTodo= repo.save(newTodo);
        return convertToDto(newTodo);
    }



    @Override
    public void deleteTodo(Long id) {
        if(repo.findById(id).isEmpty()){
            throw new IllegalArgumentException("Enter a valid todo to delete");
        }
        repo.deleteById(id);

    }

    @Override
    public void updateTodo(Long id, TodoDto dto) {
        if(Optional.of(repo.findById(id)).isEmpty()){
            throw new IllegalArgumentException("Enter a valid todo to update");
        }
        Todo todo=repo.findById(id).get();
        todo.setCompleted(dto.isCompleted());
        repo.save(todo);


    }

    private TodoDto convertToDto(Todo newTodo) {
        TodoDto dto=new TodoDto();
        dto.setId(newTodo.getId());
        dto.setCompleted(newTodo.isCompleted());
        dto.setTitle(newTodo.getTitle());
        return dto;
    }
    private Todo convertToTodo(TodoDto dto){
        Todo newTodo=new Todo();
        newTodo.setCompleted(dto.isCompleted());
        newTodo.setId(dto.getId());
        newTodo.setTitle(dto.getTitle());
        return newTodo;
    }
}
