import model.Elements;
import model.GameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.TicTacToeGame;

import javax.swing.*;

class TicTacToeGameTest {
    private TicTacToeGame game;
    private GameState state;
    private Elements element;
    private JButton[][] buttons;
    private int value;

    @BeforeEach
    void setUp() {
        game = new TicTacToeGame();
        state = GameState.X_WON;
        element = Elements.CROSS;
        buttons = new JButton[3][3];
        value = 264;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
            }
        }

        buttons[0][0].setText("O");
        buttons[0][1].setText("X");
        buttons[0][2].setText("O");
        buttons[1][0].setText("X");
        buttons[1][1].setText("X");
        buttons[1][2].setText("X");
        buttons[2][0].setText("O");
        buttons[2][1].setText("O");
        buttons[2][2].setText("O");
    }

    @Test
    void testCheckGameState() {
        Assertions.assertEquals(state, game.checkGameState(buttons));
    }

    @Test
    void testCheckWinner() {
        Assertions.assertEquals(element, game.checkWinner(buttons));
    }

    @Test
    void testHasEmptyCells() {
        Assertions.assertFalse(game.hasEmptyCells(buttons));
    }

    @Test
    void testCheckRows() {
        Assertions.assertTrue(game.checkRows(buttons, value));
    }

    @Test
    void testCheckColumns() {
        Assertions.assertFalse(game.checkColumns(buttons, 264));
    }

    @Test
    void testCheckDiagonals() {
        Assertions.assertFalse(game.checkDiagonals(buttons, 264));
    }

}
