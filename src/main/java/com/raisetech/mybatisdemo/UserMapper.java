package com.raisetech.mybatisdemo;

import org.apache.ibatis.annotations.*;

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

    @Insert("INSERT INTO users (name, residence) VALUES (#{name}, #{residence})")
    void createByUser(User user);

    @Update("UPDATE users SET name = #{name}, residence = #{residence} WHERE id = #{id}")
    void updateByUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteById(int id);
}
