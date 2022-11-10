package com.raisetech.mybatisdemo;

import java.util.List;
import java.util.Optional;

public interface NameService {

    List<Name> findAll();

    Optional<Name> findById(int id) throws Exception;

    List<Name> findByNameResidence(String name, String residence);
}
