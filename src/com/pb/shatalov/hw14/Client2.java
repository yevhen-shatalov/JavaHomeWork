package com.pb.shatalov.hw14;

import java.io.*;
import java.net.Socket;
import java.time.LocalTime;

public class Client2 {
    private Socket socket;
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток чтения в сокет
    private BufferedReader inputUser; // поток чтения с консоли
    private String nickname;

    public Client2(String addr, int port) {

        try {
            this.socket = new Socket(addr, port);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {
            // потоки чтения из сокета / записи в сокет, и чтения с консоли
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.askNickname();
            new Client2.ReadMsg().start(); // нить читающая сообщения из сокета в бесконечном цикле
            new Client2.WriteMsg().start(); // нить пишущая сообщения в сокет приходящие с консоли в бесконечном цикле
        } catch (IOException e) {
        }

    }

    private void askNickname() {
        System.out.print("Enter your name: ");
        try {
            nickname = inputUser.readLine();
           // out.write("Hi " + nickname + "\n");
            out.flush();
        } catch (IOException ignored) {
        }
    }

    // нить чтения сообщений с сервера
    private class ReadMsg extends Thread {
        @Override
        public void run() {

            String str;
            try {
                while (true) {
                    str = in.readLine(); // ждем сообщения с сервера
                    if (str.equals("exit")) {
                        System.out.println("disconnected");
                        break;
                    }
                    System.out.println(str); // пишем сообщение с сервера на консоль
                }
            } catch (IOException e) {
            }
        }
    }

    // нить отправляющая сообщения на сервер
    public class WriteMsg extends Thread {

        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    userWord = inputUser.readLine(); // сообщения с консоли
                    if (userWord.equals("exit")) {
                        //out.write("exit");
                        inputUser.close();
                        in.close();
                        out.close();
                        break;
                    } else {
                        out.write(nickname + " " + "(" + LocalTime.now() + "): " + userWord + "\n"); // отправляем на сервер
                    }
                    out.flush(); // чистим
                } catch (IOException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Srarted, type 'exit to stop'");
        String ipAddr = "localhost";
        int port = 1234;
        new Client(ipAddr, port);
    }
}
