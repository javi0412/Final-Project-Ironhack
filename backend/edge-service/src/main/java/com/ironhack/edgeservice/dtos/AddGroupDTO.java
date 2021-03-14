package com.ironhack.edgeservice.dtos;

import java.util.List;

public class AddGroupDTO {
    private String name;
    private List<Integer> userIdList;

    public AddGroupDTO( String name, List<Integer> userIdList) {
        this.name = name;
        this.userIdList = userIdList;
    }

    public AddGroupDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Integer> userIdList) {
        this.userIdList = userIdList;
    }
}
