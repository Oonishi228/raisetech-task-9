package com.raisetech.mybatisdemo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper nameMapper;

    public UserServiceImpl(UserMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    @Override
    public List<User> findAll() {
        return nameMapper.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        Optional<User> name = this.nameMapper.findById(id);
        return Optional.ofNullable(nameMapper.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found")));
    }

    @Override
    public List<User> findByName(String name) {
        return nameMapper.findByName(name);
    }

    @Override
    public List<User> findByResidence(String residence) {
        return nameMapper.findByResidence(residence);
    }

    @Override
    public List<User> findByNameAndResidence(String name, String residence) {

        if (Objects.equals(name, residence)) {
            return nameMapper.findAll();
        } else if (name == null) {
            return nameMapper.findByResidence(residence);
        } else if (residence == null) {
            return nameMapper.findByName(name);
        }
        return nameMapper.findByNameAndResidence(name, residence);
    }
}
