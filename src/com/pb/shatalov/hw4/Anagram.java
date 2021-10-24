package com.pb.shatalov.hw4;


import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        gram();

    }

    static void gram() {
        Scanner in = new Scanner(System.in);

        String in1 = in.nextLine();
        String in2 = in.nextLine();

        String input1 = in1.replaceAll("[\\W]","");
        String input2 = in2.replaceAll("[\\W]","");
        char[] a = input1.toCharArray();
        char[] b = input2.toCharArray();
        //Сортировка первой строки
        int n = a.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - 1; j++)
                if (a[j] > a[j + 1]) {
                    char temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
                //Вывод по порядку 1 строки
                for (int k = 0; k < n; k++) {
                    input1 = (a[k] + "");
                    System.out.print(input1);
                }
        System.out.print("\n");
        //Сортировка второй строки
        int m = b.length;
        for (int i = 0; i < m - 1; i++)
            for (int j = 0; j < m - 1; j++)
                if (b[j] > b[j + 1]) {
                    char temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
                //Выаод по порядку 2 строки
                for (int k = 0; k < m; k++) {
                    input2 = (a[k] + "");
                    System.out.print(input2);
                }
                //Сравнение
                System.out.print("\n");

        int z = input1.compareToIgnoreCase(input2);
        if (z == 0) {
            System.out.println("Это анаграммы");
        } else {
            System.out.println("Это не анаграммы");
        }
    }
}
//Создайте класс Anagram в пакете hw4.
//Напишите программу, которая определяет, является ли одна строка анаграммой другой строки.
//Обе строки вводит пользователь.
//Анаграмма - это слово или фраза, сделанная путем переноса букв другого слова или фразы.
//Программа должна игнорировать пробелы и знаки препинания.
//Пример анаграмм:
//Аз есмь строка, живу я, мерой остр. -> За семь морей ростка я вижу рост.
//Я в мире — сирота. -> Я в Риме — Ариост.
//При выполнении задания использовать метод(ы).