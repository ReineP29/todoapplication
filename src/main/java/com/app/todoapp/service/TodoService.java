package com.app.todoapp.service;

import com.app.todoapp.dto.TodoDto;

import java.util.List;

public interface TodoService {

    List<TodoDto> getTodos();
    TodoDto addTodo(TodoDto dto);
    void deleteTodo(Long id);

    void updateTodo(Long id, TodoDto dto);
}
