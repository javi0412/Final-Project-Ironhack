package com.ironhack.expensesservice.controller.interfaces;

import com.ironhack.expensesservice.controller.dtos.AddGroupDTO;
import com.ironhack.expensesservice.controller.dtos.GroupDTO;

import java.util.List;

public interface IGroupController {

    List<GroupDTO> getAllGroups();
    GroupDTO getGroupById(Integer id);
    GroupDTO add(AddGroupDTO addGroupDTO);
    GroupDTO delete(Integer id);
}
