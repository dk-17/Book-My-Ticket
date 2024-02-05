package com.bookMyTicket.controller;


import com.bookMyTicket.dto.request.UserRequestDto;
import com.bookMyTicket.entity.UserEntity;
import com.bookMyTicket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserEntity> addNotesForTask(
            @RequestBody UserRequestDto userRequestDto
    ) {
        UserEntity user = userService.registerUser(userRequestDto);
        return ResponseEntity.ok(user);
    }
}
