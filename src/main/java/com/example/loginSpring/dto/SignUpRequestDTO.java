package com.example.loginSpring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignUpRequestDTO {

    @NotBlank(message = "학번 입력은 필수입니다.")
    @Size(min=4)
    private String studentId;

    @NotBlank(message = "비밀번호 입력은 필수입니다.")
    @Size(min=4)
    private String password;

    @NotBlank(message = "이메일 입력은 필수입니다.")
    @Email
    private String email;

    @NotBlank(message = "이름 입력은 필수입니다.")
    private String name;
}
