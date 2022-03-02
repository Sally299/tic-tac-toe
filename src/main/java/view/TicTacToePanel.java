package view;

import model.Elements;
import model.GameState;
import model.TicTacToeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToePanel extends JPanel {

    JButton[][] buttons = new JButton[3][3];
    Elements mark = Elements.CROSS;
    TicTacToeGame ticTacToeGame = new TicTacToeGame();
    GameState gameState = GameState.GAME_CONTINUES;

    public TicTacToePanel() {
        setLayout(new GridLayout(3, 3));
        initializeButtons();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void initializeButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setText(" ");
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                        clickButton(mark, button);
                    }
                });

                add(buttons[i][j]);
            }
        }

    }

    public void clickButton(Elements mark, JButton button) {
        if (mark.equals(Elements.CROSS)) {
            button.setText(mark.toString());
            button.setEnabled(false);
            this.mark = Elements.NOUGHT;
        } else {
            button.setText(mark.toString());
            button.setEnabled(false);
            this.mark = Elements.CROSS;
        }

        gameState = ticTacToeGame.checkGameState(buttons);

        if(!gameState.equals(GameState.GAME_CONTINUES)) {
            displayWinner();
        }

    }

    public void displayWinner() {
        JOptionPane pane = new JOptionPane();
        switch (getGameState()) {
            case X_WON:
                disableButtons();
                JOptionPane.showMessageDialog(pane, "X wins.");
                break;
            case O_WON:
                disableButtons();
                JOptionPane.showMessageDialog(pane, "O wins.");
                break;
            case DRAW:
                JOptionPane.showMessageDialog(pane, "The game ended in a draw.");
                break;
        }
    }

    public void disableButtons() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

}
