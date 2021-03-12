package com.ironhack.edgeservice.service.interfaces;

import com.ironhack.edgeservice.dtos.*;

import java.util.List;

public interface IEdgeService {
    List<UserDTO> showUsers();

    UserDTO showUserById(Integer id);

    UserDTO deleteUserById(Integer id);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Integer id, Users userDTO);

    List<GroupDTO> showGroups();

    GroupDTO showGroupById(Integer id);

    GroupDTO createGroup(AddGroupDTO groupDTO);

    GroupDTO deleteGroup(Integer id);

    List<ExpenseDTO> getAllExpensesByGroup(Integer id);

    ExpenseDTO createExpense(AddExpenseDTO addExpenseDTO);

    ExpenseDTO deleteExpense(Integer id);

    List<TodoDTO> showAllTodos();

    TodoDTO showTodoById(Integer id);

    TodoDTO createTodo(TodoDTO todoDTO);

    TodoDTO deleteTodo(Integer id);
}
