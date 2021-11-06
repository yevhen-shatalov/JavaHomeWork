package com.pb.shatalov.hw6;

public class Horse extends Animal{

    private String horseName;

    public Horse(String food, String location, String breed) {
        super(food, location, breed);
    }
    public Horse() {
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
        return "ржет";
    }
    @Override
    public String eat() {
        return "чавкает";
    }
}
