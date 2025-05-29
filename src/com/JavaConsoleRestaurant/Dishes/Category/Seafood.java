package com.JavaConsoleRestaurant.Dishes.Category;

import com.JavaConsoleRestaurant.Dishes.Allergen;
import com.JavaConsoleRestaurant.Dishes.Dish;

public class Seafood extends Dish {

    public enum SeafoodType {
        SALMON("Salmon."),
        TUNA("Tuna."),
        SHRIMP("Shrimps."),
        CRAB("Crab."),
        OCTOPUS("Octopus."),
        MACKEREL("Mackerel.");

        private String displayName;

        SeafoodType(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }

    private SeafoodType seafoodType;


    public Seafood(String emoji, String nameOfDish, double dishPrice, boolean isAllergic, int weight, String shortDescription, Allergen allergenType, SeafoodType seafoodType) {
        super(emoji, nameOfDish, dishPrice, isAllergic, weight, shortDescription, allergenType);
        this.seafoodType = seafoodType;
    }

    public SeafoodType getSeafoodType(){
        return seafoodType;
    }
}
