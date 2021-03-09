package com.ironhack.expensesservice.service.interfaces;

import com.ironhack.expensesservice.controller.dtos.AddExpenseDTO;
import com.ironhack.expensesservice.controller.dtos.ExpenseDTO;

import java.util.List;

public interface IExpenseService {

    List<ExpenseDTO> getAllExpensesByGroup(Integer id);
    ExpenseDTO addExpense(AddExpenseDTO addExpenseDTO);
    ExpenseDTO deleteExpense(Integer id);


}
