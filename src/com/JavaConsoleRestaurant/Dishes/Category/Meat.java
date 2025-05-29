package com.JavaConsoleRestaurant.Dishes.Category;

import com.JavaConsoleRestaurant.Dishes.Allergen;
import com.JavaConsoleRestaurant.Dishes.Dish;

public class Meat extends Dish {

    public enum MeatType{
        BEEF("Beef."),
        PORK("Pork."),
        CHICKEN("Chicken."),
        TURKEY("Turkey."),
        LAMB("Lamb.");

        private String displayName;

        MeatType(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }

    protected MeatType meatType;

    public Meat(String emoji, String nameOfDish, double dishPrice, boolean isAllergic, int weight,
                String shortDescription, Allergen allergenType, MeatType meatType) {
        super(emoji, nameOfDish, dishPrice, isAllergic, weight, shortDescription, allergenType);
        this.meatType = meatType;
    }

    public MeatType getMeatType(){
        return meatType;
    }
}