package com.ironhack.expensesservice.controller.impls;

import com.ironhack.expensesservice.controller.dtos.UserDTO;
import com.ironhack.expensesservice.controller.interfaces.IUserController;
import com.ironhack.expensesservice.service.impls.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController implements IUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAll(){
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UserDTO deleteById(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO add(@RequestBody UserDTO userDTO) {
        return userService.add(userDTO);
    }
}
