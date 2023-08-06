package com.side.cooktime.domain.userstorage.model.dto.request;

import com.side.cooktime.domain.ingredient.model.Ingredient;
import com.side.cooktime.domain.ingredient.model.Storage;
import com.side.cooktime.domain.member.model.Member;
import com.side.cooktime.domain.userstorage.model.UserStorage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestSaveDto {
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
                .storage(Storage.valueOf(storage_type))
                .build();
    }


}
