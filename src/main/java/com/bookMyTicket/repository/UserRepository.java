package com.bookMyTicket.repository;

import com.bookMyTicket.dto.request.UserRequestDto;
import com.bookMyTicket.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository {
    Integer id = 1;
    Map<Integer, UserEntity> users = new HashMap<>();

    public UserEntity registerUser(UserRequestDto userRequestDto) {
        //todo validation of unique mobile number or exiting user
        UserEntity user = new UserEntity();
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setMobileNumber(userRequestDto.getMobileNumber());
        user.setId(id);
        id++; // increment id for next user;
        users.put(user.getId(), user);

        return user;
    }
}
