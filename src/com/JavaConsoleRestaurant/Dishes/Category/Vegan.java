package com.JavaConsoleRestaurant.Dishes.Category;

import com.JavaConsoleRestaurant.Dishes.Allergen;
import com.JavaConsoleRestaurant.Dishes.Dish;

public class Vegan extends Dish {

    public enum VeganProductType {
        VEGETABLES("Vegetables."),
        FRUITS("Fruits."),
        CEREALS("Cereals."),
        LEGUMES("Legumes.");


        private String displayName;

        VeganProductType(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }

    private VeganProductType veganProductType;

    public Vegan(String emoji, String nameOfDish, double dishPrice, boolean isAllergic, int weight, String shortDescription, Allergen allergenType, VeganProductType veganProductType) {
        super(emoji, nameOfDish, dishPrice, isAllergic, weight, shortDescription, allergenType);
        this.veganProductType = veganProductType;
    }

    public VeganProductType getVeganProductType() {return veganProductType;}
}
