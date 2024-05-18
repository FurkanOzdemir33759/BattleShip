package GUI.NEW;

import GUI.Enums.PALETTE;
import GameManager.Enums.Player;

import javax.swing.*;
import java.awt.*;

public class GameBoardView extends JPanel {
    private BoardView boardP1 = new BoardView(Player.P1);
    private BoardView boardP2 = new BoardView(Player.P2);
    private PlayerInfoView infoP1 = new PlayerInfoView(Player.P1);
    private PlayerInfoView infoP2 = new PlayerInfoView(Player.P2, true);
    private JPanel infoGame = new JPanel();

    public GameBoardView() {

        setBackground(PALETTE.BACKGROUND);
        setAbsoluteSize(this, new Dimension(1280, 720));
        setLayout(null); // Absolute layout;


        placeAbsoluteComponent(boardP1, 40, 110, 560, 560);
        placeAbsoluteComponent(boardP2, 660, 110, 560, 560);
        placeAbsoluteComponent(infoP1, 10, 10, 400, 90);
        placeAbsoluteComponent(infoP2, 850, 10, 400, 90);
        placeAbsoluteComponent(infoGame, 420, 10, 420, 90);


        add(boardP1);
        add(boardP2);
        add(infoP1);
        add(infoP2);
        add(infoGame);

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

    public BoardView getBoardP1() {
        return boardP1;
    }

    public BoardView getBoardP2() {
        return boardP2;
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(1280, 720);
        GameBoardView gameBoardView = new GameBoardView();
        gameBoardView.getBoardP1().addActionListenerToTiles(e -> {
            JButton tileButton = (JButton) e.getSource();
            TileView tile = (TileView) tileButton.getParent();
            System.out.println(tile);
        });
        window.add(gameBoardView);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
