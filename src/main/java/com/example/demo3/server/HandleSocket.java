package com.example.demo3.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

public class HandleSocket{
     DataInputStream fromClient;
     DataOutputStream toClient;
    static int i = 0;
    public static Vector<HandleSocket> clients = new Vector<>();
//    public static Map<String, BlurPrintClient> clientsMap = new HashMap<String, BlurPrintClient>();
    public HandleSocket(Socket socket){

        try {
            fromClient = new DataInputStream(socket.getInputStream());
            toClient = new DataOutputStream(socket.getOutputStream());
            clients.add(this);
            if(clients.size()%2 == 0 && clients.size() > 0){
                new Room(clients.get(i), clients.get(++i));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
