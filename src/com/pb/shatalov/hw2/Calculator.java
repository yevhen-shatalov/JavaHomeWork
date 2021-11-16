package com.pb.shatalov.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        float operand1;
        float operand2;
        float result;
        String sign;

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
                    result = operand1/operand2;
                System.out.println(result);
            }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + sign);
        }
    }
}
