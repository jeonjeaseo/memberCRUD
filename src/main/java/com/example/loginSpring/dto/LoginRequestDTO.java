package com.example.loginSpring.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
    @NotBlank(message = "학번 입력은 필수입니다.")
    private String studentId;

    @NotBlank(message = "비밀번호 입력은 필수입니다.")
    private String password;
}
