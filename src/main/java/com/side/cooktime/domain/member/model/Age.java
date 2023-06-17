package com.side.cooktime.domain.member.model;

public class Age {
    private final int age;

    public Age(final int age) {
        validate(age);
        this.age = age;
    }

    private void validate(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive value");
        }
    }
}
