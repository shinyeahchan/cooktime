package com.side.cooktime.domain.userstorage.model.dto.response;

import com.side.cooktime.domain.userstorage.model.UserStorage;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ResponseSaveDto {
    private String memberEmail;
    private List<ResponseSaveOneDto> responseSaveDtos;

    public ResponseSaveDto(String memberEmail, List<UserStorage> userStorages) {
        this.memberEmail = memberEmail;
        this.responseSaveDtos = userStorages.stream()
                .map(ResponseSaveOneDto::new)
                .collect(Collectors.toList());
    }
}
