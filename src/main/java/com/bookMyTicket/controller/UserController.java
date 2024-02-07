package com.bookMyTicket.controller;

import com.bookMyTicket.dto.UserDto;
import com.bookMyTicket.entity.UserEntity;
import com.bookMyTicket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserEntity> addUser(
            @RequestBody UserDto userDto) {
        UserEntity user = userService.registerUser(userDto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUser(
            @PathVariable Long userId) {
        UserEntity user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //TODO: delete user
}
