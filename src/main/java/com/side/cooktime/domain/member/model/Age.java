package com.side.cooktime.domain.member.model;

import com.side.cooktime.domain.model.Validator;

public class Age {
    private final int age;

    public Age(final int age) {
        validate(age);
        this.age = age;
    }

    private void validate(int age) {
        Validator.positive(age, "Age");
    }
}
