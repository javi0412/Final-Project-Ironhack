package com.ironhack.expensesservice.controller.dtos;

import java.util.List;

public class GroupDTO {
    private Integer id;
    private String name;
    private List<UserDTO> userList;

    public GroupDTO(Integer id, String name, List<UserDTO> userList) {
        this.id = id;
        this.name = name;
        this.userList = userList;
    }

    public GroupDTO(String name, List<UserDTO> userList) {
        this.name = name;
        this.userList = userList;
    }

    public GroupDTO() {
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

    public List<UserDTO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDTO> userList) {
        this.userList = userList;
    }
}
