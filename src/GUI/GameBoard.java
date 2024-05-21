package GUI;


import GameManager.Enums.*;

import javax.swing.*;

import java.util.ArrayList;

public class GameBoard extends JPanel {
    private Notification notification = new Notification();

    private Board playerBoard ;
    private Board aiBoard;
    private Notification.PlayerInfo playerInfo = notification.new PlayerInfo(Player.PLAYER);
    private Notification.PlayerInfo aiInfo = notification.new PlayerInfo(Player.AI);
    private Notification.GameInfo gameInfo = notification.new GameInfo();

    public GameBoard(Board playerBoard, Board  aiBoard) {

        this.playerBoard = playerBoard;
        this.aiBoard = aiBoard;

        setBackground(GUI_PALETTE.BACKGROUND);
        GUI_Util.setAbsoluteSize(this, GUI_Util.HD);
        setLayout(null);

        GUI_Util.placeAbsoluteComponent(playerBoard, 40, 100, 560, 560);
        GUI_Util.placeAbsoluteComponent(aiBoard, 660, 100, 560, 560);
        GUI_Util.placeAbsoluteComponent(playerInfo, 10, 10, 400, 50);
        GUI_Util.placeAbsoluteComponent(aiInfo, 850, 10, 400, 50);
        GUI_Util.placeAbsoluteComponent(gameInfo, 420, 10, 420, 50);


        add(playerBoard);
        add(aiBoard);
        add(playerInfo);
        add(aiInfo);
        add(gameInfo);
    }

    public GameBoard() {
        this(new Board(Player.PLAYER, new ArrayList<>()), new Board(Player.AI, new ArrayList<>()));
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }
    public Notification.GameInfo getGameInfo() {return gameInfo;}

    public  void  updatePlayerInfo(int score){  playerInfo.updateScore(score);}
    public  void  updateAiInfo(int score){  aiInfo.updateScore(score);}
    public Board getAiBoard() {return aiBoard;}
}
