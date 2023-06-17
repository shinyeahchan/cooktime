package com.side.cooktime.domain.member.model;

import java.util.regex.Pattern;

public class Email {
    private final String EMAIL_REGEX = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    private final String email;

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
