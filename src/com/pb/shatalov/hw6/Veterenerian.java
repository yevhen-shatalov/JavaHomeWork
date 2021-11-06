package com.pb.shatalov.hw6;

public class Veterenerian {

    void treatAnimal (Animal animal) {
        System.out.println(animal.getBreed() + " " + animal.eat() + " " + animal.getFood() +
                " " + animal.getLocation() + " и " + animal.makeNoise());
    }
}
