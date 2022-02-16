package com.example.demo3;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private ServerSocket serverSocket;

    ChatServer(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }
    public void startServer(){
        try {
            while (!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                System.out.println("A New Player Has Connected!");
                ChatHandler chatHandler = new ChatHandler(socket);
                Thread thread = new Thread(chatHandler);
                thread.start();
            }
        }catch (IOException e){

        }

    }
    public void closeServerSocket(){
        try {
            if (serverSocket != null){
                serverSocket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5005);
        ChatServer chatServer = new ChatServer(serverSocket);
        chatServer.startServer();

    }
}

