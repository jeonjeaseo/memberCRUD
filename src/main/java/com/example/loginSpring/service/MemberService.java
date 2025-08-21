package com.example.loginSpring.service;

import com.example.loginSpring.domain.Member;
import com.example.loginSpring.dto.LoginRequestDTO;
import com.example.loginSpring.dto.SignUpRequestDTO;
import com.example.loginSpring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    public void registerMember(SignUpRequestDTO signUpRequestDTO) {
        String signUpStudentId = signUpRequestDTO.getStudentId();
        String signUpPassword = signUpRequestDTO.getPassword();
        String signUpName = signUpRequestDTO.getName();
        String signUpEmail = signUpRequestDTO.getEmail();

        // 아이디 중복 체크
        if(memberRepository.existsByStudentId(signUpStudentId)) {
            throw new DuplicateKeyException("이미 사용중인 학번입니다.");
        }
        // 이메일 중복 체크
        if(memberRepository.existsByEmail(signUpEmail)) {
            throw new DuplicateKeyException("이미 사용중인 이메일입니다.");
        }

        Member member = new Member();
        member.setStudentId(signUpStudentId);
        member.setPassword(signUpPassword);
        member.setEmail(signUpEmail);
        member.setName(signUpName);

        memberRepository.save(member);
    }
    // 로그인
    public void login(LoginRequestDTO loginRequestDTO) {
        //
    }

    // 회원 추가

    // 회원 조회

    // 회원 수정

    // 회원 삭제
}
