package com.pb.shatalov.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {

    public Tshirt(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {

    }

    @Override
    public void dressWomen() {

    }

    @Override
    public String toString() {
        return "Tshirt: " + super.toString();
    }
}
