package com.ironhack.expensesservice.controller.interfaces;

import com.ironhack.expensesservice.controller.dtos.AddExpenseDTO;
import com.ironhack.expensesservice.controller.dtos.ExpenseDTO;


import java.util.List;

public interface IExpenseController {

    List<ExpenseDTO> getAllExpensesByGroup(Integer id);
    ExpenseDTO addExpense(AddExpenseDTO addExpenseDTO);
    ExpenseDTO deleteExpense(Integer id);
}
