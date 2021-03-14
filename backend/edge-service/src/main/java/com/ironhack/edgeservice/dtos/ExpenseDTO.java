package com.ironhack.edgeservice.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseDTO {

    private Integer id;
    private BigDecimal amount;
    private String description;
    private UserDTO paidBy;
    private Integer partyId;
    private Date creationDate;

    public ExpenseDTO(BigDecimal amount, String description, UserDTO paidBy, Integer partyId, Date creationDate) {
        this.amount = amount;
        this.description = description;
        this.paidBy = paidBy;
        this.partyId = partyId;
        this.creationDate = creationDate;
    }

    public ExpenseDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public UserDTO getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(UserDTO paidBy) {
        this.paidBy = paidBy;
    }

    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
