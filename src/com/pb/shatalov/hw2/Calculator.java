package com.pb.shatalov.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int operand1;
        int operand2;
        String sign;
        String a = "+";
        String b = "-";
        String c = "*";
        String d = "/";

        System.out.print("operand1 = ");
        operand1 = scan.nextInt();

        System.out.print("operand2 = ");
        operand2 = scan.nextInt();

        System.out.print("znak ");
        sign = scan.next();

        switch (sign) {
            case ("+"):
                System.out.println(operand1+operand2);
                break;
            case ("-"):
                System.out.println(operand1-operand2);
                break;
            case ("*"):
                System.out.println(operand1*operand2);
                break;
            case ("/"):
                if (operand2==0) {
                System.out.println("на ноль делить нельзя");
            } else{
                System.out.println(operand1/operand2);
            }
                break;

        }
    }
}
