package com.side.cooktime.member.domain;

import com.side.cooktime.domain.common.BaseEntity;
import com.side.cooktime.member.domain.common.Email;
import com.side.cooktime.member.domain.common.Name;
import com.side.cooktime.member.domain.common.Password;

public abstract class Member extends BaseEntity {

    protected Long id;
    protected Email email;
    protected Password password;
    protected Name name;

    private Member() {
        ;
    }

    protected Member(final String email, final String password, final String firstName, final String lastName) {
        super();
        this.email = new Email(email);
        this.password = new Password(password);
        this.name = new Name(firstName, lastName);
    }

    public abstract boolean isAdmin();

    public abstract boolean isUser();
}
