package com.pb.shatalov.hw13;

import java.util.LinkedList;
import java.util.concurrent.TransferQueue;

public class MultiTread {
    public static void main(String[] args) throws Exception {

        LinkedList<String> sharedList = new LinkedList<>();
        int size = 5;
        Thread producerThread = new Thread(new Producer(sharedList, size), "Производитель");
        Thread consumerThread = new Thread(new Consumer(sharedList), "Потребитель");
        producerThread.start();
        consumerThread.start();

        Thread.sleep(200);

        producerThread.interrupt();
        consumerThread.interrupt();

    }
}