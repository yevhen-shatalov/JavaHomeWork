package com.pb.shatalov.hw5;

import static com.pb.shatalov.hw5.Book.bookCounter;

public class Library {
    public static void main(String[] args) {

        Book book1 = new Book("Приключения", "Иванов И. И.", "2000");
        Book book2 = new Book("Словарь", "Сидоров А. В.", "1980");
        Book book3 = new Book("Энциклопедия", "Гусев К. В.", "2010");
        Reader reader1 = new Reader("Петров В.В.", "12345", "ООП", "150595", "050123456");
        Reader reader2 = new Reader("Шаталов Е.А.", "789123", "Физ", "051186", "0669876543");

        System.out.println(book1.getInfo());
        System.out.println(book2.getInfo());
        System.out.println(book3.getInfo() + "\n");

        reader1.getReader();
        reader2.getReader(); System.out.print("\n");

        reader1.getFio();
        reader1.takeBook(bookCounter);
        reader1.getFio();
        reader1.takeBook(book1.title, book2.title, book3.title);
        reader1.getFio();
        reader1.takeBook(book1.getInfo(), book2.getInfo(), book3.getInfo()); System.out.print("\n");

        reader2.getFio();
        reader2.returnBook(bookCounter);
        reader2.getFio();
        reader2.returnBook(book1.title, book2.title, book3.title);
        reader2.getFio();
        reader2.returnBook(book1.getInfo(), book2.getInfo(), book3.getInfo());
    }
}