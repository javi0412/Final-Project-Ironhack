package com.ironhack.edgeservice.controller.impls;

import com.ironhack.edgeservice.controller.interfaces.IEdgeController;
import com.ironhack.edgeservice.dtos.*;
import com.ironhack.edgeservice.service.impls.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EdgeController implements IEdgeController {

    @Autowired
    private EdgeService edgeService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> showUsers(){
        return edgeService.showUsers();
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO showUserById(@PathVariable Integer id){
        return edgeService.showUserById(id);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UserDTO deleteUserById(@PathVariable Integer id){
        return edgeService.deleteUserById(id);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return edgeService.createUser(userDTO);
    }

    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UserDTO updateUser(@PathVariable Integer id, @RequestBody Users userDTO){
        return edgeService.updateUser(id,userDTO);
    }

    /*------------------------------------ GROUP --------------------------------------*/

    @GetMapping("/groups")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDTO> showGroups(){
        return edgeService.showGroups();
    }

    @GetMapping("/group/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GroupDTO showGroupById(@PathVariable Integer id){
        return edgeService.showGroupById(id);
    }

    @PostMapping("/group")
    @ResponseStatus(HttpStatus.CREATED)
    public GroupDTO createGroup(@RequestBody AddGroupDTO groupDTO){
        return edgeService.createGroup(groupDTO);
    }

    @DeleteMapping("/group/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public GroupDTO deleteGroup(@PathVariable Integer id){
        return edgeService.deleteGroup(id);
    }

    /*----------------------------------- EXPENSES ------------------------------------*/

    @GetMapping("/expenses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ExpenseDTO> getAllExpensesByGroup(@PathVariable Integer id){
        return edgeService.getAllExpensesByGroup(id);
    }

    @PostMapping("/expense")
    @ResponseStatus(HttpStatus.CREATED)
    public ExpenseDTO createExpense(@RequestBody AddExpenseDTO addExpenseDTO){
        return edgeService.createExpense(addExpenseDTO);
    }

    @DeleteMapping("/expense/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ExpenseDTO deleteExpense(@PathVariable Integer id){
        return edgeService.deleteExpense(id);
    }

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<TodoDTO> showAllTodos(){
        return edgeService.showAllTodos();
    }

    @GetMapping("/todo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TodoDTO showTodoById(@PathVariable Integer id){
        return edgeService.showTodoById(id);
    }

    @PostMapping("/todo")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoDTO createTodo(@RequestBody TodoDTO todoDTO){
        return edgeService.createTodo(todoDTO);
    }

    @DeleteMapping("/todo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TodoDTO deleteTodo(@PathVariable Integer id){
        return edgeService.deleteTodo(id);
    }
}
