package com.pb.shatalov.hw13;

import java.util.Random;

public class Producer extends Thread {
    static Random rand = new Random();
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                //Приостанавливает поток на 1 секунду максимум
                sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(""+i);
        }
    }
}
