package GUI;

import GameManager.Player;

import javax.swing.*;

public class View {
    private Renderer renderer = null;
    private MainMenu mainMenu = new MainMenu();
    private GameBoard gameBoard = new GameBoard();

    public View() {
        renderer = new Renderer();
        renderer.draw(mainMenu);
    }

    public void displayGameBoard() {
        renderer.draw(gameBoard);
    }

    public void setGameBoard(Board playerBoard, Board aiBoard) {
        gameBoard = new GameBoard(playerBoard,aiBoard);
    }

    public void displayMainMenu() {
        renderer.draw(mainMenu);
    }

    public void displayResultScreen(Player winner , int playerScore, int aiScore){
        renderer.draw(new Result(winner,playerScore,aiScore));
    }
    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public  Renderer getRenderer() { return renderer;}
}
