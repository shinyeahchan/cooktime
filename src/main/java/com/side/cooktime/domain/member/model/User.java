package com.side.cooktime.domain.member.model;

public class User extends Member {
    private final Gender gender;

    private final Age age;

    public User(final String email, final String password, final String firstName, final String lastName, final Gender gender, final int age) {
        super(email, password, firstName, lastName);
        this.gender = gender;
        this.age = new Age(age);
    }

}
