package GameController.Interfaces;

/**
 * This interface declares what an actor class must implement.
 */
public interface IActor {
    /**
     * The play method. Allows the actor to play.
     */
    public void play();

    /**
     * The actor should have the means to update the GameState.
     */
    public void update();

    /**
     * The actor should be able to tell whether it is alive or not.
     * @return Whether the actor is alive or dead.
     */
    public boolean isAlive();
}
