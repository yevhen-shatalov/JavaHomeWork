package com.pb.shatalov.hw12;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PhoneBook {
    private static List<Contact> contacts = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);
    private final ObjectMapper objectMapper;

    private static final DateTimeFormatter CHANGE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String DATA_FILE_PATH = "files/phone-book.json";

    public PhoneBook() {
        objectMapper = new ObjectMapper();
        // pretty printing (json с отступами)
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        // для работы с полями типа LocalDate и LocalDateTime
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        objectMapper.registerModule(module);
    }

    public void saveContacts() {
        try {
        String json = objectMapper.writeValueAsString(contacts);
        Files.write(Paths.get(DATA_FILE_PATH), json.getBytes(StandardCharsets.UTF_8));
    } catch (Exception ex) {
        System.out.println("Ошибка при сохранении файла: " + ex.getMessage());
        ex.printStackTrace();
        }
    }

    public void loadContacts() {
        try {
            byte[] bytesData = Files.readAllBytes(Paths.get(DATA_FILE_PATH));
            List<Contact> contacts = objectMapper.readValue(bytesData, new TypeReference<List<Contact>>() {});
            this.contacts.clear();
            this.contacts.addAll(contacts);
        } catch (Exception ex) {
            System.out.println("Ошибка при загрузки из файла: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void addContact() {
        try {
            System.out.println("Введите имя: ");
            String name = scan.nextLine().trim();
            System.out.println("дата рождения в формате yyyy-mm-dd: ");
            String date = scan.nextLine().trim();
            LocalDate dateOfBirth = LocalDate.parse(date);
            System.out.println("номер телефона(0-пропустить ввод) ");
            List<String> numbers = inputPhoneNumbers();

            System.out.println("адрес: ");
            String address = scan.nextLine().trim();
            LocalDate time = LocalDate.now();

            Contact contact = new Contact(name, dateOfBirth, numbers, address, time);
            contacts.add(contact);
            saveContacts();
        } catch (Exception e) {
            System.out.println("ошибка ввода");
        }
    }
    private List<String> inputPhoneNumbers() {
        List<String> numbers = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер телефона: ");
            String number = scan.nextLine().trim();
            if ("0".equals(number)) {
                return numbers;
            }
            numbers.add(number);
        }
    }

    public void delContact()  {
        System.out.println("введите имя:");
        String name = scan.nextLine().trim();
        Contact contact = findContactByName(name);
        if (contacts.contains(contact)) {
            contacts.remove(contact);
        } else {
            System.out.println("не найден");
        }
    }

    public void findContact() {
        System.out.println("Введите часть ФИО: ");
        String name = scan.nextLine();
        List<Contact> foundContacts = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getName().contains(name)) {
                foundContacts.add(c);
            }
        }
        printContacts(foundContacts);
    }

    public static void printContacts(List<Contact> contacts) {
        for (Contact c : contacts) {
            System.out.println("----------");
            System.out.println(c.getName() + " " + c.getDateOfBirth().toString() + " " + c.getAddress() + " " +
                    c.getChangeTime().format(CHANGE_TIME_FORMAT));
            System.out.println("тел.");
            if (c.getPhoneNumbers().size() > 0) {
                for (int i = 0; i < c.getPhoneNumbers().size(); i++) {
                    System.out.println(c.getPhoneNumbers().get(i));
                }
            }
        }
    }
    private Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (name.equals(contact.getName())) {
                return contact;
            }
        }
        return null;
    }

    public void editContact() {
        System.out.println("Введите фио контакта для редактирования: ");
        String name = scan.nextLine();
        Contact contact = findContactByName(name);
        if (contact == null) {
            System.out.println("Контакт не найден");
            return;
        }
        while (true) {
            printContacts(Collections.singletonList(contact));
            System.out.println("Редактировать");
            System.out.println("1. ФИО");
            System.out.println("2. Дату рождения");
            System.out.println("3. Телефоны");
            System.out.println("4. Адрес");
            System.out.println("5. Выход");
            String input = scan.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Введите ФИО: ");
                    String name_ = scan.nextLine();
                    contact.setName(name_);
                    contact.setChangeTime(LocalDate.now());
                    break;
                case "2":
                    System.out.println("Введите дату рождения (пример 2007-12-03): ");
                    String date = scan.nextLine();
                    contact.setDateOfBirth(LocalDate.parse(date));
                    contact.setChangeTime(LocalDate.now());
                    break;
                case "3":
                    System.out.println("Редактирования телефонов");
                    editPhoneNumbers(contact);
                    break;
                case "4":
                    System.out.println("Введите адрес: ");
                    String address = scan.nextLine();
                    contact.setAddress(address);
                    contact.setChangeTime(LocalDate.now());
                    break;
                default:
                    return;
            }
        }
    }
        public void sortContacts () {
            contacts.sort(new Comparator<Contact>() {
                @Override
                public int compare(Contact c1, Contact c2) {
                    return c1.getName().compareTo(c2.getName());
                }
            });
            printContacts(contacts);
        }

        private void editPhoneNumbers(Contact contact) {
        List<String> phoneNumbers = contact.getPhoneNumbers();
        while (true) {
            System.out.println("Телефоны:");
            for (int i = 0; i < phoneNumbers.size(); i++) {
                System.out.println((i + 1) + ". " + phoneNumbers.get(i));
            }
            System.out.println("Выберите действие");
            System.out.println("1. Добавить телефоны");
            System.out.println("2. Удалить телефон");
            System.out.println("3. Выход");
            System.out.print("Ввод: ");
            String input = scan.nextLine();
            switch (input) {
                case "1":
                    List<String> newNumbers = inputPhoneNumbers();
                    phoneNumbers.addAll(newNumbers);
                    contact.setChangeTime(LocalDate.now());
                    break;
                case "2":
                    System.out.println("Введите номер по порядку телефона для удаления (-1 для выход): ");
                    int num = Integer.parseInt(scan.nextLine());
                    if (num == -1) {
                        break;
                    }
                    phoneNumbers.remove(num - 1);
                    contact.setChangeTime(LocalDate.now());
                    break;
                default:
                    return;
            }
        }
    }
    }

