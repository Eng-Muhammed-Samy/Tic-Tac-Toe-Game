package com.example.demo3.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket client;
//    private Scanner clientName = new Scanner(System.in);
    public Server()throws Exception{
        serverSocket = new ServerSocket(7777);

        while (true) {
            client = serverSocket.accept();

            HandleSocket handleSocket = new HandleSocket(client);
            handleSocket.start();
        }
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
