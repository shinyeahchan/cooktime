package com.side.cooktime.domain.member;

import com.side.cooktime.domain.member.info.Role;

public class MemberAdmin extends Member {
    public MemberAdmin(String email, String password) {
        super(email, password, Role.ADMIN);
    }
}
