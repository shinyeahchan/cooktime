package com.side.cooktime.domain.member.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class MemberTest {

    @Test
    public void user_생성() {
        Member member = new User("user@gmail.com", "password1234", "길동", "홍", Gender.MALE, 30);
        assertAll(
                () -> assertThat(member instanceof User).isTrue(),
                () -> assertThat(member instanceof Admin).isFalse()
        );
    }

    @Test
    public void admin_생성() {
        Member member = new Admin("admin@gmail.com", "password1234", "길동", "홍");
        assertAll(
                () -> assertThat(member instanceof User).isFalse(),
                () -> assertThat(member instanceof Admin).isTrue()
        );
    }

    @Test
    void email_유효성검사() {
        assertAll(
                () -> assertThatThrownBy(() -> new User(null, "password1234", "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("", "password1234", "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("user", "password1234", "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("user@", "password1234", "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void password_유효성검사() {
        assertAll(
                () -> assertThatThrownBy(() -> new User("user@gmail.com", null, "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("user@gmail.com", "", "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("user@gmail.com", "shortPw", "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void firstName_유효성검사() {
        assertAll(
                () -> assertThatThrownBy(() -> new User("user@gmail.com", "password1234", null, "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("user@gmail.com", "password1234", "", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void age_유효성검사() {
        assertAll(
                () -> assertThatThrownBy(() -> new User("user@gmail.com", "password1234", "길동", "홍", Gender.MALE, -1)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new User("user@gmail.com", "password1234", "길동", "홍", Gender.MALE, -10)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
