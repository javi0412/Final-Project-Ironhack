package com.ironhack.edgeservice.dtos;

import java.util.Map;

public class UserDTO {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private Map<String, Double> balanceSheet;

    public UserDTO(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public UserDTO(Integer id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public UserDTO() {
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

    public Map<String, Double> getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(Map<String, Double> balanceSheet) {
        this.balanceSheet = balanceSheet;
    }
}