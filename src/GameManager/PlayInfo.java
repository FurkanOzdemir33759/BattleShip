package GameManager;

/**
 * This class holds the play info: playType, x, y, orientation
 */
public class PlayInfo {
    /**
     * The play type.
     */
    private final String playType;

    /**
     * X coordinate of the play.
     */
    private final int x;

    /**
     * Y coordaniate of the play.
     */
    private final int y;

    /**
     * The orientation of the play.
     */
    private final String orientation;

    /**
     * Constructor for the PlayInfo class.
     * @param playType The play type.
     * @param x x position of the play.
     * @param y y position of the play.
     * @param orientation The orientation of the play.
     */
    PlayInfo(String playType, int x, int y, String orientation) {
        this.playType = playType;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    /**
     * Gets the x coordinate.
     * @return The x coordinate as int.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y coordinate.
     * @return The y coordinate as int.
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the play type.
     * @return The play type.
     */
    public String getPlayType() {
        return playType;
    }

    /**
     * Gets the orientation.
     * @return The orientation of the play.
     */
    public String getOrientation() {
        return orientation;
    }
}
