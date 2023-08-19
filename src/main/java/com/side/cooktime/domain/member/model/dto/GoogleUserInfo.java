package com.side.cooktime.domain.member.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GoogleUserInfo {
    private String id;
    private String email;
    private String name;
    private String given_name;
    private String family_name;
    private String picture;
    private String locale;
}
