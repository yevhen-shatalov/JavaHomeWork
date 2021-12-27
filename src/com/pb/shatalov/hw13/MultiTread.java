package com.pb.shatalov.hw13;

public class MultiTread {
    public static void main(String[] args) {

        Producer action = new Producer();
        System.out.println("start");
        action.start();

        
    }
}