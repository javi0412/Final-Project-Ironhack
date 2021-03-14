package com.ironhack.expensesservice.service.interfaces;

import com.ironhack.expensesservice.controller.dtos.UserDTO;
import com.ironhack.expensesservice.model.Users;

import java.util.List;

public interface IUserService {

    List<UserDTO> getAll();

    UserDTO getById(Integer id);

    UserDTO delete(Integer id);

    UserDTO add(UserDTO userDTO);

    UserDTO update(Integer id, Users userDTO);
}
