package com.side.cooktime.ingredient.member;

import com.side.cooktime.domain.member.model.Member;
import com.side.cooktime.domain.member.model.Admin;
import com.side.cooktime.domain.member.model.Gender;
import com.side.cooktime.domain.member.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberTest {

    @Test
    public void 생성() {
        Member member1 = new User("user@gmail.com", "password1234", "예찬", "신", Gender.MALE, 30);
        Member member2 = new Admin("admin@gmail.com", "password1234", "길동", "홍");
        assertAll(
                () -> assertThat(member1 instanceof User).isTrue(),
                () -> assertThat(member1 instanceof Admin).isFalse(),
                () -> assertThat(member2 instanceof User).isFalse(),
                () -> assertThat(member2 instanceof Admin).isTrue()
        );
    }

    @Test
    void 유효성검사() {
        assertAll(
                () -> assertThatThrownBy(() -> new User(null, "password1234", "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("", "password1234", "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("user", "password1234", "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("user@", "password1234", "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),

                () -> assertThatThrownBy(() -> new User("user@gmail.com", null, "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("user@gmail.com", "", "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("user@gmail.com", "shortPw", "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),

                () -> assertThatThrownBy(() -> new User("user@gmail.com", "password1234", null, "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("user@gmail.com", "password1234", "", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),

                () -> assertThatThrownBy(() -> new User("user@gmail.com", "password1234", "길동", "홍", Gender.MALE, 0)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("user@gmail.com", "password1234", "길동", "홍", Gender.MALE, -1)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
