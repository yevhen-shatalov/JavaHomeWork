package com.pb.shatalov.hw8;

public class OnlineShop {
    public static void main(String[] args) throws WrongLoginExeption, WrongPasswordExeption {
        Auth auth = new Auth();
        System.out.println("Пройдите регистрацию (логин - только латиница и цифры, пароль - только латиница, цифры и занак подчеркивания)");
        try {
            auth.signUp();
            System.out.println("Введите ваш логин и пароль");
            auth.signIn();
        } catch (WrongLoginExeption|WrongPasswordExeption e) {
            System.out.println("ошибка ввода " + e);
        }
    }
}
