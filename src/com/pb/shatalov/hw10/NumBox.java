package com.pb.shatalov.hw10;

public class NumBox<T extends Number> {

    private final T[] numbers;

    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }

    public void set(int index, T dig) {
        this.numbers[index] = dig;
    }

    public T get(int index) {
        return numbers[index];
    }

    public int length() {
        return numbers.length;
    }

    public void average() {
        double a = 0;
        for (int i = 0; i < numbers.length; i++) {
            a = a + numbers[i].get();
        }
        System.out.println("Среднее арифметическое: " + a / numbers.length);
    }

    public void sum() {
        double b = 0;
        for (int i = 0; i < numbers.length; i++) {
            b = b + numbers[i].get();
        }
        System.out.println("Сумма: " + b);
    }

    public T max() {
        int n = numbers.length;

        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (numbers[j].value < numbers[j+1].value) {
                    int temp = numbers[j].value;
                    numbers[j].value = numbers[j+1].value;
                    numbers[j+1].value = temp;
                }
        return numbers[0];
    }
}