package com.ironhack.expensesservice.service.interfaces;

import com.ironhack.expensesservice.controller.dtos.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> getAll();

    UserDTO getById(Integer id);

    UserDTO delete(Integer id);

    UserDTO add(UserDTO userDTO);
}
