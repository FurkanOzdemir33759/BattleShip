package GUI;

import javax.swing.*;

public class Renderer extends JFrame {

    private JPanel panelPass = new JPanel();

    private void setBounds(JPanel panel) {
        panel.setBounds(0, 0, 1280, 720);
    }

    protected Renderer () {
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

    public void draw( JPanel panelPass_ ){
        remove(panelPass);
        panelPass = panelPass_;

        setBounds(panelPass);

        add(panelPass);

        revalidate();
        repaint();
    }

}
