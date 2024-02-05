package com.bookMyTicket.services;

import com.bookMyTicket.dto.request.UserRequestDto;
import com.bookMyTicket.entity.UserEntity;
import com.bookMyTicket.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity registerUser(UserRequestDto userDto) {
        UserEntity user = userRepository.registerUser(userDto);
        log.info("{} register successfully", userDto.getName());

        return user;
    }

}
