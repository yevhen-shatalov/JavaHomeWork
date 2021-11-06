package com.pb.shatalov.hw6;

import java.lang.reflect.Constructor;

public class VetcCinic {
    public static void main(String[] args) throws Exception {
        Dog dog = new Dog("косточки","в сумочке", "чихуахуа");
        Cat cat = new Cat("рыбу", "на тумбочке", "сиамский");
        Horse horse = new Horse("овёс", "в стойле", "лошадь прожевальского");

        Veterenerian vet = new Veterenerian();

       // Class clazz = Class.forName("com.pb.shatalov.hw6.Veterenerian");
       // Object vet = clazz.newInstance();


        Animal[] anmls = new Animal[] {dog, cat, horse};
        for (Animal a: anmls) {
            vet.treatAnimal(a);
        }



    }
}
