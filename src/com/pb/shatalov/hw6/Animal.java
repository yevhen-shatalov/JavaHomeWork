package com.pb.shatalov.hw6;

import java.util.Objects;

public class Animal {
    private String food;
    private String location;
    private String breed;

    public Animal(String food, String location, String breed) {
        this.food = food;
        this.location = location;
        this.breed = breed;
    }
    public Animal() {
    }

    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getFood() {
        return food;
    }
    public void setFood(String food) {
        this.food = food;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "food='" + food + '\'' +
                ", location='" + location + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(food, animal.food) && Objects.equals(location, animal.location) && Objects.equals(breed, animal.breed);
    }
    @Override
    public int hashCode() {
        return Objects.hash(food, location, breed);
    }

    public String makeNoise(){
        return "шумит";
    }
    public String  eat() {
        return "ест";
    }
    public String sleep() {
        return getBreed() + "спит";
    }

}