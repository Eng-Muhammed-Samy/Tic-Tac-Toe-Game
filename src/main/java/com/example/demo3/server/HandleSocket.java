package com.example.demo3.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HandleSocket extends Thread{
    private Socket socket;
    private DataInputStream fromClient;
    private DataOutputStream toClient;
    private String name;
    //private static Vector<BlurPrintClient> clients = new Vector<>();
    public static Map<String, BlurPrintClient> clientsMap = new HashMap<String, BlurPrintClient>();
    public HandleSocket(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try {
        fromClient = new DataInputStream(socket.getInputStream());
        this.name = fromClient.readUTF();
        if(HandleSocket.clientsMap.get(name) != null)
            HandleSocket.sendMessage("Server", new BlurPrintClient(socket), "User name already in use");
        }catch (Exception e){e.getMessage();}

        clientsMap.put(this.name, (new BlurPrintClient(name, String.valueOf(socket.getLocalAddress()), socket.getPort(), socket)));
        while (true) {
            String msg;
            try {
                msg = fromClient.readUTF();
                System.out.println(msg);
               String toUserName = msg.substring(0,msg.indexOf(':'));
               String signal = msg.substring(msg.indexOf(':'));
                this.sendMessage(this.name,clientsMap.get(toUserName), msg.substring(msg.indexOf(':')+1));

//                toClient = new DataOutputStream(socket.getOutputStream());
//                toClient.writeUTF("SERVER : " + msg);

//                clients.forEach(client->{
//                    System.out.println("Client port : "+client.getPort());
//                    if(!client.equals(socket)){
//                        this.sendMessage(this.name,client, msg);
//                    }
//                });
            }catch (Exception e){e.getMessage();}
        }
    }

    public static void sendMessage(String from, BlurPrintClient to, String message){
        try {
            new DataOutputStream(to.getSocket().getOutputStream()).writeUTF(from + ": "+ message);
        }catch (Exception ex){
            ex.getMessage();
        }
    }



}
