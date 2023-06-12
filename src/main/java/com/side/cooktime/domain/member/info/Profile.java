package com.side.cooktime.domain.member.info;

import com.side.cooktime.domain.member.info.profile.Age;
import com.side.cooktime.domain.member.info.profile.Gender;
import com.side.cooktime.domain.member.info.profile.MemberName;

public class Profile {
    private final MemberName memberName;

    private final Gender gender;

    private final Age age;

    public Profile(String firstName, String lastName, Gender gender, int age) {
        this.memberName = new MemberName(firstName, lastName);
        this.gender = gender;
        this.age = new Age(age);
    }
}
