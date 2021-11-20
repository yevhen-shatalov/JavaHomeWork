package com.pb.shatalov.hw8;

public class WrongLoginExeption extends RuntimeException {

    private String login;

    public WrongLoginExeption(String login) {
        this.login = login;
    }
}
