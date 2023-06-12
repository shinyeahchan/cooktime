package com.side.cooktime.domain.member;

import com.side.cooktime.domain.member.info.Profile;
import com.side.cooktime.domain.member.info.Role;

public class MemberUser extends Member {
    private final Profile profile;

    public MemberUser(String email, String password, Profile profile) {
        super(email, password, Role.USER);
        this.profile = profile;
    }
}
