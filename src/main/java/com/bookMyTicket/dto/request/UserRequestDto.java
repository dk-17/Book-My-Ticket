package com.bookMyTicket.dto.request;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String name;
    @NonNull
    private Integer mobileNumber;
    private String email;
    //todo add user type as well

}
