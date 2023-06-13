package com.side.cooktime.member.domain.admin;

import com.side.cooktime.member.domain.Member;

public class Admin extends Member {
    public Admin(final String email, final String password, final String firstName, final String lastName) {
        super(email, password, firstName, lastName);
    }

    @Override
    public boolean isUser() {
        return false;
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}
