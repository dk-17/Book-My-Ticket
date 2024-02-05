package com.bookMyTicket.services;

import com.bookMyTicket.dto.request.UserRequestDto;
import com.bookMyTicket.entity.UserEntity;
import com.bookMyTicket.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity registerUser(UserRequestDto userDto) {
        UserEntity user = new UserEntity();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setMobileNumber(userDto.getMobileNumber());

        userRepository.save(user);
        log.info("{} register successfully", userDto.getName());

        return user;
    }

}


