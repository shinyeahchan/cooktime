package com.side.cooktime.domain.category.model.dto.request;

import com.side.cooktime.domain.category.model.Category;
import com.side.cooktime.domain.ingredient.model.Name;
import com.side.cooktime.domain.model.Timestamp;
import lombok.Data;

@Data
public class RequestSaveDto {

    private String name;

    public RequestSaveDto() {

    }

    public Category toEntity() {
        return Category.builder()
                .name(new Name(name))
                .build();
    }

}
