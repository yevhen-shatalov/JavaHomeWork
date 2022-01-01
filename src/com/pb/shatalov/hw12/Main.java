package com.pb.shatalov.hw12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.loadContacts();

        while (true) {
            System.out.println("выбор действия: (list)сортировка, (add)добавить, (del)удалить, (find)найти по имени," +
                    " (save)сохранить изменения, (edit)редактировать, (exit)выход");
            String input = scan.nextLine();

            if (input.equals("exit")) {
                break;
            } else {

                if (input.equals("add")) {
                    phoneBook.addContact();
                } else {

                    if (input.equals("del")) {
                        phoneBook.delContact();
                    } else {

                        if (input.equals("find")) {
                            phoneBook.findContact();
                        } else {

                            if (input.equals("edit")) {
                                phoneBook.editContact();
                            } else {

                                if (input.equals("list")) {
                                    phoneBook.sortContacts();
                                    } else {
                                    if (input.equals("save")) {
                                        phoneBook.saveContacts();
                                    } else {
                                        if (input.equals("load")) {
                                            phoneBook.loadContacts();
                                        }
                                    }
                                }
                            }
                            }
                        }
                    }
                }
            }
        }
    }