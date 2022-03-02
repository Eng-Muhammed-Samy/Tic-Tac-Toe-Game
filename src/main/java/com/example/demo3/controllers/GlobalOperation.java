package com.example.demo3.controllers;

import com.example.demo3.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;

public class GlobalOperation {
    public static void changeScene(ActionEvent event, String fxml){
        Scene scene = null;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        try {
            scene = new Scene(fxmlLoader.load(),  573, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }
    public static void changeSceneWithoutEvent(AnchorPane root, String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
        Stage stage = (Stage) root.getScene().getWindow();
        try {
            Scene scene = new Scene(fxmlLoader.load(), 573, 400);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
