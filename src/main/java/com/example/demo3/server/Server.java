package com.example.demo3.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    private ServerSocket serverSocket;
    private Socket client;
    public Vector<UserSocket> userSockets = new Vector<>();
    public Server()throws Exception{
        serverSocket = new ServerSocket(7777);

        while (true) {
            client = serverSocket.accept();
            UserSocket userSocket = new UserSocket(client);
            userSockets.add(userSocket);
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


class UserSocket{
        public Socket socket;
        public DataInputStream dataInputStream;
        public DataOutputStream dataOutputStream;
        public String userName;

    public UserSocket(Socket socket)throws IOException {
        this.socket = socket;
        this.dataInputStream = new DataInputStream(socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }
}
}