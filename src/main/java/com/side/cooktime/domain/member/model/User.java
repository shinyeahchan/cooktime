package com.side.cooktime.domain.member.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class User extends Member {

    public User(final String provider, final String providerId, final String email, final String password, final String firstName, final String lastName) {
        super(Role.USER, provider, providerId, email, password, firstName, lastName);
    }

    public User(final String email, final String password, final String firstName, final String lastName) {
        super(Role.USER, email, password, firstName, lastName);
    }

    protected User() {
        ;
    }
}
