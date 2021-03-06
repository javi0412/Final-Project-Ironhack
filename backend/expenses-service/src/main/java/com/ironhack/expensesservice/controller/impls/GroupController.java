package com.ironhack.expensesservice.controller.impls;

import com.ironhack.expensesservice.controller.dtos.AddGroupDTO;
import com.ironhack.expensesservice.controller.dtos.BalanceDTO;
import com.ironhack.expensesservice.controller.dtos.GroupDTO;
import com.ironhack.expensesservice.controller.interfaces.IGroupController;
import com.ironhack.expensesservice.service.impls.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class GroupController implements IGroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/groups")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDTO> getAllGroups() {
        return groupService.getAll();
    }

    @GetMapping("/group/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GroupDTO getGroupById(@PathVariable Integer id) {
        return groupService.getById(id);
    }

    @PostMapping("/group")
    @ResponseStatus(HttpStatus.CREATED)
    public GroupDTO add(@RequestBody AddGroupDTO groupDTO) {
        return groupService.add(groupDTO);
    }

    @DeleteMapping("/group/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public GroupDTO delete(@PathVariable Integer id) {
        return groupService.delete(id);
    }

    @GetMapping("/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<BalanceDTO> getBalance(@PathVariable Integer id){
        return groupService.getBalance(id);
    }
}
