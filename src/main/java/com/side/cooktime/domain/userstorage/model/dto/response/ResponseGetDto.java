package com.side.cooktime.domain.userstorage.model.dto.response;

import com.side.cooktime.domain.userstorage.model.UserStorage;

import java.util.List;

public class ResponseGetDto {
    private final String memberEmail;
    private final List<ResponseGetOneDto> response;

    public ResponseGetDto(String memberEmail, List<UserStorage> savedUserStorages) {
        this.memberEmail = memberEmail;
        this.response = savedUserStorages.stream()
                .map(ResponseGetOneDto::new)
                .toList();
    }
}
