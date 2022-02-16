package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupController {

    @FXML
    private TextField usrNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    public void registerUser(){
        String usrName = usrNameField.getText();
        String password = String.valueOf(passwordField.getText());
        String confirmPassword = String.valueOf(confirmPasswordField.getText());
        if(usrName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Try again");
            alert.setHeaderText("Fields are left empty error");
            alert.setContentText("You need to fill all the fields!");
            alert.show();
            return;
        }
        if(!password.equals(confirmPassword)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Password didn't match");
            alert.setHeaderText("Retype the password fields");
            alert.setContentText("Try again filling the password fields!");
            alert.show();
            return;
        }
        if(!usrName.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()){
            String usrNamePattern = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
            Pattern usrPattern = Pattern.compile((usrNamePattern));
            Matcher usrmatch = usrPattern.matcher(usrName);
            if(!usrmatch.matches()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Username error");
                alert.setHeaderText("Username requirements");
                alert.setContentText("The number of characters must be between 5 to 20, " +
                        "username consists of alphanumeric characters (a-zA-Z0-9), lowercase, or uppercase.");
                alert.show();
                return;
            }else{//Passed all needed checks
//             addUserToDataBase(usrName,password);
                System.out.println("Added to the database!");
            }
        }
    }
//    //should return user
//    private void addUserToDataBase(String usrName, String password) {
//
//    }
//
}
