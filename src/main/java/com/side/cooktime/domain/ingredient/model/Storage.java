package com.side.cooktime.domain.ingredient.model;

public enum Storage {
    COLD("COLD"), FREEZE("FREEZE"), ROOM("ROOM");

    private String name;

    Storage(final String name) {
        this.name = name;
    }
}
