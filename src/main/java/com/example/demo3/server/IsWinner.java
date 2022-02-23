package com.example.demo3.server;

public class IsWinner {
    public String checkWinner(String[] s) {
        if ((s[0].equals(s[1])) && (s[1].equals(s[2])) && (s[0].equals("x"))) {
            return "x";
        } else if ((s[3].equals(s[4])) && (s[4].equals(s[5])) && (s[3].equals("x"))) {
            return "x";
        } else if ((s[6].equals(s[7])) && (s[7].equals(s[8])) && (s[6].equals("x"))) {
            return "x";
        } else if ((s[0].equals(s[4])) && (s[4].equals(s[8])) && (s[0].equals("x"))) {
            return "x";
        } else if ((s[6].equals(s[4])) && (s[4].equals(s[2])) && (s[6].equals("x"))) {
            return "x";
        } else if ((s[0].equals(s[3])) && (s[3].equals(s[6])) && (s[6].equals("x"))) {
            return "x";
        } else if ((s[1].equals(s[4])) && (s[4].equals(s[7])) && (s[7].equals("x"))) {
            return "x";
        } else if ((s[2].equals(s[5])) && (s[5].equals(s[8])) && (s[5].equals("x"))) {
            return "x";
        }

        if ((s[0].equals(s[1])) && (s[1].equals(s[2])) && (s[0].equals("o"))) {
            return "o";
        } else if ((s[3].equals(s[4])) && (s[4].equals(s[5])) && (s[3].equals("o"))) {
            return "o";
        } else if ((s[6].equals(s[7])) && (s[7].equals(s[8])) && (s[6].equals("o"))) {
            return "o";
        } else if ((s[0].equals(s[4])) && (s[4].equals(s[8])) && (s[0].equals("o"))) {
            return "o";
        } else if ((s[6].equals(s[4])) && (s[4].equals(s[2])) && (s[6].equals("o"))) {
            return "o";
        } else if ((s[0].equals(s[3])) && (s[3].equals(s[6])) && (s[6].equals("o"))) {
            return "o";
        } else if ((s[1].equals(s[4])) && (s[4].equals(s[7])) && (s[7].equals("o"))) {
            return "o";
        } else if ((s[2].equals(s[5])) && (s[5].equals(s[8])) && (s[5].equals("o"))) {
            return "o";
        } else {
            return "none";
        }
    }
}
