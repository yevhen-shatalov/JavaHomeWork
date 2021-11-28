package com.pb.shatalov.hw10;

public class Main {
    public static void main(String[] args) throws Exception {

        try {
            NumBox<Float> numBox = new NumBox<>(4);
            numBox.set(0, new Float(779));
            numBox.set(1, new Float(10));
            numBox.set(2, new Float(55));
            numBox.set(3, new Float(855));

            System.out.print(numBox.get(0)+", "); System.out.print(numBox.get(1)+", ");
            System.out.print(numBox.get(2)+", "); System.out.println(numBox.get(3));

            System.out.println("Количество элементов: " + numBox.length());
            numBox.average();
            numBox.sum();
            System.out.println("Max: " + numBox.max());
        } catch (Exception e) {
            System.out.println("error! " + e);
        }

    }
}
