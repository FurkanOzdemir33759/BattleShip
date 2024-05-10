package GameController;

import GameController.Interfaces.IActor;

public class Actor implements IActor {
    /**
     * The score of the actor.
     */
    private int score;

    /**
     * Is the actor alive or not.
     */
    private boolean isAlive;

    /**
     * Actor constructor.
     */
    public Actor() {
        score = 0;
        isAlive = true;
    }

    /**
     * Allows the actor to play.
     */
    public void play() {
        //TO DO
    }

    /**
     * Gets whether the actor is alive or not.
     * @return Whether the actor is alive or not.
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Updates the GameState according to the play.
     */
    public void update() {
        //TO DO
    }
}
