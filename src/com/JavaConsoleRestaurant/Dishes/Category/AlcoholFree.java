package com.JavaConsoleRestaurant.Dishes.Category;

import com.JavaConsoleRestaurant.Dishes.Allergen;
import com.JavaConsoleRestaurant.Dishes.Dish;

public class AlcoholFree extends Dish {

    public enum AlcoholFreeDrinkType {
        COFFEE("Coffee."),
        TEA("Tea."),
        JUICE("Juice."),
        WATER("Water."),
        COCKTAIL("Alcohol-free cocktail.");


        private String displayName;

        AlcoholFreeDrinkType(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }

    private AlcoholFreeDrinkType alcoholFreeDrinkType;

    public AlcoholFree(String emoji, String nameOfDish, double dishPrice, boolean isAllergic, int weight, String shortDescription, Allergen allergenType, AlcoholFreeDrinkType alcoholFreeDrinkType) {
        super(emoji, nameOfDish, dishPrice, isAllergic, weight, shortDescription, allergenType);
        this.alcoholFreeDrinkType = alcoholFreeDrinkType;
    }

    public AlcoholFreeDrinkType getAlcoholFreeDrinkType() {return alcoholFreeDrinkType;}
}
