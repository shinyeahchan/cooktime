package com.side.cooktime.domain.ingredient.model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Embeddable
@NoArgsConstructor
@Access(AccessType.FIELD)
public class Name {

    @Column(length = 100)
    private String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("이름이 공백이거나 Null 값입니다.");
        }
    }
}
