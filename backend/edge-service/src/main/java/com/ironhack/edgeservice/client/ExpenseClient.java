package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.dtos.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("expenses-service")
public interface ExpenseClient {

    /*----------------------------------- USERS ------------------------------------*/

    @GetMapping("/users")
    public List<UserDTO> getAll();

    @GetMapping("/user/{id}")
    public UserDTO getById(@PathVariable Integer id);

    @DeleteMapping("/user/{id}")
    public UserDTO deleteById(@PathVariable Integer id);

    @PostMapping("/user")
    public UserDTO add(@RequestBody UserDTO userDTO);

    @PutMapping("/user/{id}")
    public UserDTO update(@PathVariable Integer id, @RequestBody Users userDTO);

    /*------------------------------------ GROUP --------------------------------------*/

    @GetMapping("/groups")
    public List<GroupDTO> getAllGroups();

    @GetMapping("/group/{id}")
    public GroupDTO getGroupById(@PathVariable Integer id);

    @PostMapping("/group")
    public GroupDTO add(@RequestBody AddGroupDTO groupDTO);

    @DeleteMapping("/group/{id}")
    public GroupDTO delete(@PathVariable Integer id);

    /*----------------------------------- EXPENSES ------------------------------------*/

    @GetMapping("/expenses/{id}")
    public List<ExpenseDTO> getAllExpensesByGroup(@PathVariable Integer id);

    @PostMapping("/expense")
    public ExpenseDTO addExpense(@RequestBody AddExpenseDTO addExpenseDTO) ;

    @DeleteMapping("/expense/{id}")
    public ExpenseDTO deleteExpense(@PathVariable Integer id);
}
