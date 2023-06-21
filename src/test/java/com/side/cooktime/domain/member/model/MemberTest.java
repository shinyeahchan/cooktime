package com.side.cooktime.domain.member.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest(name = "email 입력값: {0}")
    @NullAndEmptySource
    @ValueSource(strings = {"user", "user@"})
    void email_유효성검사(String email) {
        assertThatThrownBy(() -> new User(email, "password1234", "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "password 입력값: {0}")
    @NullAndEmptySource
    @ValueSource(strings = {"shortPw"})
    void password_유효성검사(String password) {
        assertThatThrownBy(() -> new User("user@gmail.com", password, "길동", "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "firstName 입력값: {0}")
    @NullAndEmptySource
    void firstName_유효성검사(String firstName) {
        assertThatThrownBy(() -> new User("user@gmail.com", "password1234", firstName, "홍", Gender.MALE, 30)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "age 입력값: {0}")
    @ValueSource(ints = {-1, -10})
    void age_유효성검사(int age) {
        assertThatThrownBy(() -> new User("user@gmail.com", "password1234", "길동", "홍", Gender.MALE, age)).isInstanceOf(IllegalArgumentException.class);
    }
}
