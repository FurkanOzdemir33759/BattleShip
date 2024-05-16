package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a square on the game board.
 */
public class Square extends JPanel {
    public int x;
    public int y;
    public boolean isOccupied;
    public boolean isHit;
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        this.isOccupied = false;
        this.isHit = false;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.BLUE);
    }

    public void setShip(boolean isOccupied) {
        this.isOccupied = isOccupied;
        setBackground(isOccupied ? Color.GRAY : Color.BLUE);
    }

    public boolean hasShip() {
        return isOccupied;
    }

    public void setHit(boolean isHit) {
        this.isHit = isHit;
        setBackground(isHit ? Color.RED : (isOccupied ? Color.GRAY : Color.BLUE));
    }
    public boolean isHit() {
        return isHit;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isHit) {
            g.setColor(Color.RED);
            g.fillRect(0, 0, getWidth(), getHeight());
        } else if (isOccupied) {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
