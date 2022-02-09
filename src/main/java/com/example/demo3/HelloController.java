package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    protected Button welcomeText = new Button();
    @FXML
    protected Label xLabel = new Label();

    @FXML
    protected void labelClick() {
        welcomeText.setText("X");
        xLabel.setText("hi");
        System.out.println("here");
    }
}
