package com.raisetech.mybatisdemo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper nameMapper) {
        this.userMapper = nameMapper;
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        Optional<User> name = this.userMapper.findById(id);
        return Optional.ofNullable(userMapper.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found")));
    }

    @Override
    public List<User> findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public List<User> findByResidence(String residence) {
        return userMapper.findByResidence(residence);
    }

    @Override
    public List<User> findByNameAndResidence(String name, String residence) {

        if (Objects.equals(name, residence)) {
            return userMapper.findAll();
        } else if (name == null) {
            return userMapper.findByResidence(residence);
        } else if (residence == null) {
            return userMapper.findByName(name);
        }
        return userMapper.findByNameAndResidence(name, residence);
    }

    @Override
    public void createUser(User user) {
        userMapper.createUser(user);
    }
}
