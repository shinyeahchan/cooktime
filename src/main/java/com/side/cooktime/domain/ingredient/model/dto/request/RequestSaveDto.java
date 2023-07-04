package com.side.cooktime.domain.ingredient.model.dto.request;

import com.side.cooktime.domain.ingredient.model.*;
import lombok.Data;

@Data
public class RequestSaveDto {

    private String name;
    private String url;
    private int expirationPeriod;
    private String storage;
    private String countType;


//    public Ingredient toEntity(){
//        return Ingredient.builder()
//                .name(new Name(name))
//                .image(new Image(url))
//                .expirationPeriod(new Day(expirationPeriod))
//                .storage()
//                .countType()
//                .build();
//    }


}
