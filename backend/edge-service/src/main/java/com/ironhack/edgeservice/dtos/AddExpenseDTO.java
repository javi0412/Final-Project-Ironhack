package com.ironhack.edgeservice.dtos;

import java.math.BigDecimal;

public class AddExpenseDTO {
    private BigDecimal amount;
    private String description;
    private Integer paidById;
    private Integer partyId;

    public AddExpenseDTO(BigDecimal amount, String description, Integer paidById, Integer partyId) {
        this.amount = amount;
        this.description = description;
        this.paidById = paidById;
        this.partyId = partyId;
    }

    public AddExpenseDTO() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPaidById() {
        return paidById;
    }

    public void setPaidById(Integer paidById) {
        this.paidById = paidById;
    }

    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }
}
