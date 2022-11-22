package com.raisetech.mybatisdemo.controller;

import com.raisetech.mybatisdemo.entity.User;
import lombok.Getter;

@Getter
public class UserResponse {
    private int id;
    private String name;

    private String residence;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.residence = user.getResidence();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }
}
