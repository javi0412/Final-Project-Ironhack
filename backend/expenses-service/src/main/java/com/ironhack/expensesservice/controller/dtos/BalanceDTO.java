package com.ironhack.expensesservice.controller.dtos;

import java.util.Map;

public class BalanceDTO {
    private Map<String, Double> balance;

    public BalanceDTO() {
    }

    public BalanceDTO(Map<String, Double> balance) {
        this.balance = balance;
    }

    public Map<String, Double> getBalance() {
        return balance;
    }

    public void setBalance(Map<String, Double> balance) {
        this.balance = balance;
    }

    public void addBalance(String name, double amount) {
        this.balance.put(name,amount);
    }
}
