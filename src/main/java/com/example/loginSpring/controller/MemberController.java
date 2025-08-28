package com.example.loginSpring.controller;

import com.example.loginSpring.dto.LoginRequestDTO;
import com.example.loginSpring.dto.SignUpRequestDTO;
import com.example.loginSpring.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원가입
    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequestDTO signUpRequestDTO) {
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



}
