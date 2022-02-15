package com.example.demo3;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.*;

public class GameController implements Initializable {


    @FXML
    protected Label textLabel;

    @FXML
    private Button button0;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button Next_Round;

    private int playerTurn = 0;
    private int xWins=0;
    private int oWins=0;
    private String score;


    ArrayList<Button> buttons;

    public String checkBoard(){ //Sweeps the whole board for each line
        String line = null;
        for(int i=0;i<8;i++){
            //0,1,2
            //3,4,5
            //6,7,8
            line = switch (i) {
                case 0 -> button0.getText() + button1.getText() + button2.getText();
                case 1 -> button3.getText() + button4.getText() + button5.getText();
                case 2 -> button6.getText() + button7.getText() + button8.getText();
                case 3 -> button0.getText() + button3.getText() + button6.getText();
                case 4 -> button1.getText() + button4.getText() + button7.getText();
                case 5 -> button2.getText() + button5.getText() + button8.getText();
                case 6 -> button0.getText() + button4.getText() + button8.getText();
                case 7 -> button2.getText() + button4.getText() + button6.getText();
                default -> null;
            }; //End of switch case;
            boolean check = checkWinner(line) != null;
            if(check) //if check is true which means there is a winner X or O break out of loop.
                break;
        }
        return checkWinner(line);
    }
    public String checkWinner(String line){//Sends a combinations of line formula to check if it's all X or O
        if(line.equals("XXX")){
            return "X";
        }
        if(line.equals("OOO")){
            return "O";
        }
        else return null;
    }

    public boolean checkGameFinished(){//Checks for all buttons
        boolean isDone=false;
        for (Button button : buttons) {
            if (button.getText().equals("X") || button.getText().equals("O")) {//If it has X or O in it
                isDone = true;
            } else {
                isDone = false;
                break;
            }
        }
        return isDone;
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            if(checkGameFinished()){
                setWinner(checkBoard());
            }else if(checkBoard()!=null){
                setWinner(checkBoard());
                disableButtonsOnCommand();
            }
        });
    }

    public void setWinner(String winner) {
        //No Winner
        if (winner==null) {
            textLabel.setText("Draw");
            waitAndPrint();
            Next_Round.setDisable(false);
        }
        //X winner
        else if (winner.equals("X")) {
            textLabel.setText(winner+" won!");
            xWins++;
            waitAndPrint();
            Next_Round.setDisable(false);
        }
        //O winner
        else if (winner.equals("O")) {
            textLabel.setText(winner+" won!");
            oWins++;
            waitAndPrint();
            Next_Round.setDisable(false);
        }
    }

    public void disableButtonsOnCommand(){
        buttons.stream().filter(button -> !button.getText().equals("X") && !button.getText().equals("O")).forEach(button -> button.setDisable(true));
    }

    public void waitAndPrint(){
        score=xWins+" : "+oWins;
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                textLabel.setText(score);
            }
        });
        new Thread(sleeper).start();
    }

    public void resetGame(){
        buttons.forEach(this::resetButtons);
        Next_Round.setDisable(true);
    }

    public void resetButtons(Button button){//Function to reset the game board could be used for "next round"
        button.setDisable(false);
        button.setText("");
    }

    public void setPlayerSymbol(Button button){
        if(playerTurn % 2 == 0){
            button.setText("X");
            playerTurn = 1;
        } else{
            button.setText("O");
            playerTurn = 0;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button0,button1,button2,button3,button4,button5,button6,button7,button8));
        buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
        Next_Round.setDisable(true);
    }
}
