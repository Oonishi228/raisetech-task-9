package com.raisetech.mybatisdemo.service;

import com.raisetech.mybatisdemo.entity.User;
import com.raisetech.mybatisdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserMapper userMapper;

    @Test
    public void ユーザーが全件取得できること() {
        doReturn(List.of(new User(1, "koyama", "東京"), new User(2, "suzuki", "埼玉"))).when(userMapper).findAll();
        List<User> actual = userService.findAll();
        assertThat(actual).isEqualTo(List.of(new User(1, "koyama", "東京"), new User(2, "suzuki", "埼玉")));
    }
}
