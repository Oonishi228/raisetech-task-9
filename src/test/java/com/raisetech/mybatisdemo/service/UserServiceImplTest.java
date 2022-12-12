package com.raisetech.mybatisdemo.service;

import com.raisetech.mybatisdemo.entity.User;
import com.raisetech.mybatisdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Mock
    UserMapper userMapper;

    @Test
    public void 存在するユーザーのIDを指定したときに正常にユーザーが返されること() {
        doReturn(Optional.of(new User(1, "小山", "東京"))).when(userMapper).findById(1);
        User actual = userServiceImpl.getUser(1);
        assertThat(actual).isEqualTo(new User(1, "小山", "東京"));
    }

    @Test
    public void ユーザーが全件取得できること() {
        doReturn(List.of(new User(1, "小山", "東京"), new User(2, "鈴木", "埼玉"))).when(userMapper).findAll();
        List<User> actual = userServiceImpl.findAll();
        assertThat(actual).isEqualTo(List.of(new User(1, "小山", "東京"), new User(2, "鈴木", "埼玉")));
    }

}
