package com.raisetech.mybatisdemo.service;

import com.raisetech.mybatisdemo.entity.User;
import com.raisetech.mybatisdemo.form.CreateForm;
import com.raisetech.mybatisdemo.form.UpdateForm;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id) throws Exception;

    List<User> findByResidence(String residence);

    List<User> findByName(String Name);

    List<User> findByNameAndResidence(String name, String residence);

    void createUser(CreateForm form);

    void updateUser(int id, UpdateForm form);

    void deleteById(int id);
}
