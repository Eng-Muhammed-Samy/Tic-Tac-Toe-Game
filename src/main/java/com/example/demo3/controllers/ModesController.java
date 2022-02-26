package com.example.demo3.controllers;

import com.example.demo3.controllers.GlobalOperation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ModesController implements Initializable {

    @FXML
    private Button multiPlayer;

    @FXML
    private Button singlePlayer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        singlePlayer.setOnAction(actionEvent -> {
            try {
                GlobalOperation.changeScene(actionEvent,"minmax");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        multiPlayer.setOnAction(actionEvent -> {
            try {
                GlobalOperation.changeScene(actionEvent,"game_status");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

