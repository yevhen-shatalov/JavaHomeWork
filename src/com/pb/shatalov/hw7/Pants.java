package com.pb.shatalov.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {
    public Pants(Size size, int price, String color) {
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
        return "Pants: " + super.toString();
    }
}
