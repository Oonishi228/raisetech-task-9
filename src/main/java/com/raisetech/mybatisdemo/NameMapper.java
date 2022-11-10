package com.raisetech.mybatisdemo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NameMapper {
    @Select("SELECT * FROM names")
    List<Name> findAll();

    @Select("SELECT * FROM names WHERE id = #{id}")
    Optional<Name> findById(int id);

    @Select("SELECT * FROM names WHERE name = #{name} AND residence = #{residence}")
    List<Name> findByNameResidence(String name, String residence);
}
