package com.side.cooktime.domain.member.info.profile;

public enum Gender {
    MALE("male"), FEMALE("female");

    private String type;

    Gender(String type) {
        this.type = type;
    }
}
