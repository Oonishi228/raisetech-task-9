package com.raisetech.mybatisdemo;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(int id) throws Exception;

    List<User> findByResidence(String residence);

    List<User> findByName(String Name);

    List<User> findByNameAndResidence(String name, String residence);

    void createUser(User user);

    void deleteById(int id);
}
