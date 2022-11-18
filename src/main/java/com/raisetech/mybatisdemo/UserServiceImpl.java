package com.raisetech.mybatisdemo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public Optional<User> findById(int id) {
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

        if ((name != null) && (residence != null)) {
            return userMapper.findByNameAndResidence(name, residence);
        } else if ((name != null) && (residence == null)) {
            return userMapper.findByName(name);
        } else if ((name == null) && (residence == null)) {
            return userMapper.findAll();
        }
        return userMapper.findByResidence(residence);
    }

    @Override
    public void createUser(CreateForm form) {
        userMapper.create(form);
    }

    @Override
    public void updateUser(User user) {
        userMapper.update(user);
    }

    @Override
    public void deleteById(int id) {
        userMapper.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
        userMapper.deleteById(id);
    }
}
