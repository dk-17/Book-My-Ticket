package com.bookMyTicket.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    String name;
    Integer mobileNumber;
    String email;
    //todo add user type as well

}
