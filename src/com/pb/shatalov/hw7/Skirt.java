package com.pb.shatalov.hw7;

public class Skirt extends Clothes implements WomenClothes {

    public Skirt(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWomen() {

    }

    @Override
    public String toString() {
        return "Skirt: " + super.toString();
    }
}
