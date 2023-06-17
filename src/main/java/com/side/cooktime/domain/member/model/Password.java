package com.side.cooktime.domain.member.model;

public class Password {
    private final int MINIMUM_LENGTH = 8;
    private final String password;

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
