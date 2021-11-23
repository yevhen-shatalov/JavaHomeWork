package com.pb.shatalov.hw9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FileNumbers {
    public static void main(String[] args) {

        Random random = new Random();
        int i = 0;
        int[] array = new int[100];
        while (i < 100) {
            array[i] = random.nextInt(100);
            i++;
            }

        String tempArray = Arrays.toString(array);
        String temp[] = tempArray.split(" ");
        for (int x =0; x < temp.length; x+=11) {
            temp[x] = "\n";
        }

        String temp2 = Arrays.toString(temp).replaceAll("[^0-9\n]", " ");
        System.out.println(temp2);

        createNumbersFile(temp2);
        createOddNumbersFile();
    }

    private static void createNumbersFile(String data) {
        try (Writer writer = new FileWriter("C:/Users/Zhenya/Desktop/JavaHomeWork/numbers.txt")){
            writer.write(data);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static void createOddNumbersFile() {
        Path path = Paths.get("C:/Users/Zhenya/Desktop/JavaHomeWork/numbers.txt");
        Path path1 = Paths.get("C:/Users/Zhenya/Desktop/JavaHomeWork/odd-numbers.txt");
        String[] b = new String[60]; //создание массива для обработки прочитанного файла
        int i = 0;

        try (Scanner scan = new Scanner(path)) {
            while (scan.hasNextLine()) { //чтение
              int d = scan.nextInt();
                if (d % 2 == 0) { //сортировка
                    i++;
                    b[i] = Integer.toString(d); //массив стринг
                    for (int x =0; x < b.length; x+=11)  //разбивка на строки
                        b[x] = "\n";
                }
            }
        } catch(Exception ex){
                System.out.println(Arrays.toString(b).replaceAll("[^0-9\n]", " "));
                System.out.println("Файл прочитан, отсортирован и перезаписан в odd-numbers.txt");
            }

        String z = Arrays.toString(b).replaceAll("[^0-9\n]", " ");

        try (BufferedWriter writer = Files.newBufferedWriter(path1)) {
            writer.write(z);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}