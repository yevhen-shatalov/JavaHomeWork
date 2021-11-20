package com.pb.shatalov.hw8;

import java.util.Scanner;

public class Auth {
    private String login;
    private String password;
    Scanner scan = new Scanner(System.in);

    public Auth() {
        this.login = login;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    void signUp() throws WrongLoginExeption {
        System.out.println("Придумайте логин: ");
        String tempLogin = scan.next();
        boolean latinLog = tempLogin.matches("^[a-zA-Z0-9]+$");
        if (latinLog != true)
            throw new WrongLoginExeption(login);
           if (tempLogin.toCharArray().length < 5 || tempLogin.toCharArray().length > 20)
            throw new WrongLoginExeption(login);
                else setLogin(tempLogin);
        System.out.println("Придумайте пароль: ");
        String tempPass = scan.next();
        boolean latinPas = tempPass.matches("^[a-zA-Z0-9_]+$");
        if (latinPas != true)
            throw new WrongPasswordExeption(login);
            if (tempPass.toCharArray().length < 5)
               throw new WrongPasswordExeption(login);
        System.out.println("Повторите пароль: ");
        String tempPass2 = scan.next();
        if (tempPass2.equals(tempPass)) {
            setPassword(tempPass2);
            System.out.println("Вы зарегистрировались.");
        } else {
            System.out.println("пароли не совпали");
            throw new WrongPasswordExeption(login);
        }
    }
    void signIn() {
        System.out.println("Введите логин: ");
        String templog = scan.next();
        System.out.println("Введите пароль: ");
        String temppas = scan.next();
        if (templog.equals(login) && temppas.equals(password))
            System.out.println("Здравствуйте " + login);
            else System.out.println("не правильный логин/пароль");
        }
    }