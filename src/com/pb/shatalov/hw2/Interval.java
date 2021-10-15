package com.pb.shatalov.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {

        int a;
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите число от 1 до 100");
        a = scan.nextInt();

        if (a < 0) {
            System.out.println("Введите число от 1 до 100");
        }
        if (a > 100){
                System.out.println("Введите число от 1 до 100");
            }

        if (a >= 0) {
            if (a <= 14) {
                System.out.println("[0-14]");
            }
        }

        if (a >=15) {
            if (a <= 35){
                System.out.println("[15-35]");
            }
        }

        if (a >=36) {
            if (a <= 50){
                System.out.println("[36-50]");
            }
        }

        if (a >=51) {
            if (a <= 100){
                    System.out.println("[51-100]");
                }
            }



        }
        }
