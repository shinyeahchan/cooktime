package com.side.cooktime.domain.member.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.regex.Pattern;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {
    @Transient
    private final String EMAIL_REGEX = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    @Column(name = "email", nullable = false)
    private String email;

    public Email(final String email) {
        validate(email);
        this.email = email;
    }

    private void validate(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is cannot be null or empty");
        }

        if (!Pattern.compile(EMAIL_REGEX).matcher(email).matches()) {
            throw new IllegalArgumentException("Email is invalid format");
        }
    }
}
