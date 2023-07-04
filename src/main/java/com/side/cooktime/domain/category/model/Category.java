package com.side.cooktime.domain.category.model;

import com.side.cooktime.domain.ingredient.model.Name;
import com.side.cooktime.domain.model.BaseEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Entity
public class Category extends BaseEntity {

    @Embedded
    private Name name;

    @Embedded
    private final Ingredients ingredients = new Ingredients();

    public Category() {
        super();
    }

    public Category(final String name) {
        this();
        this.name = new Name(name);
    }
}
