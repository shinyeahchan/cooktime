package com.side.cooktime.domain.member.model;

import com.side.cooktime.domain.model.BaseEntity;

import java.util.Arrays;

public abstract class Member extends BaseEntity {

    protected Long id;
    protected final Email email;
    protected final Password password;
    protected final Name name;

    protected Member(final String email, final String password, final String firstName, final String lastName) {
        super();
        this.email = new Email(email);
        this.password = new Password(password);
        this.name = new Name(firstName, lastName);
    }
}
