package com.ironhack.expensesservice.controller.interfaces;

import com.ironhack.expensesservice.controller.dtos.UserDTO;
import com.ironhack.expensesservice.model.Users;

import java.util.List;

public interface IUserController {

    List<UserDTO> getAll();

    UserDTO getById(Integer id);

    UserDTO deleteById(Integer id);

    UserDTO add(UserDTO userDTO);

    UserDTO update(Integer id, Users userDTO);

}
