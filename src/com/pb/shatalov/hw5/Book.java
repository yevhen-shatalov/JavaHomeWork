package com.pb.shatalov.hw5;

public class Book {

    public static int bookCounter = 0;

    String title;
    String author;
    String year;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
        bookCounter++;
    }
    public String getInfo() {
        return title + " " + "(" + author + year + ")";
    }
}