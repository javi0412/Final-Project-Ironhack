package com.ironhack.edgeservice.service.impls;

import com.ironhack.edgeservice.client.ExpenseClient;
import com.ironhack.edgeservice.client.TodoClient;
import com.ironhack.edgeservice.dtos.*;
import com.ironhack.edgeservice.service.interfaces.IEdgeService;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.util.List;

@Service
public class EdgeService implements IEdgeService {

    @Autowired
    private ExpenseClient expenseClient;

    @Autowired
    private TodoClient todoClient;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

//    @Bean
//    public Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {
//
//        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
//                .failureRateThreshold(50)
//                .waitDurationInOpenState(Duration.ofMillis(1000))
//                .slidingWindowSize(2)
//                .ignoreExceptions(SalesRepNotFoundException.class)
//                .build();
//        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
//                .timeoutDuration(Duration.ofSeconds(4))
//                .build();
//
//        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
//                .circuitBreakerConfig(circuitBreakerConfig)
//                .timeLimiterConfig(timeLimiterConfig)
//                .build());
//    }

    public List<UserDTO> showUsers() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("user");

        List<UserDTO> userDTOList = circuitBreaker.run(()->expenseClient.getAll(),
                throwable -> getAllUsersThrowback());

        return userDTOList;
    }

    private List<UserDTO> getAllUsersThrowback() {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Expenses service is unavailable");
    }

    public UserDTO showUserById(Integer id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("user");

        UserDTO userDTO = circuitBreaker.run(()->expenseClient.getById(id), throwable -> getUserByIdThrowback());

        return userDTO;
    }

    private UserDTO getUserByIdThrowback() {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Expenses service is unavailable");
    }

    public UserDTO deleteUserById(Integer id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("user");

        UserDTO userDTO = circuitBreaker.run(()->expenseClient.deleteById(id), throwable -> getUserByIdThrowback());

        return userDTO;
    }

    public UserDTO createUser(UserDTO userDTO) {

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("user");

        userDTO.setId(null);

        UserDTO userDTO1 = circuitBreaker.run(()->expenseClient.add(userDTO), throwable -> getUserByIdThrowback());

        return userDTO1;
    }

    public UserDTO updateUser(Integer id, Users userDTO) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("user");

        UserDTO userDTO1 = circuitBreaker.run(()->expenseClient.update(id, userDTO),throwable -> getUserByIdThrowback());

        return userDTO1;
    }

    public List<GroupDTO> showGroups() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("group");

        List<GroupDTO> groupDTOList = circuitBreaker.run(()->expenseClient.getAllGroups(),
                throwable -> getAllGroupsThrowback());

        return groupDTOList;
    }

    private List<GroupDTO> getAllGroupsThrowback() {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Expenses service is unavailable");
    }

    public GroupDTO showGroupById(Integer id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("group");

        GroupDTO groupDTO = circuitBreaker.run(()->expenseClient.getGroupById(id),
                throwable -> getGroupByIdThrowback());

        return groupDTO;
    }

    private GroupDTO getGroupByIdThrowback() {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Expenses service is unavailable");
    }

    public GroupDTO createGroup(AddGroupDTO groupDTO) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("group");

        GroupDTO groupDTO1 = circuitBreaker.run(()->expenseClient.add(groupDTO),
                throwable -> getGroupByIdThrowback());

        return groupDTO1;
    }

    public GroupDTO deleteGroup(Integer id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("group");

        GroupDTO groupDTO1 = circuitBreaker.run(()->expenseClient.delete(id),
                throwable -> getGroupByIdThrowback());

        return groupDTO1;
    }

    public List<ExpenseDTO> getAllExpensesByGroup(Integer id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("expenses");

        List<ExpenseDTO> expenseDTOList = circuitBreaker.run(()->expenseClient.getAllExpensesByGroup(id),
                throwable -> getExpensesThrowback());

        return expenseDTOList;
    }

    private List<ExpenseDTO> getExpensesThrowback() {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Expenses service is unavailable");

    }

    public ExpenseDTO createExpense(AddExpenseDTO addExpenseDTO) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("expenses");

        ExpenseDTO expenseDTO = circuitBreaker.run(()->expenseClient.addExpense(addExpenseDTO),
                throwable -> getExpenseByIdThrowback());

        return expenseDTO;
    }

    private ExpenseDTO getExpenseByIdThrowback() {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Expenses service is unavailable");
    }

    public ExpenseDTO deleteExpense(Integer id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("expenses");

        ExpenseDTO expenseDTO = circuitBreaker.run(()->expenseClient.deleteExpense(id),
                throwable -> getExpenseByIdThrowback());

        return expenseDTO;
    }

    public List<TodoDTO> showAllTodos() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("todo");

        List<TodoDTO> todoDTOList = circuitBreaker.run(()->todoClient.getAll(),
                throwable -> getAllTodoThrowback());

        return todoDTOList;
    }

    private List<TodoDTO> getAllTodoThrowback() {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Todo service is unavailable");
    }

    public TodoDTO showTodoById(Integer id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("todo");

        TodoDTO todoDTO = circuitBreaker.run(()->todoClient.getById(id),
                throwable -> getTodoByIdThrowback());

        return todoDTO;
    }

    private TodoDTO getTodoByIdThrowback() {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Todo service is unavailable");
    }

    public TodoDTO createTodo(TodoDTO todoDTO) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("todo");

        TodoDTO todoDTO1 = circuitBreaker.run(()->todoClient.add(todoDTO),
                throwable -> getTodoByIdThrowback());

        return todoDTO1;
    }

    public TodoDTO deleteTodo(Integer id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("todo");

        TodoDTO todoDTO1 = circuitBreaker.run(()->todoClient.delete(id),
                throwable -> getTodoByIdThrowback());

        return todoDTO1;
    }
}
