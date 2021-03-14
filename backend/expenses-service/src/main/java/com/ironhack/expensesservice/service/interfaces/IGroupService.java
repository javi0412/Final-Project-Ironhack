package com.ironhack.expensesservice.service.interfaces;

import com.ironhack.expensesservice.controller.dtos.AddGroupDTO;
import com.ironhack.expensesservice.controller.dtos.BalanceDTO;
import com.ironhack.expensesservice.controller.dtos.GroupDTO;

import java.util.List;

public interface IGroupService {

    List<GroupDTO> getAll();
    GroupDTO getById(Integer id);
    GroupDTO add(AddGroupDTO addGroupDTO);
    GroupDTO delete(Integer id);
    List<BalanceDTO> getBalance(Integer id);
}
