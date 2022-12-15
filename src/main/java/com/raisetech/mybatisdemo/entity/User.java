package com.raisetech.mybatisdemo.entity;

import lombok.Getter;

import java.util.Objects;

@Getter
public class User {
    private int id;

    private String name;

    private String residence;

    public User(Integer id, String name, String residence) {
        this.id = id;
        this.name = name;
        this.residence = residence;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getResidence() {
        return residence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(residence, user.residence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, residence);
    }
}
