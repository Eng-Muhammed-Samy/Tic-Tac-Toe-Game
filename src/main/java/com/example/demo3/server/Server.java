package com.example.demo3.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket client;
    public Server()throws Exception{
        serverSocket = new ServerSocket(7777);

        while (true) {
            client = serverSocket.accept();
            new HandleSocket(client);
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
