package com.example.demo3;

import javafx.scene.control.Button;

public class UserModel {
    String name;
    int score;
    int status;
    Button invitation;



    public UserModel(String name, int score, int status) {
        this.name = name;
        this.score = score;
        this.status = status;
    }
    public UserModel(String name, int score, int status,Button invitation) {
        this.name=name;
         this.score = score;
        this.status = status;
        this.invitation=invitation;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setScore(String name) {
        this.score = score;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setInvitation(String name) {
        this.invitation = invitation;
    }





    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public int getStatus() {
        return status;
    }
    public Button getInvitation() {
        return invitation;
    }

}
