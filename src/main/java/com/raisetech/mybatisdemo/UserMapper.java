package com.raisetech.mybatisdemo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM names")
    List<User> findAll();

    @Select("SELECT * FROM names WHERE id = #{id}")
    Optional<User> findById(int id);

    @Select("SELECT * FROM names WHERE name = #{name}")
    List<User> findByName(String name);

    @Select("SELECT * FROM names WHERE residence = #{residence}")
    List<User> findByResidence(String residence);

    @Select("SELECT * FROM names WHERE name = #{name} AND residence = #{residence}")
    List<User> findByNameAndResidence(String name, String residence);

    @Insert("insert into names (name, residence) values (#{name}, #{residence})")
    void createUser(User user);
}
