package com.side.cooktime.domain.member.model;

import com.side.cooktime.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "member")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public abstract class Member extends BaseEntity {

    @Embedded
    protected Email email;
    @Embedded
    protected Password password;
    @Embedded
    protected Name name;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", insertable = false, updatable = false)
    private Role role;

    protected String provider;
    protected String providerId;

    protected Member(final Role role, final String email, final String password, final String firstName, final String lastName) {
        super();
        this.role = role;
        this.email = new Email(email);
        this.password = new Password(password);
        this.name = new Name(firstName, lastName);
    }

    protected Member(final Role role, final String provider, final String providerId, final String email, final String password, final String firstName, final String lastName) {
        super();
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.email = new Email(email);
        this.password = new Password(password);
        this.name = new Name(firstName, lastName);
    }

    public String getRoleKey() {
        return role.getKey();
    }

    protected Member() {
        ;
    }
}
