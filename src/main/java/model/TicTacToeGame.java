package model;

import javax.swing.*;

public class TicTacToeGame {

    public GameState checkGameState(JButton[][] buttons) {

        if (checkWinner(buttons).equals(Elements.CROSS)) {
            return GameState.X_WON;
        } else if (checkWinner(buttons).equals(Elements.NOUGHT)) {
            return GameState.O_WON;
        } else if (hasEmptyCells(buttons)) {
            return GameState.GAME_CONTINUES;
        } else {
            return GameState.DRAW;
        }

    }

    public boolean hasEmptyCells(JButton[][] buttons) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!buttons[i][j].getText().equals("X") && !buttons[i][j].getText().equals("O")) {
                    return true;
                }
            }
        }

        return false;
    }

    public Elements checkWinner(JButton[][] buttons) {

        if (checkRows(buttons, 264) || checkColumns(buttons, 264) || checkDiagonals(buttons, 264)){
            return Elements.CROSS;
        } else if (checkRows(buttons, 237) || checkColumns(buttons, 237) || checkDiagonals(buttons, 237)) {
            return Elements.NOUGHT;
        } else {
            return Elements.EMPTY;
        }

    }

    public boolean checkRows(JButton[][] buttons, int value) {

        int sum = 0;

        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sum += buttons[i][j].getText().charAt(0);

                    if (sum == value) return true;
                }

                sum = 0;
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }

        return false;
    }

    public boolean checkColumns(JButton[][] buttons, int value) {

        int sum = 0;

        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sum += buttons[j][i].getText().charAt(0);

                    if (sum == value) return true;
                }

                sum = 0;
            }
        } catch(NullPointerException e) {
            System.out.println("NullPointerException");
        }


        return false;
    }

    public boolean checkDiagonals(JButton[][] buttons, int value) {

        int first = 0;
        int second = 0;

        try {
            for (int i = 0; i < 3; i++) {
                first += buttons[i][i].getText().charAt(0);
            }

            for (int i = 0, j = 2; i < 3; i++, j--) {
                second += buttons[2 - j][2 - i].getText().charAt(0);
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }


        return (first == value || second == value);
    }

}
