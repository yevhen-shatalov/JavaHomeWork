package com.pb.shatalov.hw10;

public class Main {
    public static void main(String[] args) throws Exception {

        try {
            NumBox<Float> numBox = new NumBox<>(4);
            numBox.set(0, new Float(779));
            numBox.set(1, new Float(10));
            numBox.set(2, new Float(55));
            numBox.set(3, new Float(855));

            Number dig1 = numBox.get(0); Number dig2 = numBox.get(1);
            Number dig3 = numBox.get(2); Number dig4 = numBox.get(3);
            System.out.print(dig1.get()+", "); System.out.print(dig2.get()+", ");
            System.out.print(dig3.get()+", "); System.out.println(dig4.get());

            System.out.println("Количество элементов: " + numBox.length());
            numBox.average();
            numBox.sum();
            System.out.println("Max: " + numBox.max());
        } catch (Exception e) {
            System.out.println("error! " + e);
        }

    }
}
