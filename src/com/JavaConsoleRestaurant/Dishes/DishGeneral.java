package com.JavaConsoleRestaurant.Dishes;

public interface DishGeneral {
    public String getEmoji();
    public String getNameOfTheDish();
    public double getDishPrice();
    public boolean isAllergic();
    public int getWeight();
    public String getShortDescription();
    public Allergen getAllergenType();

}
