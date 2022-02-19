package com.example.demo3.server;

import java.net.Socket;

public class BlurPrintClient {
    private String name;
    private String ipAddress;
    private int port;
    private Socket socket;

    public BlurPrintClient(String name, String ipAddress, int port, Socket socket) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.port = port;
        this.socket = socket;
    }

    public BlurPrintClient(Socket client) {
        this.socket = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean equals(Socket o){
        return this.socket.getLocalAddress().equals(o.getLocalAddress())&& this.getPort() == o.getPort();
    }
}
