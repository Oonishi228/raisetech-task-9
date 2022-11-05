package com.raisetech.mybatisdemo;

import lombok.Getter;

@Getter
public class Name {
    private int id;
    private String name;
    private String residence;

    public Name(int id, String name, String residence) {
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
