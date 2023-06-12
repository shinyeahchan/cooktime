package com.side.cooktime.domain.ingredient;

import com.side.cooktime.domain.category.Category;
import com.side.cooktime.domain.common.*;

public class Ingredient extends BaseEntity {

    private Long id;
    private Category category;
    private Name name;
    private Image image;
    private Day expirationPeriod;
    private Storage storage;
    private CountType countType;

    public Ingredient() {
        super();
    }

    public Ingredient(final String name, final String image, final int expirationPeriod, final Storage storage, final Category category, final CountType countType) {
        this();
        this.name = new Name(name);
        this.image = new Image(image);
        this.expirationPeriod = new Day(expirationPeriod);
        this.storage = storage;
        this.category = category;
        this.countType = countType;
    }
}
