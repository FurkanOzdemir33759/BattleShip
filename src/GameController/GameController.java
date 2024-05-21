package GameController;

import GUI.GameBoard;
import GUI.MainMenu;
import GUI.Notification;
import GameManager.*;
import GUI.View;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionAdapter;
import GUI.Board;
import GameManager.Enums.*;

import javax.swing.*;
/**
 * The controller class of the game.
 */
public class GameController {
    /**
     * The manager of the game.
     */
    private GameManager manager;


    private boolean itsPlayersTurn;

    private Ship currentSelectedShip;
    /**
     * The view of the game.
     */
    private View view;

    /**
     * Constructor for the GameController
     * @param manager The game manager (model).
     * @param view The game view.
     */
    public GameController(GameManager manager, View view) {
        this.manager = manager;
        this.view = view;
        this.itsPlayersTurn = true;


        view.getMainMenu().getStartButton().addActionListener(e->{

            view.displayGameBoard();

        });

        view.getMainMenu().getExitButton().addActionListener(e -> {
            System.exit(0);

        });
    }

    /**
     * Gets the active game manager from outside and sets the game manager accordingly.
     * @param manager The active game manager.
     */
    public void getGameManager(GameManager manager) {
        this.manager = manager;
    }

    /**
     * Gets the active view from outside and sets the view accordingly.
     * @param view The active view.
     */
    public void getView(View view) {
        this.view = view;
    }

    /**
     * Updates the manager.
     */
    public void updateManager() {
        //TO DO
    }
    /*
    Game starts by showing the main menu and sets the game board.
     */
    public void startGame(){

       setupGameBoard();
       showNotification("Welcome to Battleship!");
    }
    /*
    Game board set to be played.
     */
    private void setupGameBoard(){


    }
    /*
    Notification method
     */
    private void showNotification(String message){

    }

    /**
     * Updates the view.
     */
    public void updateView() {
        //TO DO

    }

    private class PlayerBoardMouseListener extends MouseAdapter {
        public  void mousePressed(MouseEvent e){
            Board playerBoard = view.getGameBoard().getPlayerBoard();
            Point tilePos =  playerBoard.viewToWorldPoint(e.getPoint());
            int x = tilePos.x;
            int y = tilePos.y;
            Tile tileData = manager.getPlayerGrid().get(x).get(y);
            currentSelectedShip =  manager.getPlayerShips().get(tileData);


        }

    }

    private class PlayerBoardDragListener extends MouseMotionAdapter {

        public  void mouseDragged(MouseEvent e){
            Board playerBoard = view.getGameBoard().getPlayerBoard();
            Point tilePos =  playerBoard.viewToWorldPoint(e.getPoint());
            if(currentSelectedShip != null){
                boolean canPlace =  manager.canPlace( manager.getPlayerGrid(),currentSelectedShip, tilePos.x,tilePos.y, currentSelectedShip.orientation );

                if(canPlace){
                    manager.removeShip(manager.getPlayerGrid(), currentSelectedShip);
                    manager.placeShip( manager.getPlayerGrid(),currentSelectedShip, tilePos.x,tilePos.y, currentSelectedShip.orientation );
                    playerBoard.updateGrid(manager.getPlayerGrid());
                }

            }

        }
    }

    private  class PLayerBoardKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            Board playerBoard = view.getGameBoard().getPlayerBoard();

            if(e.getKeyCode() == KeyEvent.VK_R){

                if(currentSelectedShip != null){

                    Orientation ori =  currentSelectedShip.orientation;
                    switch (currentSelectedShip.orientation){
                        case VERTICAL -> ori = Orientation.HORIZONTAL;
                        case HORIZONTAL -> ori = Orientation.VERTICAL;
                    }

                    boolean canRotate =  manager.canPlace( manager.getPlayerGrid(),currentSelectedShip, currentSelectedShip.worldPosX , currentSelectedShip.worldPosY, ori);

                    if(canRotate){


                        manager.removeShip(manager.getPlayerGrid(), currentSelectedShip);
                        currentSelectedShip.orientation = ori;
                        manager.placeShip( manager.getPlayerGrid(),currentSelectedShip,currentSelectedShip.worldPosX,
                                currentSelectedShip.worldPosY, currentSelectedShip.orientation);
                        playerBoard.updateGrid(manager.getPlayerGrid());
                    }

                }
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
