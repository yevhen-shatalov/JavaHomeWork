package com.pb.shatalov.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.time.LocalTime;

public class ClientWindow implements ActionListener{

    private final JTextArea log = new JTextArea();
    private final JTextArea name = new JTextArea();
    private final JTextField Input = new JTextField();
    private final JFrame frame = new JFrame();

    private Socket socket;
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток чтения в сокет
    private BufferedReader inputUser; // поток чтения с консоли
    private String nickname;

    private ClientWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.add(log, BorderLayout.CENTER);
        frame.add(Input, BorderLayout.SOUTH);
        frame.add(name, BorderLayout.NORTH);

        Input.addActionListener(this);
        log.setText("Введите ник вверху: \n");
        log.setEditable(false);

        try {
            // потоки чтения из сокета / записи в сокет, и чтения с консоли
            this.socket = new Socket("localhost", 1234);
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            new ClientWindow.WriteMsg().start(); // нить пишущая сообщения в сокет
            new ClientWindow.ReadMsg().start(); // нить читающая сообщения из сокета
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
    }

    private class ReadMsg extends Thread {
        @Override
        public void run() {
            String str;
            try {
                while ((str = in.readLine()) != null) {
                    if (str.equals("exit")) {
                        break;
                    }
                    log.append(str + "\n");
                }
            } catch (IOException e) {
            }
        }
    }

    private class WriteMsg extends Thread {
        @Override
        public void run() {
                Input.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                          sendMess(Input.getText());
                    }
                });
            }
        }

    public void sendMess (String userWord) {
        nickname = name.getText();
        try {
            userWord = Input.getText();
            if (userWord.equals("exit")) {
                out.write("exit\n");
                out.flush();
            } else {
                out.write(nickname + " " + "(" + LocalTime.now() + "): " + userWord + "\n"); // отправляем на сервер
            }
            out.flush(); // чистим
            Input.setText(null);
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientWindow();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
