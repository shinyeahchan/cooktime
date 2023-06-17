package com.side.cooktime.ingredient.member;

import com.side.cooktime.domain.member.model.Member;
import com.side.cooktime.domain.member.model.Admin;
import com.side.cooktime.domain.member.model.Gender;
import com.side.cooktime.domain.member.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MemberTest {

    @Test
    public void 일반사용자() {
        Member user1 = new User("user@gmail.com", "password1234", "예찬", "신", Gender.MALE, 30);
        assertAll(
                () -> assertThat(user1.isUser()).isTrue(),
                () -> assertThat(user1.isAdmin()).isFalse()
        );
    }

    @Test
    public void 관리자() {
        Member user1 = new Admin("admin@gmail.com", "password1234", "예찬", "신");
        assertAll(
                () -> assertThat(user1.isUser()).isFalse(),
                () -> assertThat(user1.isAdmin()).isTrue()
        );
    }
}
