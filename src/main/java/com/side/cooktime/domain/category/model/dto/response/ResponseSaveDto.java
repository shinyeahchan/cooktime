package com.side.cooktime.domain.category.model.dto.response;

import com.side.cooktime.domain.category.model.Category;
import com.side.cooktime.domain.ingredient.model.Name;
import com.side.cooktime.domain.model.Timestamp;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseSaveDto {

    private Long id;
    private String name;

    public ResponseSaveDto(Category category) {
        this.id = category.getId();
        this.name = category.getName().getName();
    }

}
