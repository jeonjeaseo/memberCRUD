package com.example.loginSpring.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginResponseDTO {
    private String studentId;
    private String password;
    private String accessToken;
}
