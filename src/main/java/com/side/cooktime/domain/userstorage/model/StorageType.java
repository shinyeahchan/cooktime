package com.side.cooktime.domain.userstorage.model;

public enum StorageType {
    COLD("COLD"), FREEZE("FREEZE"), ROOM("ROOM"), UNKNOWN("UNKNOWN");

    private String name;

    StorageType(final String name) {
        this.name = name;
    }
}
