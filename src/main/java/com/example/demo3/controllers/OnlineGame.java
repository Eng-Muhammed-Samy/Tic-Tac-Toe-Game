package com.example.demo3.controllers;

import com.example.demo3.controllers.GlobalOperation;
import com.example.demo3.controllers.LoginController;
import com.example.demo3.database.models.BoardFunctionality;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class OnlineGame {
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
    private AnchorPane root;
    boolean isX = true;
    boolean isO = false;
    DataOutputStream ps;
    DataInputStream dis;
    Socket mySocket;
    Thread th;
    String str;
    String db[] = {"","","","","","","","",""};
    public OnlineGame() {
        try {
            mySocket = new Socket("192.168.1.5", 7777);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new DataOutputStream(mySocket.getOutputStream());
        } catch (Exception ex) {
           ex.getMessage();
        }
    }
    @FXML
    protected void play(ActionEvent event){
        final boolean[] flag = {false};

        th = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        if(flag[0])
                            str = dis.readUTF();
//                           str = "";
                        flag[0] = true;
                        System.out.println("here " + str);
                        switch (str) {
                            case "1":
                                if (isX) {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button0.setText("X");
                                        }
                                    });
                                    isX = false;
                                    isO = true;
                                } else {

                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button0.setText("O");
                                        }
                                    });
                                    isX = true;
                                    isO = false;
                                }
                                button0.setMouseTransparent(true);
                                break;
                            case "2":
                                if (isX) {
                                    Platform.runLater(new Runnable() {

                                        @Override
                                        public void run() {
                                            button1.setText("X");
                                        }
                                    });
                                    isX = false;
                                    isO = true;
                                } else {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button1.setText("O");
                                        }
                                    });
                                    isX = true;
                                    isO = false;
                                }
                                button1.setMouseTransparent(true);
                                break;
                            case "3":
                                if (isX) {
                                    Platform.runLater(new Runnable() {

                                        @Override
                                        public void run() {
                                            button2.setText("X");
                                        }
                                    });
                                    isX = false;
                                    isO = true;
                                } else {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button2.setText("O");
                                        }
                                    });
                                    isX = true;
                                    isO = false;
                                }
                                button2.setMouseTransparent(true);
                                break;
                            case "4":
                                if (isX) {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button3.setText("X");
                                        }
                                    });
                                    isX = false;
                                    isO = true;
                                } else {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button3.setText("O");
                                        }
                                    });
                                    isX = true;
                                    isO = false;
                                }
                                button3.setMouseTransparent(true);
                                break;
                            case "5":
                                if (isX) {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button4.setText("X");
                                        }
                                    });
                                    isX = false;
                                    isO = true;
                                } else {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button4.setText("O");
                                        }
                                    });
                                    isX = true;
                                    isO = false;
                                }
                                button4.setMouseTransparent(true);
                                break;
                            case "6":
                                if (isX) {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button5.setText("X");
                                        }
                                    });
                                    isX = false;
                                    isO = true;
                                } else {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button5.setText("O");
                                        }
                                    });
                                    isX = true;
                                    isO = false;
                                }
                                button5.setMouseTransparent(true);
                                break;
                            case "7":
                                if (isX) {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button6.setText("X");
                                        }
                                    });
                                    isX = false;
                                    isO = true;
                                } else {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button6.setText("O");
                                        }
                                    });
                                    isX = true;
                                    isO = false;
                                }
                                button6.setMouseTransparent(true);
                                break;
                            case "8":
                                if (isX) {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button7.setText("X");
                                        }
                                    });
                                    isX = false;
                                    isO = true;
                                } else {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button7.setText("O");
                                        }
                                    });
                                    isX = true;
                                    isO = false;
                                }
                                button7.setMouseTransparent(true);
                                break;
                            case "9":
                                if (isX) {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button8.setText("X");
                                        }
                                    });
                                    isX = false;
                                    isO = true;
                                } else {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            button8.setText("O");
                                        }
                                    });
                                    isX = true;
                                    isO = false;
                                }
                                button8.setMouseTransparent(true);
                                break;
                            case "W":
                                System.out.println("YOU ARE WINNER !!");
//                                ActionEvent event = new ActionEvent();
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                     GlobalOperation.changeSceneWithoutEvent(root, "win");
                                    }});
                                BoardFunctionality bo = new BoardFunctionality();
                                bo.insertIntoBoard(db, new LoginController().loginName);
                                break;
                            case "L":
                                System.out.println("YOU ARE LOSER !!");
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                GlobalOperation.changeSceneWithoutEvent(root, "lose");
                                    }
                                });
                                BoardFunctionality bo2 = new BoardFunctionality();
                                bo2.insertIntoBoard(db, new LoginController().loginName);
                                break;

                            default:
                                break;
                        }

                        System.out.println(str);
                    } catch (Exception ex) {
                        ex.getMessage();
                    }

                }

            }

        }
        );
        th.start();

    }
    @FXML
    public void print(){
        try {
            ps.writeUTF(String.valueOf(1));
        }catch (IOException e){e.getMessage();}
    }
    @FXML
    public void print1(){
        try {
            ps.writeUTF(String.valueOf(2));
        }catch (IOException e){e.getMessage();}
    }

    @FXML
    public void print2(){
        try {
            ps.writeUTF(String.valueOf(3));
        }catch (IOException e){e.getMessage();}
    }

    @FXML
    public void print3(){
        try {
            ps.writeUTF(String.valueOf(4));
        }catch (IOException e){e.getMessage();}
    }

    @FXML
    public void print4(){
        try {
            ps.writeUTF(String.valueOf(5));
        }catch (IOException e){e.getMessage();}
    }
    @FXML
    public void print5(){
        try {
            ps.writeUTF(String.valueOf(6));
        }catch (IOException e){e.getMessage();}
    }
    @FXML
    public void print6(){
        try {
            ps.writeUTF(String.valueOf(7));
        }catch (IOException e){e.getMessage();}
    }
    @FXML
    public void print7(){
        try {
            ps.writeUTF(String.valueOf(8));
        }catch (IOException e){e.getMessage();}
    }
    @FXML
    public void print8(){
        try {
            ps.writeUTF(String.valueOf(9));
        }catch (IOException e){e.getMessage();}
    }
//    @FXML
    public void sendInvitation(){
//        try {
//            ps.writeUTF("inv:player1:player2");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}