package com.ironhack.expensesservice.service.impls;

import com.ironhack.expensesservice.controller.dtos.AddGroupDTO;
import com.ironhack.expensesservice.controller.dtos.GroupDTO;
import com.ironhack.expensesservice.controller.dtos.UserDTO;
import com.ironhack.expensesservice.model.Party;
import com.ironhack.expensesservice.model.Users;
import com.ironhack.expensesservice.repository.GroupRepository;
import com.ironhack.expensesservice.repository.UserRepository;
import com.ironhack.expensesservice.service.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService implements IGroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public List<GroupDTO> getAll() {
        List<GroupDTO> groupDTOs = new ArrayList<>();
        List<Party> groups = groupRepository.findAll();

        for(Party group:groups){
            GroupDTO groupDTO = new GroupDTO();
            groupDTO.setId(group.getId());
            groupDTO.setName(group.getName());
            List<UserDTO> userDTOs = new ArrayList<>();
            for(Users user: group.getUserList()){
                UserDTO userDTO = new UserDTO();
                userDTO.setId(user.getId());
                userDTO.setName(user.getName());
                userDTO.setEmail(user.getEmail());
                userDTO.setPhone(user.getPhone());
                userDTOs.add(userDTO);
            }
            groupDTO.setUserList(userDTOs);
            groupDTOs.add(groupDTO);
        }

        return groupDTOs;
    }

    public GroupDTO getById(Integer id) {
        if(!groupRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found");
        }
        Party group = groupRepository.findById(id).get();
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName(group.getName());
        groupDTO.setId(group.getId());

        List<UserDTO> userDTOs = new ArrayList<>();
        List<Users> users = group.getUserList();
        for(Users user: users){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());
            userDTOs.add(userDTO);
        }
        groupDTO.setUserList(userDTOs);

        return groupDTO;
    }

    public GroupDTO add(AddGroupDTO addGroupDTO) {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName(addGroupDTO.getName());
        Party group = new Party();
        group.setName(addGroupDTO.getName());
        List<UserDTO> userDTOS = new ArrayList<>();
        List<Users> userList = new ArrayList<>();
        for(Integer userId: addGroupDTO.getUserIdList()){
            UserDTO userDTO = userService.getById(userId);
            userDTOS.add(userDTO);
            Users user = new Users();
            user.setId(userDTO.getId());
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPhone(userDTO.getPhone());
//            Users user = userRepository.findById(userId).get();
            userList.add(user);
        }
        groupDTO.setUserList(userDTOS);
        group.setUserList(userList);
        group = groupRepository.save(group);
        groupDTO.setId(group.getId());
        return groupDTO;
    }

    public GroupDTO delete(Integer id) {
        if(!groupRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found");
        }
        Party group = groupRepository.findById(id).get();
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName(group.getName());
        List<UserDTO> userDTOs = new ArrayList<>();
        for(Users user: group.getUserList()){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());
            userDTOs.add(userDTO);
        }
        groupDTO.setUserList(userDTOs);
        groupRepository.deleteById(id);

        return groupDTO;
    }
}
