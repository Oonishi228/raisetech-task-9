package com.raisetech.mybatisdemo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NameServiceImpl implements NameService {
    private final NameMapper nameMapper;

    public NameServiceImpl(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    @Override
    public List<Name> findAll() {
        return nameMapper.findAll();
    }

    @Override
    public Optional<Name> findById(int id) {
        return nameMapper.findById(id);
    }

    @Override
    public Optional<Name> findByResidence(String residence) {
        return nameMapper.findByResidence(residence);
    }
}
