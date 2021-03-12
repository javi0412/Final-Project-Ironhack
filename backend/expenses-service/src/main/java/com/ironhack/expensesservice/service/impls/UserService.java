package com.ironhack.expensesservice.service.impls;

import com.ironhack.expensesservice.controller.dtos.UserDTO;
import com.ironhack.expensesservice.model.Users;
import com.ironhack.expensesservice.repository.UserRepository;
import com.ironhack.expensesservice.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;



    public List<UserDTO> getAll() {
        List<UserDTO> usersDTO = new ArrayList<>();
        List<Users> users = userRepository.findAll();

        for(Users user:users){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());
            userDTO.setBalanceSheet(user.getBalanceSheet());

            usersDTO.add(userDTO);
        }
        return usersDTO;
    }

    public UserDTO getById(Integer id) {
        if(!userRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        Users user = userRepository.findById(id).get();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setBalanceSheet(user.getBalanceSheet());

        return userDTO;
    }

    public UserDTO delete(Integer id) {
        if(!userRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        Users user = userRepository.findById(id).get();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setBalanceSheet(user.getBalanceSheet());

        userRepository.deleteById(id);

        return userDTO;
    }

    public UserDTO add(UserDTO userDTO) {
        Users user = new Users();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user = userRepository.save(user);

        userDTO.setId(user.getId());

        return userDTO;
    }

    public UserDTO update(Integer id, Users userDTO) {
        if(!userRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        Users user = userRepository.findById(id).get();
        user.setId(id);
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setBalanceSheet(userDTO.getBalanceSheet());
        user = userRepository.save(user);

        UserDTO userDTO1 = new UserDTO();
        userDTO1.setId(user.getId());
        userDTO1.setPhone(user.getPhone());
        userDTO1.setName(user.getName());
        userDTO1.setEmail(user.getEmail());
        userDTO1.setBalanceSheet(user.getBalanceSheet());
        return userDTO1;
    }

}