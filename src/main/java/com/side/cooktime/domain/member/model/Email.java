package com.side.cooktime.domain.member.model;

import com.side.cooktime.domain.model.Validator;

public class Email {
    private final String EMAIL_REGEX = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    private final String email;

    public Email(final String email) {
        validate(email);
        this.email = email;
    }

    private void validate(String email) {
        Validator.notBlank(email, "Email");
        Validator.pattern(EMAIL_REGEX, email, "Email");
    }
}
