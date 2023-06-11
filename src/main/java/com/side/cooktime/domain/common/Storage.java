package com.side.cooktime.domain.common;

public enum Storage {
    COLD("COLD"), FREEZE("FREEZE"), ROOM("ROOM");

    private String name;

    Storage(final String name) {
        this.name = name;
    }
}
