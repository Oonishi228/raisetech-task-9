package com.raisetech.mybatisdemo;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
public class User {
    private int id;
    @NotBlank
    @Length(max = 20)
    private String name;
    @NotBlank
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
