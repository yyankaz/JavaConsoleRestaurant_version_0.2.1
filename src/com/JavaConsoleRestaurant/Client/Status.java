package com.JavaConsoleRestaurant.Client;

public enum Status {
    BASIC("basic"),
    SILVER("silver"),
    GOLD("gold"),
    PLATINUM("platinum");

    private String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
