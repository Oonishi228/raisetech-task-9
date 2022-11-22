package com.raisetech.mybatisdemo;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User findById(int id) throws Exception;

    List<User> findByResidence(String residence);

    List<User> findByName(String Name);

    List<User> findByNameAndResidence(String name, String residence);

    void createUser(CreateForm form);

    void updateUser(int id, User user);

    void deleteById(int id);
}
