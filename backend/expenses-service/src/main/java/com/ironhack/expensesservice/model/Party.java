package com.ironhack.expensesservice.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany
    @JoinTable(
            name="users_group",
            joinColumns = {@JoinColumn(name = "party_id")},
            inverseJoinColumns = {@JoinColumn(name = "users_id")}
    )

    private List<Users> userList;
    @OneToMany(mappedBy = "party")
    private List<Expense> expenses;
//    private Map<String, Map<String, Double> > balanceSheet;


    public Party(Integer id, String name, List<Users> userList) {
        this.id = id;
        this.name = name;
        this.userList = userList;
    }

    public Party(String name, List<Users> userList) {
        this.name = name;
        this.userList = userList;
    }

    public Party() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Users> getUserList() {
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

//    public Map<String, Map<String, Double>> getBalanceSheet() {
//        return balanceSheet;
//    }
//
//    public void setBalanceSheet(Map<String, Map<String, Double>> balanceSheet) {
//        this.balanceSheet = balanceSheet;
//    }
}
