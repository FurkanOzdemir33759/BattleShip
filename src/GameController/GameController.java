package GameController;

import GameManager.*;
import GUI.View;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionAdapter;
import GUI.Board;
import GameManager.Enums.*;
import GameManager.Enums.Player;

import javax.swing.*;
/**
 * The controller class of the game.
 */
public class GameController {
    /**
     * The manager of the game.
     */
    private GameManager manager;
    /**
     * AI
     */
    private AI ai = new AI();



    /**
     * Game Progression Handler
     */
    private GameProgression gameProgression = new GameProgression();

    private Ship currentSelectedShip;
    /**
     * The view of the game.
     */
    private View view;

    private  PlayerBoardMouseListener playerBoardMouseListener = new PlayerBoardMouseListener();
    private  PlayerBoardDragListener playerBoardDragListener = new PlayerBoardDragListener();

    private  PLayerBoardKeyListener pLayerBoardKeyListener = new PLayerBoardKeyListener();
    private AiBoardMouseListener aiBoardMouseListener = new AiBoardMouseListener();


    /**
     * Constructor for the GameController
     * @param manager The game manager (model).
     * @param view The game view.
     */
    public GameController(GameManager manager, View view) {
        this.manager = manager;
        this.view = view;


        this.view.getMainMenu().getStartButton().addActionListener(e -> {
            Board playerBoard = new Board(Player.PLAYER, manager.getPlayerGrid());
            Board aiBoard = new Board(Player.AI, manager.getAiGrid());
            aiBoard.addMouseListener(aiBoardMouseListener);

            playerBoard.addMouseListener(playerBoardMouseListener);
            playerBoard.addMouseMotionListener(playerBoardDragListener);
            view.getRenderer().addKeyListener(pLayerBoardKeyListener);

            view.setGameBoard(playerBoard, aiBoard);
            view.displayGameBoard();

            // QUIT in GameBoard
            this.view.getGameBoard().getGameInfo().getReturnButton().addActionListener(e_-> {
                System.exit(0);
            });

            // START in GameBoard
            this.view.getGameBoard().getGameInfo().getSkipPlacementPhaseButton().addActionListener(e_ -> {
                if (gameProgression.getGamePhase() == Phase.SHIP_PLACEMENT) {
                    gameProgression.nextPhase();
                    this.view.getGameBoard().getGameInfo().getSkipPlacementPhaseButton().setVisible(false);
                    this.view.getGameBoard().getGameInfo().getPhaseText().setText("ATTACK!");
                    playerBoard.removeMouseListener(playerBoardMouseListener);
                    playerBoard.removeMouseMotionListener(playerBoardDragListener);
                    view.getRenderer().removeKeyListener(pLayerBoardKeyListener);
                }
            });
        });

        this.view.getMainMenu().getExitButton().addActionListener(e -> {
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

    private class AiBoardMouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (gameProgression.getGamePhase() == Phase.PLAYER_ATTACK) {
                Board playerBoard = view.getGameBoard().getPlayerBoard();
                Board aiBoard = view.getGameBoard().getAiBoard();
                Point tilePos = aiBoard.viewToWorldPoint(e.getPoint());

                int x = tilePos.x;
                int y = tilePos.y;
                Tile tileData = manager.getAiGrid().get(x).get(y);

                switch (tileData) {
                    case EMPTY -> {manager.setAiTileData(Tile.REVEALED_EMPTY, x, y);
                        gameProgression.nextPhase();
                        view.getGameBoard().getGameInfo().getPhaseText().setText("BRACE YOURSELF!");
                        aiBoard.updateGrid(manager.getAiGrid());
                        aiAttack(playerBoard);
                        manager.recordPlayerMiss();
                        view.getGameBoard().updatePlayerInfo(manager.getPlayerScore());


                    }
                    case REVEALED_SHIP -> {}
                    case REVEALED_EMPTY -> {}
                    default -> {manager.setAiTileData(Tile.REVEALED_SHIP, x, y);
                        aiBoard.updateGrid(manager.getAiGrid());
                        manager.reduceAiHealth();
                        view.getGameBoard().updatePlayerInfo(manager.getPlayerScore());
                        if (manager.getAiHealth() == 0) {
                            System.out.println("Player Won");
                            playerVictory();
                        }
                    }
                }
            }
        }
    }

    private void aiAttack(Board playerBoard) {


        Point aiTarget = ai.nextTarget();
        Tile aiTargetData = manager.getPlayerGrid().get(aiTarget.x).get(aiTarget.y);

        Timer timer  = new Timer(800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (aiTargetData) {
                    case EMPTY -> {manager.setPlayerTileData(Tile.REVEALED_EMPTY, aiTarget.x, aiTarget.y);
                        ai.setGridMemory(aiTarget.x, aiTarget.y, MemoryTile.MISS);
                        gameProgression.nextPhase();
                        view.getGameBoard().getGameInfo().getPhaseText().setText("ATTACK!");
                        playerBoard.updateGrid(manager.getPlayerGrid());
                        manager.recordAiMiss();
                        view.getGameBoard().updateAiInfo(manager.getAiScore());
                    }
                    case REVEALED_SHIP -> {}
                    case REVEALED_EMPTY -> {}
                    default -> {

                        manager.setPlayerTileData(Tile.REVEALED_SHIP, aiTarget.x, aiTarget.y);
                        ai.setGridMemory(aiTarget.x, aiTarget.y, MemoryTile.HIT);
                        playerBoard.updateGrid(manager.getPlayerGrid());
                        manager.reducePlayerHealth();
                        view.getGameBoard().updateAiInfo(manager.getAiScore());
                        if (manager.getPlayerHealth() != 0) {
                            aiAttack(playerBoard);
                        } else {
                            System.out.println("AI Won");
                            aiVictory();
                        }
                    }
                }
            };
        });
        timer.setRepeats(false);
        timer.start();

    }

    private void playerVictory() {

        this.view.displayResultScreen(Player.PLAYER, manager.getPlayerScore(), manager.getAiScore());
    }
    private void aiVictory() {
        this.view.displayResultScreen(Player.AI, manager.getPlayerScore(), manager.getAiScore());
    }
}

