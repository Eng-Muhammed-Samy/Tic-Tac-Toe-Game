package com.example.demo3.singlePlayer.minMax;
import javafx.scene.control.Button;
public class BasicForGame {

    public static class Move {

        public int row, col;
    }

    public static String player = "X", opponent = "O";

    public static Boolean isMoveLeft(Button board[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().equals("")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int evaluate(Button b[][]) {
        for (int row = 0; row < 3; row++) {
            if (b[row][0].getText().equals(b[row][1].getText()) && b[row][1].getText().equals(b[row][2].getText())) {
                switch (b[row][0].getText()) {
                    case "X":
                        return 10;
                    case "O":
                        return -10;
                }
            }
        }

        for (int col = 0; col < 3; col++) {
            if (b[0][col].getText().equals(b[1][col].getText()) && b[1][col].getText().equals(b[2][col].getText())) {
                switch (b[0][col].getText()) {
                    case "X":
                        return 10;
                    case "O":
                        return -10;
                }
            }
        }

        if (b[0][0].getText().equals(b[1][1].getText()) && b[1][1].getText().equals(b[2][2].getText())) {
            switch (b[0][0].getText()) {
                case "X":
                    return 10;
                case "O":
                    return -10;
            }
        }

        if (b[0][2].getText().equals(b[1][1].getText()) && b[1][1].getText().equals(b[2][0].getText())) {
            switch (b[0][2].getText()) {
                case "X":
                    return 10;
                case "O":
                    return -10;
            }
        }
        return 0;
    }

}
