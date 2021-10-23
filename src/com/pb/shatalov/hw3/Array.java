package com.pb.shatalov.hw3;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Array {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] array = new int[10];
        int x = 0;
        int max = 0;
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt(); //ввод элементов
        }

        System.out.println("Элементы массива: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " "); //вывод элементов
        }

        for (int i =0; i < array.length; i++) {
            x = x + array[i]; //сумма
        }
        System.out.println("\nСумма:");
        System.out.println(x); //вывод суммы

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                counter = counter + 1;
            }
        }
        System.out.println("Количество положительных элементов:\n" + counter);

        //Сортировка пузырьком
        int n = array.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
        System.out.println("Cортировка: ");
        for (int i = 0; i < n; i++)
            System.out.print(array[i] + " ");
    }
}


//Создайте класс Array в пакете hw3.Программа должна позволить пользователю ввести одномерный массив целых чисел размерностью 10 элементов.
//Вывести на экран введенный массив.
//Подсчитать сумму всех элементов массива и вывести ее на экран.
//Подсчитать и вывести на экран количество положительных элементов.
//Произвести сортировку этого массива от меньшего к большему по алгоритму сортировки пузырьком. (https://en.wikipedia.org/wiki/Bubble_sort)
//Вывести на экран отсортированный массив.