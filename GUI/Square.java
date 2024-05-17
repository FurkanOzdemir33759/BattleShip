package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a square on the game board.
 * Each square can have different states:
 * - Blue: Empty square.
 * - Gray: Square occupied by a ship.
 * - Red: Square that has been hit.
 * - White: Square that has been attacked but missed.
 */
public class Square extends JPanel {
    private int x;
    private int y;
    private boolean occupied;
    private boolean hit;
    private boolean miss;

    /**
     * Constructor to initialize the square with default values.
     * By default, the square is empty, not hit, and not missed.
     * @param x The x-coordinate of the square.
     *   @param y The y-coordinate of the square.
     */
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        this.occupied = false;
        this.hit = false;
        this.miss = false;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(60, 60));
    }

    /**
     * Checks if the square is occupied by a ship.
     *
     * @return true if the square is occupied, false otherwise.
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     * Sets the occupation status of the square.
     *
     * @param occupied true if a ship occupies the square, false otherwise.
     */
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
        repaint();
    }

    /**
     * Checks if the square has been hit.
     *
     * @return true if the square has been hit, false otherwise.
     */
    public boolean isHit() {
        return hit;
    }

    /**
     * Sets the hit status of the square.
     *
     * @param hit true if the square has been hit, false otherwise.
     */
    public void setHit(boolean hit) {
        this.hit = hit;
        this.miss = !hit; // If hit, miss must be false.
        repaint();
    }

    /**
     * Checks if the square has been missed.
     *
     * @return true if the square has been missed, false otherwise.
     */
    public boolean isMiss() {
        return miss;
    }

    /**
     * Sets the miss status of the square.
     *
     * @param miss true if the square has been missed, false otherwise.
     */
    public void setMiss(boolean miss) {
        this.miss = miss;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (hit) {
            g.setColor(Color.RED);
            g.fillRect(0, 0, getWidth(), getHeight());
        } else if (miss) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
        } else if (occupied) {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
        } else {
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());
    }
}