package com.pb.shatalov.hw6;

public class Cat extends Animal {

    private String catName;

    public Cat(String food, String location, String breed) {
        super(food, location, breed);
    }
    public Cat() {
    }

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String makeNoise(){
        return "мяукает";
    }
    @Override
    public String eat() {
        return "плямкает";
    }

}
