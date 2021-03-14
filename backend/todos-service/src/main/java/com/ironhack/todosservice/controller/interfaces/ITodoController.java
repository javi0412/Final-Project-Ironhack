package com.ironhack.todosservice.controller.interfaces;

import com.ironhack.todosservice.controller.dto.TodoDTO;

import java.util.List;

public interface ITodoController {
    List<TodoDTO> getAll();
    TodoDTO getById(Integer id);
    TodoDTO add(TodoDTO todoDTO);
    TodoDTO delete(Integer id);
}
