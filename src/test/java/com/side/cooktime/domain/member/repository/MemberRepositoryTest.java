package com.side.cooktime.domain.member.repository;

import com.side.cooktime.domain.member.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    public static final Member member = new User("test@gmail.com", "password123", "길동", "홍", Gender.MALE, 30);

    @BeforeEach
    void setUp() {
        memberRepository.save(member);
    }

    @AfterEach
    void end() {
        memberRepository.delete(member);
    }

    @Test
    public void MEMBER_저장_확인() {
        Member savedMember = memberRepository.findByEmail("test@gmail.com").orElse(null);
        assertAll(
                () -> assertNotNull(savedMember),
                () -> assertTrue(savedMember instanceof User),
                () -> assertFalse(savedMember instanceof Admin)
        );
    }

    @Test
    public void MEMBER_저장_email_중복시() {
        //TODO : 추후 email 중복 검사 로직 및 예외처리 진행 예정
        Member member2 = new User("test@gmail.com", "password222", "수정", "김", Gender.FEMALE, 25);
        assertThrows(DataIntegrityViolationException.class, () -> memberRepository.save(member2));
    }

}
