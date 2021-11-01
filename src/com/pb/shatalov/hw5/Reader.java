package com.pb.shatalov.hw5;
public class Reader {
    String fio;
    String  ticket;
    String facultet;
    String birth;
    String phoneNum;
    public Reader(String fio, String ticket, String facultet, String birth, String phoneNum) {
        this.fio = fio;
        this.ticket = ticket;
        this.facultet = facultet;
        this.birth = birth;
        this.phoneNum = phoneNum;
    }
    public String getFio() {
        System.out.print(fio);
        return null;
    }
    public String getReader() {
        System.out.print(fio + ", " + "Билет-" + ticket + ", Фак-" + facultet + ", ДР-" + birth + ", Тел-" + phoneNum + "\n");
        return null;
    }
    public void takeBook(int n) {
        System.out.print(" взял: " + n + " книги\n");
        return;
    }
    public void takeBook(String... book) {
        System.out.print(" взял: ");
        for (String number : book) {
            System.out.print(number + ", ");
        }
        System.out.print("\n");
        return;
    }
    public void returnBook(int n) {
        System.out.print(" вернул: " + n + " книги\n");
        return;
    }
    public void returnBook(String... book) {
        System.out.print(" вернул: ");
        for (String number : book) {
            System.out.print(number + ", ");
        }
        System.out.print("\n");
        return;
    }
}