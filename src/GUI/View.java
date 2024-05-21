package GUI;

import GameManager.Enums.*;
import javax.swing.*;

/**
 * The View class represents the graphical user interface (GUI) for the BattleShip game.
 * It is responsible for rendering various screens such as the main menu, game board, and result screen.
 */
public class View {
    private Renderer renderer = null;
    private Notification notification = new Notification();
    private MainMenu mainMenu = new MainMenu();
    private GameBoard gameBoard = new GameBoard();

    /**
     * Constructs a View instance and initializes the renderer.
     * The main menu screen is drawn upon initialization.
     */
    public View() {
        renderer = new Renderer();
        renderer.draw(mainMenu);
    }

    /**
     * Displays the game board screen.
     */
    public void displayGameBoard() {
        renderer.draw(gameBoard);
    }

    /**
     * Sets the game board with the provided player and AI boards.
     *
     * @param playerBoard The board for the player.
     * @param aiBoard     The board for the AI.
     */
    public void setGameBoard(Board playerBoard, Board aiBoard) {
        gameBoard = new GameBoard(playerBoard,aiBoard);
    }

    /**
     * Displays the main menu screen.
     */
    public void displayMainMenu() {
        renderer.draw(mainMenu);
    }

    /**
     * Displays the result screen showing the winner and the scores of both the player and the AI.
     *
     * @param winner      The player who won the game.
     * @param playerScore The score of the player.
     * @param aiScore     The score of the AI.
     */
    public void displayResultScreen(Player winner , int playerScore, int aiScore){
        renderer.draw(notification.new Result(winner,playerScore,aiScore));
    }

    /**
     * Gets the main menu instance.
     *
     * @return The main menu instance.
     */
    public MainMenu getMainMenu() {
        return mainMenu;
    }

    /**
     * Gets the game board instance.
     *
     * @return The game board instance.
     */
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * Gets the renderer instance.
     *
     * @return The renderer instance.
     */
    public  Renderer getRenderer() { return renderer;}
}
