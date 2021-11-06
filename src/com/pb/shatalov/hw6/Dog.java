package com.pb.shatalov.hw6;

public class Dog extends Animal {

    private String dogName;

    public Dog(String food, String location, String breed) {
        super(food, location, breed);
    }
    public Dog() {
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
        return "гавкает";
    }
    @Override
    public String eat() {
        return "хрумает";
    }

}
