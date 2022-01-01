package com.pb.shatalov.hw13;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

    private final List<String> sharedList;

    private final int maxSize;

    public Producer(List<String> sharedList, int maxSize) {
        this.sharedList = sharedList;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("Создал: " + produce());
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private String produce() throws InterruptedException {
        synchronized (sharedList) {
            if (sharedList.size() >= maxSize) {
                System.out.println("Производитель ждёт...");
                sharedList.wait();
            }
            Random r = new Random();
            String newLetter = "" + r.nextInt(); //рандомное число перевел в строку
            sharedList.add(newLetter);
            sharedList.notifyAll();
            return newLetter;
        }
    }
}
