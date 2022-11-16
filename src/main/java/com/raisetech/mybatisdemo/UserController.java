package com.raisetech.mybatisdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/names")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public List<UserResponse> getId(@PathVariable("id") int id) throws Exception {
        return userService.findById(id).stream().map(UserResponse::new).toList();
    }

    @GetMapping
    public List<UserResponse> searchUser(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "residence", required = false) String residence) {
        return userService.findByNameAndResidence(name, residence).stream().map(UserResponse::new).toList();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Validated User user) {
        userService.createUser(user);
        return ResponseEntity.ok("登録しました。");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return ResponseEntity.ok("削除しました。");
    }
}
