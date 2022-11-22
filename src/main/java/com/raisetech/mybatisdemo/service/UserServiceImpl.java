package com.raisetech.mybatisdemo.service;

import com.raisetech.mybatisdemo.exception.ResourceNotFoundException;
import com.raisetech.mybatisdemo.entity.User;
import com.raisetech.mybatisdemo.form.CreateForm;
import com.raisetech.mybatisdemo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> user = userMapper.findById(id);
        return userMapper.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
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

        if ((name != null) && (residence != null)) {
            return userMapper.findByNameAndResidence(name, residence);
        } else if ((name != null) && (residence == null)) {
            return userMapper.findByName(name);
        } else if ((name == null) && (residence != null)) {
            return userMapper.findByResidence(residence);
        }
        return userMapper.findAll();
    }

    @Override
    public void createUser(CreateForm form) {
        userMapper.create(form);
    }

    @Override
    public void updateUser(int id, User user) {
        userMapper.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
        userMapper.update(user);
    }

    @Override
    public void deleteById(int id) {
        userMapper.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
        userMapper.deleteById(id);
    }
}
