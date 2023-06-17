package com.side.cooktime.domain.member.model;

import com.side.cooktime.domain.model.Validator;

public class Name {
    private final String firstName;
    private final String lastName;

    protected Name(final String firstName, final String lastName) {
        validate(firstName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private void validate(String firstName) {
        Validator.notBlank(firstName, "First Name");
    }
}
