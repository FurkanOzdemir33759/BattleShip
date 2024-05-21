package GUI;

import GameManager.Enums.Player;

import GUI.Interfaces.INotification;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
    public class GameInfo extends JPanel {
        private JLabel phaseText = new JLabel();
        private JButton returnButton , skipPlacementPhaseButton;

        public GameInfo() {
            setBackground(GUI_PALETTE.BACKGROUND);
            GUI_Util.setAbsoluteSize(this, new Dimension(420, 50));
            setLayout(null);

            returnButton = new JButton("QUIT");
            GUI_Util.placeAbsoluteComponent(returnButton, 0, 0, 100, 50);
            returnButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
            returnButton.setFocusPainted(false);
            returnButton.setFocusable(false);
            returnButton.setBackground(GUI_PALETTE.BACKGROUND);
            returnButton.setForeground(GUI_PALETTE.PLAYER_INFO_TEXT_COLOR);
            returnButton.setBorder(new CompoundBorder(new LineBorder(GUI_PALETTE.GRID_BORDER), new EmptyBorder(2, 5, 2, 5)));


            skipPlacementPhaseButton = new JButton("START");
            GUI_Util.placeAbsoluteComponent(skipPlacementPhaseButton, 320, 0, 100, 50);
            skipPlacementPhaseButton.setFocusPainted(false);
            skipPlacementPhaseButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
            skipPlacementPhaseButton.setBackground(GUI_PALETTE.BACKGROUND);
            skipPlacementPhaseButton.setForeground(GUI_PALETTE.PLAYER_INFO_TEXT_COLOR);
            skipPlacementPhaseButton.setBorder(new CompoundBorder(new LineBorder(GUI_PALETTE.GRID_BORDER), new EmptyBorder(2, 5, 2, 5)));


            GUI_Util.placeAbsoluteComponent(phaseText, 100, 0, 220, 50);
            phaseText.setForeground(GUI_PALETTE.PLAYER_INFO_TEXT_COLOR);
            phaseText.setBackground(GUI_PALETTE.BACKGROUND);
            phaseText.setText("SET YOUR BOARD!");
            phaseText.setHorizontalAlignment(SwingConstants.CENTER);
            phaseText.setVerticalAlignment(SwingConstants.CENTER);
            phaseText.setFont(new Font("SansSerif", Font.PLAIN, 18));


            add(returnButton);
            add(skipPlacementPhaseButton);
            add(phaseText);
        }

        public JButton getReturnButton() {
            return returnButton;
        }

        public JButton getSkipPlacementPhaseButton() {
            return skipPlacementPhaseButton;
        }

        public JLabel getPhaseText() {
            return phaseText;
        }
    }
    public class Result extends JPanel {

        public  Result(Player winner, int playerScore , int aiScore ){
            setBackground(GUI_PALETTE.BACKGROUND);
            setLayout(null);

            JLabel playerScoreLabel = new JLabel("Player Score : " + playerScore);
            GUI_Util.placeAbsoluteComponent(playerScoreLabel, 100, 100, 540, 200);
            playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
            playerScoreLabel.setVerticalAlignment(SwingConstants.CENTER);
            playerScoreLabel.setFont(new Font("Monospaced", Font.ITALIC, 50));
            playerScoreLabel.setForeground(GUI_PALETTE.PLAYER_INFO_TEXT_COLOR);


            JLabel aiScoreLabel = new JLabel("AI Score : " + aiScore);
            GUI_Util.placeAbsoluteComponent(aiScoreLabel, 640, 100, 540, 200);
            aiScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
            aiScoreLabel.setVerticalAlignment(SwingConstants.CENTER);
            aiScoreLabel.setFont(new Font("Monospaced", Font.ITALIC, 50));
            aiScoreLabel.setForeground(GUI_PALETTE.PLAYER_INFO_TEXT_COLOR);

            String winner_text = "";
            switch (winner){

                case AI ->winner_text = "AI WINS!";
                case PLAYER -> winner_text = "PlAYER WINS!";
            }

            JLabel winnerLabel = new JLabel(winner_text);
            GUI_Util.placeAbsoluteComponent(winnerLabel, 440, 250, 400, 200);
            winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
            winnerLabel.setVerticalAlignment(SwingConstants.CENTER);
            winnerLabel.setFont(new Font("Monospaced", Font.ITALIC, 50));
            winnerLabel.setForeground(GUI_PALETTE.PLAYER_INFO_TEXT_COLOR);

            add(winnerLabel);
            add(playerScoreLabel);
            add(aiScoreLabel);


        }


    }





}
