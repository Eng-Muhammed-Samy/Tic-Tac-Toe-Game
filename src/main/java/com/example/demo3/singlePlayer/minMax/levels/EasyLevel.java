package com.example.demo3.singlePlayer.minMax.levels;

import com.example.demo3.singlePlayer.minMax.BasicForGame;
import javafx.scene.control.Button;
import com.example.demo3.singlePlayer.minMax.BasicForGame.Move;

import java.util.Random;

public class EasyLevel {
    static Random random = new Random();

    public static BasicForGame.Move findNextMove(Button board[][]) {
        BasicForGame.Move bestMove = new Move();
        int randomRow = random.nextInt(3);
        int randomCol = random.nextInt(3);
        while (!board[randomRow][randomCol].getText().equals("")) {
            randomRow = random.nextInt(3);
            randomCol = random.nextInt(3);
        }
        bestMove.row = randomRow;
        bestMove.col = randomCol;
        return bestMove;
    }
}
