package com.pb.shatalov.hw11;

import java.io.*;
import java.util.*;

public class PhoneBook {

    private static HashMap<String, String> pb = new HashMap<String, String>();

    //addPB - добавляет запись по заданным номеру телефона и фамилии
    private static void addPB(String phone, String name) {
        pb.put(phone, name);
    }

    //delPB - удаляет запись по номеру телефона
    private static void delPB(String phone) {
        pb.remove(phone);
    }

    //savePB - сохраняет в текстовом файле phone.txt
    private static void savePB() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("phone.txt")));
        for(Map.Entry<String,String> k: pb.entrySet()){
            writer.write(k.getKey() + " " + k.getValue()+System.lineSeparator());
        }
        writer.close();
    }

    //loadPB - проверяет наличие файла, загружает из него данные
    public static void loadPB() throws IOException {
        File file = new File("phone.txt");
        if (file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(new File("phone.txt")));
            String act;
            while ((act=reader.readLine())!=null) {
                String[] dat = act.split(" ");
                pb.put(dat[0], dat[1]);
            }
            reader.close();
        }
    }

    //SortPhonebook - сортирует и выводит на екран
    public static void SortPhonebook(){
        Map sortedMap = sortByValues(pb);
        for (Map.Entry k : (Set<Map.Entry>) sortedMap.entrySet()) {
            System.out.println("name: " + k.getValue() + ", number: " + k.getKey());
        }
    }

    //FindSurname - производит поиск фамилии по номеру телефона заданому в качестве аргумента
    //возвращает строку
    public static String FindSurname(String number){
        String result = pb.get(number);
        if (result == null) return "абонент с таким номером не найдей";
        return result;
    }

    //FindNumberPhone - производит поиск списка номеров по фамилии заданой в качестве аргумента
    //возвращает массив строк
    public static String[] FindNumberPhone(String surname){
        List <String> result = new ArrayList<String>();
        for (Map.Entry entry : pb.entrySet()) {
            if (surname.equalsIgnoreCase((String)entry.getValue())){
                result.add((String)entry.getKey());
            }
        }
        if (result.size() == 0) result.add("абонент с такой фамилией не найден");
        return result.toArray(new String[0]);
    }

    public static void Edit(String phone, String name){
                pb.replace(phone, name);
        }

    public static void main(String[] args) throws IOException {
        //переменная для ввода данных
        String act;

        //чтение из файла
        loadPB();

        //вывод команд
        System.out.println("выбор действия: (add)добавить данные, (del)удалить данные, (sur)найти по имени, (num)найти по номеру," +
                " (sort)сортировать, (save)сохранить, (edit)редактировать имя по номеру, (exit)выход");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        act = bf.readLine();
        while(!act.equals("exit")){
            //добавление записи
            if(act.equals("add")){
                System.out.println("Введите имя:");
                String name = bf.readLine();
                System.out.println("Введите телефон:");
                String phone = bf.readLine();
                addPB(phone, name);
            }else{
                //удаление записи
                if(act.equals("del")){
                    System.out.println("Введите телефон:");
                    String phone = bf.readLine();
                    delPB(phone);
                }else{
                    //поиск номеров по фамилии
                    if (act.equals("sur")){
                        System.out.println("Введите имя:");
                        String surname = bf.readLine();
                        String[] numbers = FindNumberPhone(surname);
                        for (String number : numbers) {
                            System.out.println(number);
                        }
                    } else {
                        //поиск фамилии по номеру
                        if (act.equals("num")) {
                            System.out.println("Введите номер:");
                            String number = bf.readLine();
                            System.out.println(FindSurname(number));
                        } else {
                            //сохранение в файл
                            if(act.equals("save")){
                                savePB();
                            } else {
                                //сортировка
                                if(act.equals("sort")) {
                                    SortPhonebook();
                                } else {
                                    if (act.equals("edit")) {
                                        System.out.println("Введите телефон:");
                                        String phone = bf.readLine();
                                        System.out.println("Введите новое имя:");
                                        String name = bf.readLine();
                                        Edit(phone, name);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            //запрос на следующее действие
            System.out.println("выбор действия: (add)добавить данные, (del)удалить данные, (sur)найти по имени, (num)найти по номеру, (sort)сортировать," +
                    " (edit)редактировать имя по номеру, (save)сохранить, (exit)выход");
            act=bf.readLine();
        }
    }

    //алгоритм сортировки
    public static <K, V extends Comparable<V>>Map<K, V> sortByValues ( final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare == 0)
                    return 1;
                else
                    return compare;
            }
        };

        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
}