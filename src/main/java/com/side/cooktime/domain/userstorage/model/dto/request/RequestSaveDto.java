package com.side.cooktime.domain.userstorage.model.dto.request;

import com.side.cooktime.domain.ingredient.model.Ingredient;
import com.side.cooktime.domain.member.model.Member;
import com.side.cooktime.domain.userstorage.model.StorageType;
import com.side.cooktime.domain.userstorage.model.UserStorage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestSaveDto {

    private String member_email;
    private Long ingredient_id;
    private int quantity;
    private LocalDateTime expiration_date;
    private String storage_type;

    public UserStorage toEntity(Member member, Ingredient ingredient) {
        return UserStorage.builder()
                .member(member)
                .ingredient(ingredient)
                .quantity(quantity)
                .expirationDate(expiration_date)
                .storageType(StorageType.findEnumByValue(storage_type))
                .build();
    }


}
