package com.raisetech.mybatisdemo;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    Optional<User> findById(int id);

    @Select("SELECT * FROM users WHERE name = #{name}")
    List<User> findByName(String name);

    @Select("SELECT * FROM users WHERE residence = #{residence}")
    List<User> findByResidence(String residence);

    @Select("SELECT * FROM users WHERE name = #{name} AND residence = #{residence}")
    List<User> findByNameAndResidence(String name, String residence);

    @Insert("insert into users (name, residence) values (#{name}, #{residence})")
    void createUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteById(int id);
}
