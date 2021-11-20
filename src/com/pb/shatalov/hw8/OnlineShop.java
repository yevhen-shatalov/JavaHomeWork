package com.pb.shatalov.hw8;

public class OnlineShop {
    public static void main(String[] args) throws WrongLoginExeption, WrongPasswordExeption {
        Auth auth = new Auth();
        System.out.println("Пройдите регистрацию (логин - только латиница и цифры от 5 до 20 символов, пароль - только латиница, цифры и занак подчеркивания от 5 символов)");
        try {
            auth.signUp();
            System.out.println("Введите ваш логин и пароль");
            auth.signIn();
        } catch (WrongLoginExeption | WrongPasswordExeption e) {
            System.out.println("ошибка ввода " + e);
        }
    }
}
