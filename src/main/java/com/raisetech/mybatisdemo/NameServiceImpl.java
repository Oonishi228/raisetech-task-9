package com.raisetech.mybatisdemo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        Optional<Name> name = this.nameMapper.findById(id);
        return Optional.ofNullable(nameMapper.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found")));
    }

    @Override
    public List<Name> findByName(String name) {
        return nameMapper.findByName(name);
    }

    @Override
    public List<Name> findByResidence(String residence) {
        return nameMapper.findByResidence(residence);
    }

    @Override
    public List<Name> findByNameResidence(String name, String residence) {

        if (Objects.equals(name, residence)) {
            return nameMapper.findAll();
        } else if (name == null) {
            return nameMapper.findByResidence(residence);
        } else if (residence == null) {
            return nameMapper.findByName(name);
        }
        return nameMapper.findByNameResidence(name, residence);
    }
}
