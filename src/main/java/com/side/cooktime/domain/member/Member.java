package com.side.cooktime.domain.member;

import com.side.cooktime.domain.common.BaseEntity;
import com.side.cooktime.domain.member.info.Email;
import com.side.cooktime.domain.member.info.Password;
import com.side.cooktime.domain.member.info.Role;

public class Member extends BaseEntity {

    private Long id;
    private Email email;
    private Password password;
    private Role role;

    private Member() {
        ;
    }

    protected Member(String email, String password, Role role) {
        super();
        this.email = new Email(email);
        this.password = new Password(password);
        this.role = role;
    }

    public boolean isUser() {
        return role.isUser();
    }

    public boolean isAdmin() {
        return role.isAdmin();
    }
}
