package com.side.cooktime.domain.member.model;

import com.side.cooktime.domain.model.BaseEntity;
import com.side.cooktime.domain.userstorage.model.UserStorages;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "member")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Member extends BaseEntity {

    @Embedded
    protected Email email;
    @Embedded
    protected Password password;
    @Embedded
    protected FullName fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", updatable = false)
    protected Role role;

    @Embedded
    private final UserStorages userStorages = new UserStorages();

    protected Member(final Role role, final String email, final String password, final String firstName, final String lastName) {
        super();
        this.role = role;
        this.email = new Email(email);
        this.password = new Password(password);
        this.fullName = new FullName(firstName, lastName);
    }

    public String getRoleKey() {
        return role.getKey();
    }

    protected Member() {
        ;
    }
}
