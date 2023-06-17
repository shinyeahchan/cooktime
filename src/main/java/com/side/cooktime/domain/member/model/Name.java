package com.side.cooktime.domain.member.model;

public class Name {
    private final String firstName;
    private final String lastName;

    protected Name(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
