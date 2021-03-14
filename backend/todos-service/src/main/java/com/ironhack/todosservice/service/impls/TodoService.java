package com.ironhack.todosservice.service.impls;

import com.ironhack.todosservice.controller.dto.TodoDTO;
import com.ironhack.todosservice.model.Todo;
import com.ironhack.todosservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoDTO> getAll() {
        List<Todo> todoList = todoRepository.findAll();
        List<TodoDTO> todoDTOList = new ArrayList<>();
        for(Todo todo:todoList){
            TodoDTO todoDTO = new TodoDTO();
            todoDTO.setId(todo.getId());
            todoDTO.setCreationDate(todo.getCreationDate());
            todoDTO.setDescription(todo.getDescription());
            todoDTO.setDone(todo.isDone());
            todoDTO.setDueDate(todo.getDueDate());
            todoDTOList.add(todoDTO);
        }
        return todoDTOList;
    }

    public TodoDTO getById(Integer id) {
        if(!todoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "To-do not found ");
        }
        Todo todo = todoRepository.findById(id).get();
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setId(todo.getId());
        todoDTO.setCreationDate(todo.getCreationDate());
        todoDTO.setDescription(todo.getDescription());
        todoDTO.setDone(todo.isDone());
        todoDTO.setDueDate(todo.getDueDate());

        return todoDTO;
    }

    public TodoDTO add(TodoDTO todoDTO) {
        Todo todo = new Todo();
        todo.setDescription(todoDTO.getDescription());
        todo.setCreationDate(todoDTO.getCreationDate());
        todo.setDescription(todoDTO.getDescription());
        todo.setDone(todoDTO.isDone());
        todo.setDueDate(todoDTO.getDueDate());
        todo = todoRepository.save(todo);
        todoDTO.setId(todo.getId());
        return todoDTO;
    }

    public TodoDTO delete(Integer id) {
        if(!todoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "To-do not found ");
        }
        Todo todo = todoRepository.findById(id).get();
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setId(todo.getId());
        todoDTO.setCreationDate(todo.getCreationDate());
        todoDTO.setDescription(todo.getDescription());
        todoDTO.setDone(todo.isDone());
        todoDTO.setDueDate(todo.getDueDate());
        todoRepository.deleteById(id);

        return todoDTO;
    }
}
