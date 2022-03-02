package com.example.demo3.controllers;

import com.example.demo3.controllers.GlobalOperation;
import com.example.demo3.database.models.UserFunctionality;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField pass;

    @FXML
    private Hyperlink signUpLink;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signUpLink.setOnAction((e)->{
            GlobalOperation.changeScene(e,"sign_up");
        });
    }
}
