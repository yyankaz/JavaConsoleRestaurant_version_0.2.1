package com.JavaConsoleRestaurant.Dishes.Category;

import com.JavaConsoleRestaurant.Dishes.Allergen;
import com.JavaConsoleRestaurant.Dishes.Dish;

public class Dessert extends Dish {

    public Dessert(String emoji, String nameOfDish, double dishPrice, boolean isAllergic, int weight,
                   String shortDescription, Allergen allergenType) {
        super(emoji, nameOfDish, dishPrice, isAllergic, weight, shortDescription, allergenType);
    }
}
