package com.side.cooktime.domain.member.info;

public enum Role {
    USER, ADMIN;

    public boolean isUser() {
        return USER.equals(this);
    }

    public boolean isAdmin() {
        return ADMIN.equals(this);
    }
}
