package com.raisetech.mybatisdemo;

import lombok.Getter;

@Getter
public class NameResponse {
    private int id;
    private String name;

    private String residence;

    public NameResponse(Name name) {
        this.id = name.getId();
        this.name = name.getName();
        this.residence = name.getResidence();
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
