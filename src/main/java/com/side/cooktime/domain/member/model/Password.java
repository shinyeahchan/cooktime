package com.side.cooktime.domain.member.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {
    @Transient
    private final int MINIMUM_LENGTH = 8;
    @Column(name = "password", nullable = false)
    private String password;

    public Password(final String password) {
        validate(password);
        this.password = password;
    }

    private void validate(String password) {
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password is cannot be null or empty");
        }
        if (password.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException("Password must be at least " + MINIMUM_LENGTH + " characters long");
        }
    }

}
