package com.example.demo3.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataInputStream fromServer;
    private DataOutputStream toServer;
    private Scanner scanner;

    public Client(){
        try {
            socket = new Socket("localhost", 7777);
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner = new Scanner(System.in);

         Thread send = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                    toServer = new DataOutputStream(socket.getOutputStream());
                    System.out.println("Enter your Name: ");
                    String name = new Scanner(System.in).nextLine();
                    toServer.writeUTF(name);
                     System.out.println("Enter to Name: ");
                     String toName = new Scanner(System.in).nextLine();
                    while (true) {

                        toServer.writeUTF(toName+":"+scanner.nextLine());
                        }
                    } catch (Exception e) {
                        }

                }
            });

           Thread recive = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            fromServer = new DataInputStream(socket.getInputStream());
                            String msg = fromServer.readUTF();
                            System.out.println(msg);
                        } catch (Exception e) {
                        }
                    }
                }
            });
           send.start();
           recive.start();
        }

        public void initialize(URL url, ResourceBundle resourceBundle){

        }

    public static void main(String[] args) {
        new Client();
    }

}
