package com.pb.shatalov.hw7;

public class Tie extends Clothes implements ManClothes {
    public Tie(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {

    }

    @Override
    public String toString() {
        return "Tie: " + super.toString();
    }
}
