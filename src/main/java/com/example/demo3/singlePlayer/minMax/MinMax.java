package com.example.demo3.singlePlayer.minMax;
import javafx.scene.control.Button;

public class MinMax {

        static int minimax(Button board[][], int depth, Boolean isMax) {
            int score = BasicForGame.evaluate(board);
            if (score == 10) {
                return score;
            }
            if (score == -10) {
                return score;
            }
            if (BasicForGame.isMoveLeft(board) == false) {
                return 0;
            }

            if (isMax) {
                int best = -1000;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j].getText().equals("")) {
                            board[i][j].setText(BasicForGame.player);
                            best = Math.max(best, minimax(board, depth + 1, !isMax));
                            board[i][j].setText("");
                        }
                    }
                }
                return best;

            } else {
                int best = 1000;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j].getText().equals("")) {
                            board[i][j].setText(BasicForGame.opponent);
                            best = Math.min(best, minimax(board, depth + 1, !isMax));
                            board[i][j].setText("");
                        }
                    }
                }
                return best;
            }
        }

        public static BasicForGame.Move findNextMove(Button board[][])
        {
            int bestVal = -1000;
            BasicForGame.Move bestMove = new BasicForGame.Move();
            bestMove.row = -1;
            bestMove.col = -1;
            for (int i=0 ; i<3; i++)
            {
                for(int j=0; j<3;j++)
                {
                    if(board[i][j].getText().equals(""))
                    {
                        board[i][j].setText(BasicForGame.player);
                        int moveVal = minimax(board, 0, false);
                        board[i][j].setText("");
                        if(moveVal > bestVal)
                        {
                            bestMove.row = i;
                            bestMove.col = j;
                            bestVal = moveVal;

                        }
                    }
                }
            }
            return bestMove;
        }
    }


