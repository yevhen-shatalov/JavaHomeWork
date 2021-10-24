package com.pb.shatalov.hw4;

import java.util.Locale;
import java.util.Scanner;

public class CapitalLetter {

    static void print() {

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] inputParts = input.split(" "); //разбиваем предложение на слова, создаём массив
        for (int i = 0; i < inputParts.length; i++) {
            String[] inputLetter = inputParts[i].split(""); //разбиваем слова на буквы, создаём массив
            for (int j = 0; j < inputLetter.length; j++) {
                String L = inputLetter[0];
                inputLetter[0] = L.toUpperCase(); //присваеваем каждой первой букве в слове заглвную
                System.out.print(inputLetter[j]);
            }
            System.out.print(" "); //для пробела между словами
        }
    }

    public static void main(String[] args) {
        print();
    }
}


//Создайте класс CapitalLetter в пакете hw4.
//Напишите программу, которая принимает строку и переводит первую букву слова в верхний регистр.
//Строку должен ввести пользователь.
//Пример работы:
//Истина — это то, что выдерживает проверку опытом. Эйнштейн А.
//Истина — Это То, Что Выдерживает Проверку Опытом. Эйнштейн А.
//При выполнении задания использовать метод(ы).