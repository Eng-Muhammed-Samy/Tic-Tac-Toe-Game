package com.example.demo3;

import java.net.Socket;

public class User {
    private int id;
    private String name;
    private String password;
    private int status;
    private Socket socket;
    public User() {
    }

    public User(Socket socket) {
        this.socket = socket;
    }

    public User(String name, String password, int status) {
        this.name = name;
        this.password = password;
        this.status = status;
    }

    public User(int id, String name, String password, int status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.status = status;
    }

    public User(int id, String name, String password, int status, Socket socket) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.status = status;
        this.socket = socket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean equals(Socket other){
        return this.socket.getLocalAddress().equals(other.getLocalAddress()) && this.socket.getPort() == other.getPort();
    }
}
