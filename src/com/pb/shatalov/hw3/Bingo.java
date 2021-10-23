package com.pb.shatalov.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int counter = 0;
        int x = random.nextInt(101);
        int a;
        String b;

        System.out.println("Угадайте число от 0 до 100, у вас 9 попыток, для выхода наберите exit");

        while (counter < 9) {
            counter++;
            System.out.println("Введите число");
            b = scan.next();
                //выход из программы
            if (b.equals("exit")) {
                System.out.println("Good bye");
                break;
            }
                //проверка, если оставалась последняя попытка и пользоватеть отгадал верно
            a = Integer.parseInt(b);
            if (counter == 9 && a == x) {
                System.out.println("Вы угадали с " + counter + " попытки");
                break;
            }
                //проверка, если оставалась последняя попытка и пользоватеть отгадал не верно
            else if (counter ==9) {
                System.out.println("Не осталось попыток, загаданное число: " + x);
                break;
            }

            if (a == x) {
                System.out.println("Вы угадали с " + counter + " попытки");
                break;
            } if (a < x) {
                System.out.println("Число меньше загаданного");
                continue;
            } if (a > x) {
                System.out.println("Число больше загаданного");
                continue;
            }

        }

        System.out.println("Game over");
    }


}

//Программа должна загадать целое число в диапазоне от 0 до 100 и предложить пользователю его отгадать.
//При вводе числа пользователем, программа проверяет на соответствие с загаданным число и если числа совпали вывести сообщение о том, что число отгадано.
//Если числа не совпали, тогда следует вывести надпись о том, что задуманное число является больше или меньше вводимого.
//Также программа ведет подсчет попыток, и выводит это количество после того как число угадали.
//Предусмотреть возможность досрочного завершения программы, в случае если пользователь не желает продолжать угадывать число.