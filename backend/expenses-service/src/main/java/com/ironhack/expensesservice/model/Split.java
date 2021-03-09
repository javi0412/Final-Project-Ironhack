package com.ironhack.expensesservice.model;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//
//@Entity
//public class Split {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private User user;
//    private BigDecimal amount;
//
////    @OneToMany
////    private Expense expense;
//
//    public Split(User user, BigDecimal amount) {
//        this.user = user;
//        this.amount = amount;
//    }
//
//    public Split() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public BigDecimal getAmount() {
//        return amount;
//    }
//
//    public void setAmount(BigDecimal amount) {
//        this.amount = amount;
//    }
//}
