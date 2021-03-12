package com.ironhack.todosservice.controller.impls;

import com.ironhack.todosservice.controller.dto.TodoDTO;
import com.ironhack.todosservice.controller.interfaces.ITodoController;
import com.ironhack.todosservice.service.impls.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TodoController implements ITodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<TodoDTO> getAll() {
        return todoService.getAll();
    }

    @GetMapping("/todo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TodoDTO getById(@PathVariable Integer id) {
        return todoService.getById(id);
    }

    @PostMapping("/todo")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoDTO add(@RequestBody TodoDTO todoDTO) {
        return todoService.add(todoDTO);
    }

    @DeleteMapping("/todo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TodoDTO delete(@PathVariable Integer id) {
        return todoService.delete(id);
    }
}
