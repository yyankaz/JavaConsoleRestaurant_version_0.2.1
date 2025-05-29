package com.JavaConsoleRestaurant.Dishes.ChildMenu;

public class ChildMenu implements ChildDishGeneral{
    private String name;
    private double price;
    private Category category;

    public ChildMenu(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Category getCategory() {
        return category;
    }
}
