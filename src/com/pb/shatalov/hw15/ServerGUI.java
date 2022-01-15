package com.pb.shatalov.hw15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerGUI {

    public static LinkedList<Handler> clients = new LinkedList<>();

    static class Handler implements Runnable {
        private final Socket socket;;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try {
                System.out.println(Thread.currentThread().getName() + ": received request from client");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                System.out.println("Waiting message...");

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {

                    if ("exit".equalsIgnoreCase(clientMessage)) {
                        socket.close();
                        break;
                    }

                    for (Handler vr : clients) {
                        vr.send(clientMessage);
                    }

                    System.out.println(clientMessage);
                    Thread.sleep(100);
                    out.flush();
                }
                out.close();
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        private void send(String msg) throws IOException {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            try {
                out.write(msg + "\n");
                out.flush();
            } catch (IOException e) {
                System.out.println(e);
            }

        }
    }

    public static void main(String[] args) throws IOException {

        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);
        ExecutorService treadPool = Executors.newFixedThreadPool(4);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clients.add(new Handler(clientSocket));
            treadPool.submit(new Handler(clientSocket));
            clientSocket.getInputStream();
            clientSocket.getOutputStream();
        }
    }
}
