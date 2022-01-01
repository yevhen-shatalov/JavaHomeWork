package com.pb.shatalov.hw13;

import java.util.List;

public class Consumer implements Runnable {

    private final List<String> sharedList;

    public Consumer(List<String> sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("Принял: " + consume().replaceAll("[\\u005B-\\u005D]",""));//убрал квадратные скобки
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                break;
            }
        }
    }
    private String consume() throws InterruptedException {
        synchronized (sharedList) {
            if (sharedList.isEmpty()) {
                System.out.println("Потребитель ждёт...");
                sharedList.wait();
            }
            sharedList.notifyAll();
            String list = sharedList.toString();
            sharedList.clear(); //очистил буфер
            return list;
        }
    }
}
