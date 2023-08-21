package com.side.cooktime.domain.member.model;

import com.side.cooktime.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "userGoogleInfo")
public class UserGoogleInfo extends BaseEntity {
    @Column
    private String provider = "google";
    @Column
    private String providerId;
    @Column
    private String picture;
    @Column
    private String locale;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public UserGoogleInfo(String providerId, String picture, String locale) {
        this.providerId = providerId;
        this.picture = picture;
        this.locale = locale;
    }
}
