package com.bookMyTicket.repository;

import com.bookMyTicket.dto.request.UserRequestDto;
import com.bookMyTicket.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
//    Map<Integer, UserEntity> users = new HashMap<>();
//
//    public UserEntity registerUser(UserRequestDto userRequestDto) {
//        //todo validation of unique mobile number or exiting user
//        UserEntity user = new UserEntity();
//        user.setName(userRequestDto.getName());
//        user.setEmail(userRequestDto.getEmail());
//        user.setMobileNumber(userRequestDto.getMobileNumber());
////        users.put(user.getId(), user);
//
//        return user;
//    }
}
