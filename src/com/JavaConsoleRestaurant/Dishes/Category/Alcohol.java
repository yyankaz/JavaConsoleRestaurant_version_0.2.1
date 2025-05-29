package com.JavaConsoleRestaurant.Dishes.Category;

import com.JavaConsoleRestaurant.Dishes.Allergen;
import com.JavaConsoleRestaurant.Dishes.Dish;

public class Alcohol extends Dish {

    public enum AlcoholDrinkType {
        BEER("Beer."),
        COCKTAIL("Cocktail."),
        VODKA("Vodka."),
        WHISKEY("Whiskey."),
        RUM("Rum."),
        CHAMPAGNE("Champagne."),
        RED_WINE("Red wine."),
        WHITE_VINE("White wine.");

        private String displayName;

        AlcoholDrinkType(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }

    }

    private AlcoholDrinkType alcoholDrinkType;

    public Alcohol(String emoji, String nameOfDish, double dishPrice, boolean isAllergic, int weight, String shortDescription, Allergen allergenType, AlcoholDrinkType alcoholDrinkType) {
        super(emoji, nameOfDish, dishPrice, isAllergic, weight, shortDescription, allergenType);
        this.alcoholDrinkType = alcoholDrinkType;
    }

    public AlcoholDrinkType getAlcoholDrinkType(){return alcoholDrinkType;}
}
