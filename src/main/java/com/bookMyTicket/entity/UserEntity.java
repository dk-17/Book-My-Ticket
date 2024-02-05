package com.bookMyTicket.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
    Integer id;
    String name;
    Integer mobileNumber;
    String email;
    //todo add user type as well
}
