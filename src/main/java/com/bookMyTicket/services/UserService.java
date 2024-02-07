package com.bookMyTicket.services;

import com.bookMyTicket.dto.UserDto;
import com.bookMyTicket.entity.UserEntity;
import com.bookMyTicket.exception.DuplicateEntityException;
import com.bookMyTicket.exception.NotFoundException;
import com.bookMyTicket.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity registerUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setMobileNumber(userDto.getMobileNumber());

        try {
            userRepository.save(user);
            log.info("{} register successfully", userDto.getName());
        } catch (DataIntegrityViolationException e) {
            //TODO - check its giving 500 is it right status code?
            throw new DuplicateEntityException("User with mobile number " + user.getMobileNumber() + " already exists");
        }

        return user;
    }

    public UserEntity getUser(Long userId) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("User not found with ID: " + userId);
        }
        return optionalUser.get();
    }
}


