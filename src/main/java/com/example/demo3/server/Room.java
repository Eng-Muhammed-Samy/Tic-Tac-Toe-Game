package com.example.demo3.server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Azab
 */
class Room {

    HandleSocket player1;
    HandleSocket player2;
    Thread t1, t2;
    boolean youTurn = false;

    int i = 0;
    int k = 0;
    String[] moves = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
    IsWinner isWinner = new IsWinner();
    public Room(HandleSocket player1, HandleSocket player2) {

        this.player1 = player1;
        this.player2 = player2;

        t1 = new Thread("player1") {
            @Override
            public void run() {
                String str;
                while (true) {
                    try {
                        str = player1.fromClient.readUTF();
                        k = Integer.parseInt(str);
                        moves[k - 1] = "x";
                        k++;
                        i++;

                        sendMessageToAll(str);
                    } catch (IOException ex) {
                        Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
                        break;
                    }
                }
            }

        };

        t2 = new Thread("player2") {
            @Override
            public void run() {
                String str;
                while (true) {
                    try {
                        str = player2.fromClient.readUTF();
                        k = Integer.parseInt(str);
                        moves[k - 1] = "o";
                        k++;
                        i++;
                        sendMessageToAll(str);
                    } catch (IOException ex) {
                        Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
                        break;
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }

    void sendMessageToAll(String msg) {
    try {
        if (Thread.currentThread().getName().equals("player1") && !youTurn) {
            player2.toClient.writeUTF(msg);
            player1.toClient.writeUTF(msg);
            youTurn = !youTurn;

            if (isWinner.checkWinner(moves).equals("x")) {
                player2.toClient.writeUTF("L");
                player1.toClient.writeUTF("W");
            }

        } else if (Thread.currentThread().getName().equals("player2") && youTurn) {
            player1.toClient.writeUTF(msg);
            player2.toClient.writeUTF(msg);
            youTurn = !youTurn;
            if (isWinner.checkWinner(moves).equals("o")) {
                player2.toClient.writeUTF("W");
                player1.toClient.writeUTF("L");
                System.out.println("player2 thread");
            }
        } else {
            System.out.println("None Thread");
        }
    }catch (Exception e){
        e.getMessage();
    }
    }
}