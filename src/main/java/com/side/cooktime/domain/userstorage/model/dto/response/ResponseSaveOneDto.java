package com.side.cooktime.domain.userstorage.model.dto.response;

import com.side.cooktime.domain.userstorage.model.UserStorage;
import lombok.Data;

@Data
public class ResponseSaveOneDto {
    private Long id;
    private String ingredientName;
    private int quantity;

    public ResponseSaveOneDto(UserStorage userStorage) {
        this.id = userStorage.getId();
        this.ingredientName = userStorage.getIngredient().getName().getName();  /*TODO:메서드체이닝 개선*/
        this.quantity = userStorage.getQuantity();
    }
}
