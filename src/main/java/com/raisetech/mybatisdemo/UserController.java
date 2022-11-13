package com.raisetech.mybatisdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/names")
public class UserController {
    private final UserService nameService;

    public UserController(UserService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/{id}")
    public List<UserResponse> getId(@PathVariable("id") int id) throws Exception {
        return nameService.findById(id).stream().map(UserResponse::new).toList();
    }

    @GetMapping
    public List<UserResponse> searchUser(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "residence", required = false) String residence) {
        return nameService.findByNameAndResidence(name, residence).stream().map(UserResponse::new).toList();
    }

}