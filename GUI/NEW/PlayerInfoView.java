package GUI.NEW;

import GUI.Enums.PALETTE;
import GameManager.Enums.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerInfoView extends JPanel {
    private boolean isMirrored = false;
    private Player player;
    private ArrayList<ShipView> ships;
    private int score = 0;
    private JLabel playerLabel = new JLabel();
    private JLabel scoreLabel = new JLabel();
    private FleetView fleetView;

    public PlayerInfoView(Player player) {
        this.player = player;

        setBackground(PALETTE.BACKGROUND);
        setAbsoluteSize(this, new Dimension(400, 90));
        setLayout(null);


        playerLabel.setFont(new Font("OCR A Extended", 2, 24));
        playerLabel.setText(player == Player.P1 ? "Player 1" : "Player 2");
        playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerLabel.setVerticalAlignment(SwingConstants.CENTER);
        placeAbsoluteComponent(playerLabel, 0, 0, 210, 30);


        scoreLabel.setFont(new Font("OCR A Extended", 1, 36));
        scoreLabel.setText(Integer.toString(score));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setVerticalAlignment(SwingConstants.CENTER);
        placeAbsoluteComponent(scoreLabel, 220, 0, 180, 30);


        add(playerLabel);
        add(scoreLabel);

    }

    public PlayerInfoView(Player player, boolean isMirrored) {

        this(player);


        placeAbsoluteComponent(scoreLabel, 0, 0, 180, 30);
        placeAbsoluteComponent(playerLabel, 190, 0, 210, 30);
    }

    private void setAbsoluteSize(JComponent component, Dimension size) {
        component.setPreferredSize(size);
        component.setMaximumSize(size);
        component.setMinimumSize(size);
    }

    private void placeAbsoluteComponent(JComponent component, int x, int y, int w, int h) {
        component.setBounds(x, y, w, h);
        setAbsoluteSize(component, new Dimension(w, h));
    }

}
