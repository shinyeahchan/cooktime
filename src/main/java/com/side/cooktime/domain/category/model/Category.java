package com.side.cooktime.domain.category.model;

import com.side.cooktime.domain.model.BaseEntity;
import com.side.cooktime.domain.ingredient.model.Name;
import com.side.cooktime.domain.ingredient.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Category extends BaseEntity {

    private Long id;
    private Name name;
    private List<Ingredient> ingredients = new ArrayList<>();

    public Category() {
        super();
    }

    public Category(final String name) {
        this();
        this.name = new Name(name);
    }
}
