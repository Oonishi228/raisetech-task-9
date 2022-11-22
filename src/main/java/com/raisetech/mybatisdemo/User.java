package com.raisetech.mybatisdemo;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
public class User {
    private int id;

    private String name;

    private String residence;

    public User(int id, String name, String residence) {
        this.id = id;
        this.name = name;
        this.residence = residence;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getResidence() {
        return residence;
    }
}
