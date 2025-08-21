package com.example.loginSpring.repository;

import com.example.loginSpring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {
    // existsBy-- = JPA가 자동으로 SQL 만들어서 확인해줌

    boolean existsByStudentId(String studentId);

    boolean existsByEmail(String email);
}
