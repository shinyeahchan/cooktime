package com.side.cooktime.domain.member.model;

import com.side.cooktime.domain.model.Validator;

public class Password {
    private final int MINIMUM_LENGTH = 8;
    private final String password;

    public Password(final String password) {
        validate(password);
        this.password = password;
    }

    private void validate(String password) {
        Validator.notBlank(password, "Password");
        Validator.length(MINIMUM_LENGTH, password.length(), "Password");
    }

}
