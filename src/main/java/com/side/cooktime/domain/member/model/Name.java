package com.side.cooktime.domain.member.model;

public class Name {
    private final String firstName;
    private final String lastName;

    protected Name(final String firstName, final String lastName) {
        validate(firstName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private void validate(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First Name is cannot be null or empty");
        }
    }
}
