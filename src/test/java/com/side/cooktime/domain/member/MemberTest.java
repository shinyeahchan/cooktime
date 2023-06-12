package com.side.cooktime.domain.member;

import com.side.cooktime.domain.member.info.Profile;
import com.side.cooktime.domain.member.info.profile.Gender;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MemberTest {

    @Test
    public void 일반사용자() {
        Profile profile = new Profile("예찬", "신", Gender.MALE, 30);
        Member user1 = new MemberUser("test@gmail.com", "password1234", profile);
        assertAll(
                () -> assertThat(user1.isUser()).isTrue(),
                () -> assertThat(user1.isAdmin()).isFalse()
        );
    }

    @Test
    public void 관리자() {
        Member user1 = new MemberAdmin("test@gmail.com", "password1234");
        assertAll(
                () -> assertThat(user1.isUser()).isFalse(),
                () -> assertThat(user1.isAdmin()).isTrue()
        );
    }
}
