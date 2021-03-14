package com.ironhack.expensesservice.service.impls;

import com.ironhack.expensesservice.controller.dtos.AddGroupDTO;
import com.ironhack.expensesservice.controller.dtos.BalanceDTO;
import com.ironhack.expensesservice.controller.dtos.GroupDTO;
import com.ironhack.expensesservice.controller.dtos.UserDTO;
import com.ironhack.expensesservice.model.Expense;
import com.ironhack.expensesservice.model.Party;
import com.ironhack.expensesservice.model.Users;
import com.ironhack.expensesservice.repository.ExpenseRepository;
import com.ironhack.expensesservice.repository.GroupRepository;
import com.ironhack.expensesservice.repository.UserRepository;
import com.ironhack.expensesservice.service.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.IntStream;

@Service
public class GroupService implements IGroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseRepository expenseRepository;


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
                userDTO.setBalanceSheet(user.getBalanceSheet());
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
            userDTO.setBalanceSheet(user.getBalanceSheet());
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
        for(int i = 0;i<addGroupDTO.getUserIdList().size();i++){
            UserDTO userDTO = userService.getById(addGroupDTO.getUserIdList().get(i));
            Users user = new Users();
            user.setId(userDTO.getId());
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPhone(userDTO.getPhone());
            Map<String, Double> balanceSheet = new HashMap<>();
            user.setBalanceSheet(balanceSheet);
            for(int j =0;j<addGroupDTO.getUserIdList().size();j++){
                if(i!=j){
                    user.addBalanceSheet(userService.getById(addGroupDTO.getUserIdList().get(j)).getName(), 0d  );
                }
            }
            userDTO.setBalanceSheet(user.getBalanceSheet());
            userList.add(user);
            userDTOS.add(userDTO);
            userService.update(addGroupDTO.getUserIdList().get(i),user);
        }

        group.setUserList(userList);
        groupDTO.setUserList(userDTOS);
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
            userDTO.setBalanceSheet(user.getBalanceSheet());
            userDTOs.add(userDTO);
        }
        List<Expense> expenseList = expenseRepository.getExpensesByGroupId(id);
        for(Expense expense :expenseList){
            expenseRepository.deleteById(expense.getId());
        }
        groupDTO.setUserList(userDTOs);
        groupRepository.deleteById(id);

        return groupDTO;
    }

    public List<BalanceDTO> getBalance(Integer id) {
        List<Integer> idList = groupRepository.getIdsFromParty();
        List<List<Double>> balanceSheet = new ArrayList<>();
        List<Double> summedBalance =new ArrayList<>();
        for(int i = 0; i<idList.size();i++){
            List<Double> balanceList= userRepository.getNamesFromParty(idList.get(i));
            balanceSheet.add(balanceList);
            Double summed = 0d;
            for(int j = 0;j<balanceSheet.get(i).size();j++){
                summed  += balanceSheet.get(i).get(j);
            }
            summedBalance.add(summed);
        }
        int minIndex = summedBalance.indexOf(Collections.min(summedBalance));

        List<BalanceDTO> balance = new ArrayList<>();

        return null;
    }
}
