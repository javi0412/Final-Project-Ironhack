package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.dtos.TodoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("todo-service")
public interface TodoClient {

    @GetMapping("/todos")
    public List<TodoDTO> getAll();

    @GetMapping("/todo/{id}")
    public TodoDTO getById(@PathVariable Integer id);

    @PostMapping("/todo")
    public TodoDTO add(@RequestBody TodoDTO todoDTO);

    @DeleteMapping("/todo/{id}")
    public TodoDTO delete(@PathVariable Integer id);

}
