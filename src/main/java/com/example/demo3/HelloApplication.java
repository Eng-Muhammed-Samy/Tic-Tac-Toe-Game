package com.example.demo3;

import com.example.demo3.database.models.CreateTables;
import com.example.demo3.database.models.UserFunctionality;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public Stage stage = new Stage();
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {

//       UserFunctionality sc = new UserFunctionality();
//        try {
//            ArrayList arr = sc.selectAllUsers();
//            arr.forEach(e->{
//                System.out.println(e);
//            });
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        launch();
    }
}