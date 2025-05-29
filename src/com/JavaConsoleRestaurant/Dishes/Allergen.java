package com.JavaConsoleRestaurant.Dishes;

public enum Allergen {
    NONE("-"),
    GLUTEN("Gluten."),
    NUTS("Nuts."),
    DAIRY("Dairy."),
    FINFISH("Finfish."),
    SHELLFISH("Shellfish."),
    SULFITES("Sulfites");

    private String displayName;

    Allergen(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

}
