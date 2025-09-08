package com.example.loginSpring.dto;

import com.example.loginSpring.domain.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignUpRequestDTO {

    @NotBlank(message = "학번 입력은 필수입니다.")
    @Size(min=4, max=20, message = "학번은 4글자 이상, 20글자 미만이어야 합니다.")
    private String studentId;

    @NotBlank(message = "비밀번호 입력은 필수입니다.")
    @Size(min=4, max=20, message = "비밀번호는 4글자 이상, 20글자 미만이어야 합니다.")
    private String password;

    @NotBlank(message = "이메일 입력은 필수입니다.")
    @Email
    private String email;

    @NotBlank(message = "이름 입력은 필수입니다.")
    @Size(min=2, max=10, message = "이름은 2글자 이상, 10글자 미만이어야 합니다.")
    private String name;

    public Member toEntity() {
        Member member = new Member();
        member.setStudentId(this.studentId);
        member.setPassword(this.password);
        member.setEmail(this.email);
        member.setName(this.name);
        return member;
    }

}
