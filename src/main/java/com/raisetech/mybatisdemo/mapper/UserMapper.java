package com.raisetech.mybatisdemo.mapper;

import com.raisetech.mybatisdemo.entity.User;
import com.raisetech.mybatisdemo.form.CreateForm;
import com.raisetech.mybatisdemo.form.UpdateForm;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    // どういう状況であれば、どんなインプットを与えれば
    // どんな結果が得られるか？
    // 1、1、1を入力して計算するボタンをおすと
    // 正三角形とアラートに表示されること

    // どういう状況であれば、どんなインプットを与えれば
    // どんな結果が得られるか？
    // usersテーブルにレコードがあるとき
    // すべて取得できること
    // usersテーブルにレコードがないとき
    // 空のListが取得できること
    @Select("SELECT * FROM users")
    List<User> findAll();

    // 指定したidに紐づくユーザーのレコードが存在するときに
    // 取得できること
    // 存在しないidを指定した場合に
    // 取得できないこと（空のOptionalを返すこと）
    @Select("SELECT * FROM users WHERE id = #{id}")
    Optional<User> findById(Integer id);

    // 指定した名前をもつユーザーが存在するときは
    // すべてListで返すこと
    // 指定した名前をもつユーザーが存在しないときは
    // 空のListを返すこと
    @Select("SELECT * FROM users WHERE name = #{name}")
    List<User> findByName(String name);

    // 指定した住所をもつユーザーが存在するときは
    // すべてListで返すこと
    // 指定した住所をもつユーザーが存在しないときは
    // 空のListを返すこと
    @Select("SELECT * FROM users WHERE residence = #{residence}")
    List<User> findByResidence(String residence);

    @Select("SELECT * FROM users WHERE name = #{name} AND residence = #{residence}")
    List<User> findByNameAndResidence(String name, String residence);

    // 指定した名前と住所で新しくユーザーが登録できること
    // （重複するマイナンバーカードの番号を登録しようとするとDuplicateKeyExceptionがthrowされること）
    @Insert("INSERT INTO users (name, residence) VALUES (#{name}, #{residence})")
    void create(CreateForm form);

    // 指定したidに紐づくユーザーがあるとき
    // 名前と住所が更新できること
    // 指定したidに紐づくユーザーがなしとき
    // 名前と住所が更新できないこと、更新されないこと
    @Update("UPDATE users SET name = #{name}, residence = #{residence} WHERE id = #{id}")
    void update(UpdateForm form);

    // 指定したidのユーザーがあるとき
    // 削除すること
    // 指定したidがないとき
    // ユーザーを削除しない
    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteById(Integer id);
}
