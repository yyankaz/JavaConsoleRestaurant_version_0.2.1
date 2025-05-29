package com.JavaConsoleRestaurant.Dishes;

public abstract class Dish implements DishGeneral {
    protected String emoji;
    protected String nameOfDish;
    protected double dishPrice;
    protected boolean isAllergic;
    protected int weight;
    protected String shortDescription;
    protected Allergen allergenType;

    public Dish(String emoji, String nameOfDish, double dishPrice, boolean isAllergic, int weight, String shortDescription, Allergen allergenType) {
        this.emoji = emoji;
        this.nameOfDish = nameOfDish;
        this.dishPrice = dishPrice;
        this.isAllergic = isAllergic;
        this.weight = weight;
        this.shortDescription = shortDescription;
        this.allergenType = allergenType;
    }

    @Override
    public String getEmoji() {
        return emoji;
    }

    @Override
    public String getNameOfTheDish() {
        return nameOfDish;
    }

    @Override
    public double getDishPrice() {
        return dishPrice;
    }

    @Override
    public boolean isAllergic() {
        return isAllergic;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getShortDescription() {
        return shortDescription;
    }

    @Override
    public Allergen getAllergenType() {
        return allergenType;
    }
}
