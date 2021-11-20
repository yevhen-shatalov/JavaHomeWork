package com.pb.shatalov.hw8;

public class WrongPasswordExeption extends RuntimeException {

    private String password;

    public WrongPasswordExeption (String password) {
        this.password = password;
    }
}
