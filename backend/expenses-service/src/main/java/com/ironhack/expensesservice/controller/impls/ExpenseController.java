package com.ironhack.expensesservice.controller.impls;

import com.ironhack.expensesservice.controller.dtos.AddExpenseDTO;
import com.ironhack.expensesservice.controller.dtos.ExpenseDTO;
import com.ironhack.expensesservice.controller.interfaces.IExpenseController;
import com.ironhack.expensesservice.model.Expense;
import com.ironhack.expensesservice.service.impls.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ExpenseController implements IExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ExpenseDTO> getAllExpensesByGroup(@PathVariable Integer id){
        return expenseService.getAllExpensesByGroup(id);
    }

    @PostMapping("/expense")
    @ResponseStatus(HttpStatus.CREATED)
    public ExpenseDTO addExpense(@RequestBody AddExpenseDTO addExpenseDTO) {
        return expenseService.addExpense(addExpenseDTO);
    }

    @DeleteMapping("/expense/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ExpenseDTO deleteExpense(@PathVariable Integer id) {
        return expenseService.deleteExpense(id);
    }


}
