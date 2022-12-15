package com.raisetech.mybatisdemo.service;

import com.raisetech.mybatisdemo.entity.User;
import com.raisetech.mybatisdemo.exception.ResourceNotFoundException;
import com.raisetech.mybatisdemo.form.CreateForm;
import com.raisetech.mybatisdemo.form.UpdateForm;
import com.raisetech.mybatisdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Mock
    UserMapper userMapper;

    @Test
    public void ユーザーが全件取得できること() {
        doReturn(List.of(new User(1, "小山", "東京"), new User(2, "鈴木", "埼玉"))).when(userMapper).findAll();
        List<User> actual = userServiceImpl.findAll();
        assertThat(actual).isEqualTo(List.of(new User(1, "小山", "東京"), new User(2, "鈴木", "埼玉")));
    }

    @Test
    public void 存在するユーザーのIDを指定したときに正常にユーザーが返されること() {
        doReturn(Optional.of(new User(1, "小山", "東京"))).when(userMapper).findById(1);
        User actual = userServiceImpl.getUser(1);
        assertThat(actual).isEqualTo(new User(1, "小山", "東京"));
    }

    @Test
    public void ユーザーの登録ができること() {
        doNothing().when(userMapper).create(any(CreateForm.class));
        userServiceImpl.createUser(new CreateForm("小山", "東京"));
        verify(userMapper).create(any(CreateForm.class));
    }

    @Test
    public void ユーザーが取得できないときに例外をthrowすること() {
        doReturn(Optional.empty()).when(userMapper).findById(1);
        assertThatThrownBy(() -> userServiceImpl.getUser(1))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("resource not found");
    }

    @Test
    public void ユーザーが更新できること() {
        doReturn(Optional.of(new User(1, "小山", "東京"))).when(userMapper).findById(1);
        userServiceImpl.updateUser(1, new UpdateForm(1, "田中", "埼玉"));
        verify(userMapper).update(any(UpdateForm.class));
    }

    @Test
    public void ユーザーが更新できないときに例外をthrowすること() {
        doReturn(Optional.empty()).when(userMapper).findById(1);
        assertThatThrownBy(() -> userServiceImpl.updateUser(1, new UpdateForm(1, "田中", "埼玉")))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("resource not found");
    }

    @Test
    public void ユーザーが削除できること() {
        doReturn(Optional.of(new User(1, "小山", "東京"))).when(userMapper).findById(1);
        userServiceImpl.deleteById(1);
        verify(userMapper).deleteById(1);
    }

    @Test
    public void ユーザーが削除できないときに例外をthrowすること() {
        doReturn(Optional.empty()).when(userMapper).findById(1);
        assertThatThrownBy(() -> userServiceImpl.deleteById(1))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("resource not found");
    }
}
