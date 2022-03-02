package com.example.demo3.controllers;

import com.example.demo3.controllers.GlobalOperation;
import com.example.demo3.database.models.UserFunctionality;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField pass;

    public static String loginName;

    @FXML
    protected void loginfun(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Database error");
    alert.setHeaderText("user error");
    try {
        if(username.getText().equals("") || pass.getText().equals("")){
            alert.setContentText("you must fill all fields");
            alert.show();
        }else {
            UserFunctionality us = new UserFunctionality();
            String password = us.SelectPasswordForUser(username.getText());
            boolean isUserExist = us.ifUserFound(username.getText());
                if (isUserExist && password.equals(pass.getText())) {
                    this.loginName = username.getText();
                    GlobalOperation.changeScene(event, "onlinegame");
                } else {
                    alert.setContentText("User not Found | username or password not correct");
                    alert.show();
                    return;
            }
        }
    }catch (Exception e) {
        e.printStackTrace();
    }
}
}
