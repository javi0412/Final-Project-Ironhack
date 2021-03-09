package com.ironhack.expensesservice.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal amount;
    private String description;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users paidBy;
    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    private Date creationDate;
//    @OneToMany(mappedBy = "expense")
//    private List<Split> splits;

    public Expense(BigDecimal amount, String description, Users paidBy, Party party) {
        this.amount = amount;
        this.description = description;
        this.paidBy = paidBy;
        this.party = party;
        this.creationDate = new Date();
    }

    public Expense() {
        this.creationDate = new Date();
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

    public Users getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(Users paidBy) {
        this.paidBy = paidBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    //    public List<Split> getSplits() {
//        return splits;
//    }
//
//    public void setSplits(List<Split> splits) {
//        this.splits = splits;
//    }
}
