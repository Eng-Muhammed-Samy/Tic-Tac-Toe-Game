package com.example.demo3.singlePlayer.minMax;
//import com.example.demo3.User;
//import com.example.demo3.database.models.UserFunctionality;

import com.example.demo3.singlePlayer.minMax.levels.EasyLevel;
import com.example.demo3.singlePlayer.minMax.levels.HardLevel;
import com.example.demo3.singlePlayer.minMax.levels.MediumLevel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MinMaxController   implements Initializable {
//    UserFunctionality bd = new UserFunctionality();

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

    int moveNum;
    BasicForGame.Move nextMove;
    int flag = 0;
    Random ran;
    Button board[][]=new Button[3][3];
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
        Next_Round.setDisable(false);
    }


    void changeFlag(int num) {
        flag = num;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        board[0][0]=button0;
        board[0][1]=button1;
        board[0][2]=button2;
        board[1][0]=button3;
        board[1][1]=button4;
        board[1][2]=button5;
        board[2][0]=button6;
        board[2][1]=button7;
        board[2][2]=button8;

        ran = new Random();
        moveNum = flag = 0;
        Next_Round.setDisable(true);
        setActionOnBtn(board);

    }
   @FXML
    protected void resetGame(){

       for (Button[] btns : board) {
           for (Button btn : btns) {
               btn.setText("");
           }
       }
       ran = new Random();
       moveNum = flag = 0;
//       Next_Round.setDisable(true);
       setActionOnBtn(board);

    }



    private void setActionOnBtn(Button[][] board) {

        for (Button[] btns : board) {
            for (Button btn : btns) {
                switch ("Hard") {

                    case "Hard":
                        btn.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                            if (flag == 0) {
                                btn.setText("O");
                                btn.setMouseTransparent(true);
                                if (moveNum + 1 < 10) {
                                    changeFlag(1);
                                    nextMove = HardLevel.findNextMove(board);
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
                                                Next_Round.setDisable(false);
                                            }

                                        }
                                    });

                                    t.start();

                                }

                            }
                        });
                        break;
                    case "Easy":
                        btn.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                            if (flag == 0) {
                                btn.setText("O");
                                btn.setMouseTransparent(true);
                                if (moveNum + 1 < 10) {
                                    changeFlag(1);
                                    nextMove = EasyLevel.findNextMove(board);
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
                                                Next_Round.setDisable(false);
                                            }

                                        }
                                    });

                                    t.start();

                                }

                            }
                        });
                        break;
                    case "Medium":
                        btn.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                            if (flag == 0) {
                                btn.setText("O");
                                btn.setMouseTransparent(true);
                                if (moveNum + 1 < 10) {
                                    changeFlag(1);
                                    nextMove = MediumLevel.findNextMove(board);
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
                                                Next_Round.setDisable(false);
                                            }

                                        }
                                    });

                                    t.start();

                                }

                            }
                        });
                        break;
                }
            }

        }
}}
