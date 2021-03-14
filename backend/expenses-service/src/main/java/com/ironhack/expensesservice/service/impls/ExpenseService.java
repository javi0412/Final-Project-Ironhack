package com.ironhack.expensesservice.service.impls;

import com.ironhack.expensesservice.controller.dtos.AddExpenseDTO;
import com.ironhack.expensesservice.controller.dtos.BalanceDTO;
import com.ironhack.expensesservice.controller.dtos.ExpenseDTO;
import com.ironhack.expensesservice.controller.dtos.UserDTO;
import com.ironhack.expensesservice.model.Expense;
import com.ironhack.expensesservice.model.Users;
import com.ironhack.expensesservice.repository.ExpenseRepository;
import com.ironhack.expensesservice.repository.GroupRepository;
import com.ironhack.expensesservice.repository.UserRepository;
import com.ironhack.expensesservice.service.interfaces.IExpenseService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ExpenseService implements IExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public List<ExpenseDTO> getAllExpensesByGroup(Integer id) {
        List<Expense> expenses = expenseRepository.getExpensesByGroupId(id);
        List<ExpenseDTO> expenseDTOS = new ArrayList<>();
        for(Expense eachExpense:expenses){
            ExpenseDTO expenseDTO = new ExpenseDTO();
            expenseDTO.setId(eachExpense.getId());
            expenseDTO.setAmount(eachExpense.getAmount());
            expenseDTO.setDescription(eachExpense.getDescription());
            expenseDTO.setCreationDate(eachExpense.getCreationDate());
            expenseDTO.setPartyId(eachExpense.getParty().getId());
            Users user = eachExpense.getPaidBy();
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());
            userDTO.setBalanceSheet(user.getBalanceSheet());
            expenseDTO.setPaidBy(userDTO);
            expenseDTOS.add(expenseDTO);
        }
        return expenseDTOS;
    }

    public ExpenseDTO addExpense(AddExpenseDTO addExpenseDTO) {
        Expense expense = new Expense();
        expense.setAmount(addExpenseDTO.getAmount());
        expense.setDescription(addExpenseDTO.getDescription());
        if(!userRepository.existsById(addExpenseDTO.getPaidById())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paying user not found");
        }
        if(!groupRepository.existsById(addExpenseDTO.getPartyId())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Party not found");

        }
        expense.setPaidBy(userRepository.findById(addExpenseDTO.getPaidById()).get());
        expense.setParty(groupRepository.findById(addExpenseDTO.getPartyId()).get());
        expense = expenseRepository.save(expense);
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setId(expense.getId());
        expenseDTO.setPaidBy(userService.getById(expense.getPaidBy().getId()));
        expenseDTO.setDescription(expense.getDescription());
        expenseDTO.setAmount(expense.getAmount());
        expenseDTO.setPartyId(expense.getParty().getId());
        expenseDTO.setCreationDate(expense.getCreationDate());
        List<Users> userList = expense.getParty().getUserList();
        BigDecimal splitAmount = expenseDTO.getAmount().divide(BigDecimal.valueOf(userList.size()),2, RoundingMode.HALF_UP);
        Users paidBy = userRepository.findById(expenseDTO.getPaidBy().getId()).get();
        String paidByName = paidBy.getName();
        for(int i = 0; i<userList.size();i++){
            Map<String, Double> map = userList.get(i).getBalanceSheet();
            if(userList.get(i).getId() == paidBy.getId()){
                for(int j = 0;j<userList.get(i).getBalanceSheet().size() ;j++){
                    Set<String> keySet = map.keySet();
                    map.replace((String) keySet.toArray()[j],map.get(keySet.toArray()[j])+splitAmount.doubleValue());
                }
            } else{
                    map.replace(paidByName,map.get(paidByName)-splitAmount.doubleValue());
                }
            userList.get(i).setBalanceSheet(map);
            userService.update(userList.get(i).getId(), userList.get(i));
        }

        return expenseDTO;

    }

    public ExpenseDTO deleteExpense(Integer id) {
        if(!expenseRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found");
        }
        Expense expense = expenseRepository.findById(id).get();
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setId(expense.getId());
        expenseDTO.setAmount(expense.getAmount());
        expenseDTO.setCreationDate(expense.getCreationDate());
        expenseDTO.setDescription(expense.getDescription());
        Users user = expense.getPaidBy();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        expenseDTO.setPaidBy(userDTO);
        expenseRepository.deleteById(id);
        return expenseDTO;
    }

//    public BalanceDTO getPartyBalance(Integer id){
//        List<Object[]> partyNames = userRepository.getNamesFromParty(id);
//        BalanceDTO balanceDTO = new BalanceDTO();
//        for(int i = 0; i<partyNames.size(); i++){
//
//        }
//
//    }


}
