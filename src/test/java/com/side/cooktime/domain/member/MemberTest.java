package com.side.cooktime.domain.member;

import com.side.cooktime.member.domain.Member;
import com.side.cooktime.member.domain.admin.Admin;
import com.side.cooktime.member.domain.user.Gender;
import com.side.cooktime.member.domain.user.User;
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
