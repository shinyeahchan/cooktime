package com.side.cooktime.domain.member.model.dto.response;

import com.side.cooktime.domain.member.model.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseGetDto {
    private String email;
    private String fullName;
    private String firstName;
    private String lastName;
    private LocalDateTime createdDate;
    private String role;

    public ResponseGetDto(Member member) {
        this.email = member.getEmailValue();
        this.fullName = member.getFullName();
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.createdDate = member.getTimestamp().getCreatedAt();
        this.role = member.getRole().name();
    }
}
