package com.side.cooktime.domain.category.model.dto.response;

import com.side.cooktime.domain.category.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class ResponseGetAllWithIngredientsDto {

    private Long id;
    private String name;

    private List<ResponseFindIngredientsDto> ingredientsDto;

    public ResponseGetAllWithIngredientsDto(Category category, List<ResponseFindIngredientsDto> ingredientsDto){
        this.id = category.getId();
        this.name = category.getName();
        this.ingredientsDto = ingredientsDto;
    }
}
