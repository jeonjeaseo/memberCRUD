package com.example.loginSpring.controller;

import com.example.loginSpring.domain.Member;
import com.example.loginSpring.dto.LoginRequestDTO;
import com.example.loginSpring.dto.SignUpRequestDTO;
import com.example.loginSpring.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody @Valid SignUpRequestDTO signUpRequestDTO,
                                         BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body("입력 오류 : " + errorMessage);
        }

        try {
            memberService.registerMember(signUpRequestDTO);
            return ResponseEntity.ok("회원가입 성공"); // 200
        }
        catch(DuplicateKeyException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // 400
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body("서버 오류 : " + e.getMessage()); // 500
        }
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO,
                                        BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body("입력 오류 : " + errorMessage);
        }

        try  {
            Member member = memberService.login(loginRequestDTO);

            return ResponseEntity.ok("로그인 성공 " + member.getName() + "님 환영합니다!");
        }
        catch(IllegalArgumentException e) {
            // 존재하지 않는 학번 또는 비밀번호 불일치
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("서버 내부 오류가 발생했습니다.");
        }
    }

}
