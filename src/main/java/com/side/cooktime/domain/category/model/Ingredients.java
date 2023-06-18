package com.side.cooktime.domain.category.model;

import com.side.cooktime.domain.ingredient.model.Ingredient;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Ingredients {

    @OneToMany(mappedBy = "category")
    private List<Ingredient> ingredients;

    public Ingredients(){
        this.ingredients = new ArrayList<>();
    }

}
