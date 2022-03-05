package com.example.demo3.controllers;

import com.example.demo3.User;
import com.example.demo3.controllers.GlobalOperation;
import com.example.demo3.database.models.UserFunctionality;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupController implements Initializable {
    UserFunctionality userFunctionality = new UserFunctionality();

    @FXML
    private TextField usrNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button signupButton;
    @FXML
    private Hyperlink loginLink;


    public void registerUser(ActionEvent event){
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
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
            }else{
                try {
                    UserFunctionality user = new UserFunctionality();
                    String userFounded = user.selectUserByUserName(usrName);
                    if(!userFounded.equals(usrName)) {
                        user.insertUser(new User(usrName, password, 0));
                        GlobalOperation.changeScene(event, "login");
                    }else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Database error");
                        alert.setHeaderText("Username error");
                        alert.setContentText("Username Already exist");
                        alert.show();
                        return;
                    }
                }catch (SQLException e) {
                    e.getMessage();
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signupButton.setOnAction(actionEvent -> {
            try {
                GlobalOperation.changeScene(actionEvent,"main_menu");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        loginLink.setOnAction((e)->{
            GlobalOperation.changeScene(e,"login");
        });
    }


//    //should return user
//    private void addUserToDataBase(String usrName, String password) {
//
//    }
//
}
