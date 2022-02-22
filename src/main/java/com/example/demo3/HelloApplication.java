package com.example.demo3;

import com.example.demo3.database.models.ScoreFunctionality;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("minmax.fxml"));

        Scene scene = new Scene(fxmlLoader.load(),  573, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {

       ScoreFunctionality sc = new ScoreFunctionality();

        try {
            sc.insertUserScore( "Yasmine", "ayman",15);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        launch();
    }
}