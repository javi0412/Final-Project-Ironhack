package com.ironhack.todosservice.service.interfaces;

import com.ironhack.todosservice.controller.dto.TodoDTO;

import java.util.List;

public interface ITodoService {
    List<TodoDTO> getAll();
    TodoDTO getById(Integer id);
    TodoDTO add(TodoDTO todoDTO);
    TodoDTO delete(Integer id);
}
