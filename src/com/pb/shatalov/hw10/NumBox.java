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


//Реализовать параметризованный класс NumBox, T - параметр типа.+
//Параметром должен быть любой класс-наследник Number (задать необходимое условие при объявлении класса NumBox).+
//Класс содержит:
//- массив из объектов класса T, инициализировать массив в конструкторе.+
//- конструктор принимающий параметр - максимальную длину массива.+
//- метод void add(T num) добавляющий число в массив.+ В случае если массив полон - выбросить исключение.+
//- метод T get(int index) возвращающий число по индексу.+
//- метод int length() возвращает текущее количество элементов.+
//- метод double average() - подсчет среднего арифметического среди элементов массива.+
//- метод double sum() - сумма всех элементов массива.+
//- метод T max() - максимальный элемент массива.+
//При подсчете воспользоваться тем, что у любого из объектов подклассов Number есть методы intValue, doubleValue, floatValue и другие.
//
//
//Создать класс Main с методом main где протестировать полученный класс на примере NumBox<Float> и NumBox<Integer>.