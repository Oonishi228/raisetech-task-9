package com.raisetech.mybatisdemo.controller;

import com.raisetech.mybatisdemo.entity.User;
import com.raisetech.mybatisdemo.form.CreateForm;
import com.raisetech.mybatisdemo.form.UpdateForm;
import com.raisetech.mybatisdemo.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getId(@PathVariable("id") Integer id) throws Exception {
        return userService.getUser(id);
    }

    @GetMapping
    public List<UserResponse> searchUser(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "residence", required = false) String residence) {
        return userService.findByNameAndResidence(name, residence).stream().map(UserResponse::new).toList();
    }

    @PostMapping
    public Map<String, String> createUser(@RequestBody @Validated CreateForm form) {
        userService.createUser(form);
        return Map.of("message", "登録しました。");
    }

    @PatchMapping("/{id}")
    public Map<String, String> updateUser(@PathVariable Integer id, @RequestBody @Validated UpdateForm form) {
        userService.updateUser(id, form);
        return Map.of("message", "更新しました。");
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
        return Map.of("message", "削除しました。");
    }
}
