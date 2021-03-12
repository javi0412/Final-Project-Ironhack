package com.ironhack.expensesservice.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    @ManyToMany(mappedBy = "userList")
    private List<Party> parties;
    @OneToMany(mappedBy = "paidBy")
    private List<Expense> expenses;
    @ElementCollection(targetClass = Double.class)
    @MapKeyClass(String.class)
    private Map<String, Double> balanceSheet;

    public Users(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Users(Integer id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Users() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Party> getParties() {
        return parties;
    }

    public void setParties(List<Party> parties) {
        this.parties = parties;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public Map<String, Double> getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(Map<String, Double> balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public void addBalanceSheet(String user, Double balance) {
        this.balanceSheet.put(user, balance);
    }
}
