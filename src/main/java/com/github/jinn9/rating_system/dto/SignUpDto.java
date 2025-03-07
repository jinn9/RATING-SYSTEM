package com.github.jinn9.rating_system.dto;

import lombok.Data;

// todo: validate signUpDto

@Data
public class SignUpDto {
    private String email;
    private String password;
}
