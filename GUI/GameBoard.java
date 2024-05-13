package GUI;

import GUI.Interfaces.IGameBoard;

import javax.swing.*;
import java.util.List;

/**
 * Concrete class representing the game board.
 */
public class GameBoard extends JPanel implements IGameBoard {
    private List<List<Square>> board;

    @Override
    public void placeShip(int x, int y, String orientation) {
        // Implementation code here
    }

    @Override
    public String receiveAttack(int x, int y) {
        return null;

    }

    GameBoard() {
        add(new JLabel("GAME BOARD!"));
    }
}