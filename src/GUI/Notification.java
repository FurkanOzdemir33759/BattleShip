package GUI;

import GameManager.Enums.Player;

import GUI.Interfaces.INotification;

import javax.swing.*;
import java.awt.*;

public class Notification extends JPanel implements INotification {
    private JLabel notificationLabel;
    public Notification() {
        setLayout(new BorderLayout());
        notificationLabel = new JLabel("NOTIFICATION", SwingConstants.CENTER);
        add(notificationLabel, BorderLayout.CENTER);
    }

    @Override
    public void displayHitMiss(boolean isHit) {
        if (isHit) {
            notificationLabel.setText("Hit!");
            notificationLabel.setForeground(Color.RED);
        } else {
            notificationLabel.setText("Miss!");
            notificationLabel.setForeground(Color.BLUE);
        }
    }

    @Override
    public void displayGameResults(String result) {
        notificationLabel.setText(result);
        notificationLabel.setForeground(Color.GREEN);
    }
    class PlayerInfo extends JPanel {
        private Player player;
        private JLabel name = new JLabel();
        private JLabel score = new JLabel("0");

        public PlayerInfo(Player player) {
            this.player = player;

            setBackground(GUI_PALETTE.BACKGROUND);
            GUI_Util.setAbsoluteSize(this, new Dimension(400, 50));
            setLayout(null);

            name.setFont(new Font("OCR A Extended", Font.BOLD, 24));
            name.setText(player == Player.PLAYER ? "PLAYER" : "COMPUTER");
            name.setHorizontalAlignment(SwingConstants.CENTER);
            name.setVerticalAlignment(SwingConstants.CENTER);
            name.setForeground(GUI_PALETTE.PLAYER_INFO_TEXT_COLOR);

            score.setFont(new Font("OCR A Extended", Font.BOLD, 36));
            score.setText(score.getText());
            score.setVerticalAlignment(SwingConstants.CENTER);
            score.setHorizontalAlignment(SwingConstants.CENTER);
            score.setForeground(GUI_PALETTE.PLAYER_INFO_TEXT_COLOR);

            if (player == Player.PLAYER) {
                GUI_Util.placeAbsoluteComponent(name, 0, 0, 210, 50);
                GUI_Util.placeAbsoluteComponent(score, 210, 0, 190, 50);
            } else {
                GUI_Util.placeAbsoluteComponent(name, 190, 0, 210, 50);
                GUI_Util.placeAbsoluteComponent(score, 0, 0, 190, 50);
            }

            add(name);
            add(score);
        }
        public  void updateScore( int score){
            this.score.setText(""+score);
            revalidate();
            repaint();

        }
    }


}
