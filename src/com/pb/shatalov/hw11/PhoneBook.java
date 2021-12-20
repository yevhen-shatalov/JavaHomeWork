package com.pb.shatalov.hw11;

import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class PhoneBook {

    private static void saveContacts(Map<String, List<String>> contacts) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("phone.txt")));
        for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
            writer.write(entry.getKey() + ", " + entry.getValue().toString().replaceAll("\\[|]", "") + System.lineSeparator());
        }
        writer.close();
    }

    private static void loadContacts(Map<String, List<String>> contacts) throws IOException {
        File file = new File("phone.txt");
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(new File("phone.txt")));
            String act;
            while ((act = reader.readLine()) != null) {
                String[] dat = act.split(", ");
                String[] dat2 = Arrays.copyOfRange(dat, 1, 5);
                contacts.put(dat[0], Arrays.asList(dat2));
            }
            reader.close();
        }
    }

    private static void listContacts(Map<String, List<String>> contacts) {
        if (!contacts.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
                System.out.print(entry.getKey() + " - ");
                for (String number : entry.getValue()) {
                    System.out.print(number + ", ");
                }
                System.out.println();
            }
        } else {
            System.out.println("записей пока нет");
        }

        System.out.println();
        System.out.println("введите команду или 'exit' - для завершения");
    }

    private static void addContact(Map<String, List<String>> contacts, Scanner input) throws IOException {
        String name;
        String number;
        String city;
        String date;
        LocalDate time;

        System.out.println("Введите имя: ");
        name = input.nextLine().trim();
        System.out.println("Введите номер: ");
        number = input.nextLine().trim();
        System.out.println("адрес: ");
        city = input.nextLine().trim();
        System.out.println("дата рождения: ");
        date = input.nextLine().trim();
        time = LocalDate.now();

        List<String> data = new ArrayList<>();
        data.add(number);
        data.add(city);
        data.add(date);
        data.add(time.toString() + ", ");
        contacts.put(name, data);
        saveContacts(contacts);
        System.out.println("успешно добавлен");

        System.out.println();
        System.out.println("введите команду");
    }

    private static void delContact(Map<String, List<String>> contacts, Scanner input) throws IOException {
        System.out.println("кого удалить? :");
        String name = input.nextLine().trim();
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            saveContacts(contacts);
        } else {
            System.out.println("не найден");
        }
    }

    private static void findContact(Map<String, List<String>> contacts, Scanner input) {
        System.out.println("для поиска введите имя: ");
        String name = input.nextLine().trim();
        if (contacts.containsKey(name)) {
            for (String number : contacts.get(name)) {
                System.out.print(number + ", ");
            }
        } else {
            System.out.println("не найдено");
        }
    }

    private static void editContact(Map<String, List<String>> contacts, Scanner input) throws IOException {
        System.out.println("введите имя для изменения контакта: ");
        String name = input.nextLine().trim();
        if (contacts.containsKey(name)) {
            List<String> data = new ArrayList<>(contacts.get(name));
            for (String number : contacts.get(name)) {
                System.out.print(number + ", ");
            }
            contacts.remove(name);
            System.out.println();
            System.out.println("новое имя: ");
            String newName = input.nextLine().trim();
            System.out.println("новый номер: ");
            String newNumber = input.nextLine().trim();
            data.add(newNumber);
            System.out.println("новый адрес: ");
            String newCity = input.nextLine().trim();
            data.add(newCity);
            System.out.println("дата рождения: ");
            String newDate = input.nextLine().trim();
            data.add(newDate);
            LocalDate newTime = LocalDate.now();
            data.add(newTime.toString());
            contacts.put(newName, data);
            saveContacts(contacts);
        }
    }

    public static void sortContacts(Map<String, List<String>> contacts) {
        List<String> keys = new ArrayList<>(contacts.keySet());
        Collections.sort(keys);
        System.out.println(keys.toString());
    }

    public static void main(String[] args) throws IOException {
        //Сотрировка через TreeMap
        Map<String, List<String>> contacts = new TreeMap<>();
        Scanner input = new Scanner(System.in);
        loadContacts(contacts);
        System.out.println("выбор действия: (list)список, (add)добавить, (del)удалить, (find)найти по имени," +
                " (sort)сортировать, (save)сохранить, (edit)редактировать, (exit)выход");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String act = bf.readLine();
        while (!act.equals("exit")) {
            //добавление записи
            if (act.equals("add")) {
                addContact(contacts, input);
            } else {
                //удаление записи
                if (act.equals("del")) {
                    delContact(contacts, input);
                } else {
                    //поиск по имени
                    if (act.equals("find")) {
                        findContact(contacts, input);
                    } else {
                        //редактор
                        if (act.equals("edit")) {
                            editContact(contacts, input);
                        } else {
                            //сортировка
                            if (act.equals("sort")) {
                                sortContacts(contacts);
                            } else {
                                //печать
                                if (act.equals("list")) {
                                    listContacts(contacts);
                                }
                            }
                        }
                    }
                }
            }
            //запрос на следующее действие
            System.out.println("выбор действия: (list)список, (add)добавить, (del)удалить, (find)найти по имени, (sort)сортировать," +
                    " (edit)редактировать, (save)сохранить, (exit)выход");
            act = bf.readLine();
        }
    }
}