package GUI.Interfaces;

/**
 * Represents the game board where the game is played.
 */
public interface IGameBoard {
    /**
     * Places a ship on the game board.
     *
     * @param x the x-coordinate of the ship
     * @param y the y-coordinate of the ship
     * @param orientation the orientation of the ship (e.g., "horizontal" or "vertical")
     */
    void placeShip(int x, int y, String orientation);

    /**
     * Attacks a specific location on the game board.
     *
     * @param x the x-coordinate of the attack
     * @param y the y-coordinate of the attack
     */
    String receiveAttack(int x, int y);
}