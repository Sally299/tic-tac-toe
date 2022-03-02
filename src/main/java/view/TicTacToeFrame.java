package view;

import javax.swing.*;

public class TicTacToeFrame extends JFrame {

    TicTacToePanel ticTacToePanel = new TicTacToePanel();

    public TicTacToeFrame() {
        super("Tic-Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        add(ticTacToePanel);
        setVisible(true);
    }

}
