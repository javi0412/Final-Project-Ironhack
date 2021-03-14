package com.ironhack.expensesservice.controller.dtos;

import java.util.Map;

public class BalanceDTO {
    private String payer;
    private String debtor;
    private double amount;

    public BalanceDTO(String payer, String debtor, double amount) {
        this.payer = payer;
        this.debtor = debtor;
        this.amount = amount;
    }

    public BalanceDTO() {
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
