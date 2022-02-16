package com.example.demo3;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClint {
    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String playerUserName;

    public ChatClint(Socket socket, String playerUserName){
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.playerUserName = playerUserName;
        }catch (IOException e){
            closeEveryThing(socket, bufferedWriter, bufferedReader);
        }
    }
    public void sendMessage(){
        try {
            bufferedWriter.write(playerUserName);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()){
                String messageToSend = scanner.nextLine();
                bufferedWriter.write(playerUserName + ":" + messageToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }catch (IOException e){
            closeEveryThing(socket, bufferedWriter, bufferedReader);
        }
    }
    public void listenFromMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromGroupChat;

                while (socket.isConnected()){
                    try {
                        msgFromGroupChat = bufferedReader.readLine();
                        System.out.println(msgFromGroupChat);
                    }catch (IOException e){
                        closeEveryThing(socket, bufferedWriter, bufferedReader);
                    }
                }

            }
        }).start();
    }
    public void closeEveryThing(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader){
       try {
           if (socket != null){
               socket.close();
           }
           if (bufferedWriter !=null){
               bufferedWriter.close();
           }
           if (bufferedReader !=null){
               bufferedReader.close();
           }
       }catch (IOException e){
           e.printStackTrace();
       }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your username for Group Chat: ");
        String playerUserName = scanner.nextLine();
        Socket socket = new Socket("localhost", 5005);
        ChatClint chatClint = new ChatClint (socket, playerUserName);
        chatClint.listenFromMessage();
        chatClint.sendMessage();
    }
}
