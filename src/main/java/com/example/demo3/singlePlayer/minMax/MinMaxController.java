package com.example.demo3.singlePlayer.minMax;
import com.example.demo3.User;
import com.example.demo3.database.models.UserFunctionality;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MinMaxController   implements Initializable {
    UserFunctionality bd = new UserFunctionality();

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
    protected void resetGame(){
        try {
            bd.insertUser(new User("ayman","ayman@gamil.com", "123456",1));
//            bd.selectAllUsers();
//            bd.selectUserByEmail("ahmed@gamil.com");
//            bd.selectUserByStatus(0);
//            bd.updateStatusByEmail(1,"ahmed@gamil.com");
//            bd.selectUserByEmail("ahmed@gamil.com");
        }catch(Exception ex){

            ex.getMessage();
        }

    }

    int moveNum;
    BasicForGame.Move nextMove;
    int flag = 0;
    Random ran;

    void scoreScreen(Button[][] board) {

        int result = BasicForGame.evaluate(board);
        if (result == 10) {
            System.out.println("You lost :(");
            textLabel.setText("you  lost!");

        } else if (result == -10) {
            textLabel.setText("you  won!");

        } else if (BasicForGame.isMoveLeft(board) == false) {
            System.out.println("No One!");
            textLabel.setText("Draw");

        }
    }

    void changeFlag(int num) {
        flag = num;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button board[][] = {{button0, button1, button2}, {button3, button4, button5}, {button6, button7, button8}};
        ran = new Random();
        moveNum = flag = 0;
        setActionOnBtn(board);
    }

    private void setActionOnBtn(Button[][] board) {
        for (Button[] btns : board) {
            for (Button btn : btns) {

                btn.setOnMouseClicked(mouseEvent -> {
                    if (flag == 0) {
                        btn.setText("O");
                        btn.setMouseTransparent(true);
                        if (moveNum + 1 < 10) {
                            changeFlag(1);
                            nextMove = MinMax.findNextMove(board);
                            Thread t = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {

                                    }
                                    Platform.runLater(() -> {
                                        if (moveNum < 9) {
                                            board[nextMove.row][nextMove.col].setText("X");
                                            board[nextMove.row][nextMove.col].setMouseTransparent(true);
                                        }
                                        changeFlag(0);
                                    });
                                    moveNum += 2;
                                    if (moveNum >= 5) {

                                        Platform.runLater(() -> {
                                            scoreScreen(board);
                                        });
                                    }

                                }
                            });

                            t.start();

                        }

                    }
                });
            }


        }

    }
}
