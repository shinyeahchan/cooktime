package com.side.cooktime.domain.userstorage.model.dto.response;

import com.side.cooktime.domain.userstorage.model.UserStorage;
import lombok.Data;

@Data
public class ResponseSaveDto {

    private Long id;
    private String ingredient_name;
    private int quantity;

    public ResponseSaveDto(UserStorage userStorage) {
        this.id = userStorage.getId();
        this.ingredient_name = userStorage.getIngredient().getName().getName();
        this.quantity = userStorage.getQuantity();
    }

}
