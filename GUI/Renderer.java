package GUI;

import javax.swing.*;

/**
 * The {@code Renderer} class extends {@link JFrame} and serves as the main window for the BattleShip game.
 * It manages the display and rendering of the game's panels.
 */
public class Renderer extends JFrame {

    private JPanel panelPass = new JPanel();

    /**
     * Constructs a new {@code Renderer} object, initializing the window with the title "BattleShip",
     * setting its size, and configuring its properties.
     */
    protected Renderer() {
        setTitle("BattleShip");
        setSize(1280, 720);

        setResizable(false);
        setFocusable(true);
        requestFocusInWindow();
        setLayout(null);

        setBounds(panelPass);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Sets the bounds of the specified panel to the dimensions of the window.
     *
     * @param panel the {@link JPanel} to set bounds for
     */
    private void setBounds(JPanel panel) {
        panel.setBounds(0, 0, 1280, 720);
    }

    /**
     * Draws the specified panel onto the window, replacing any previously displayed panel.
     *
     * @param panelPass_ the {@link JPanel} to be drawn
     */
    public void draw( JPanel panelPass_ ){
        remove(panelPass);
        panelPass = panelPass_;

        setBounds(panelPass);

        add(panelPass);

        revalidate();
        repaint();
    }

}
