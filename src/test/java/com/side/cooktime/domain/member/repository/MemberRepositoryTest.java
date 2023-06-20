package com.side.cooktime.domain.member.repository;

import com.side.cooktime.domain.member.model.Admin;
import com.side.cooktime.domain.member.model.Gender;
import com.side.cooktime.domain.member.model.Member;
import com.side.cooktime.domain.member.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testSaveAndFindMember() {
        // Given
        String email = "test@gmail.com";
        String password = "password123";
        String firstName = "길동";
        String lastName = "홍";
        Member member = new User(email, password, firstName, lastName, Gender.MALE, 30);

        // When
        memberRepository.save(member);

        // Then
        Member savedMember = memberRepository.findById(1L).orElse(null);
        assertAll(
                () -> assertNotNull(savedMember),
                () -> assertTrue(savedMember instanceof User),
                () -> assertFalse(savedMember instanceof Admin)
        );
    }
}
