package GameManager.Interfaces;

import GameManager.PlayInfo;

/**
 * This interface declares what a GameProgression class must implement.
 */
public interface IGameProgression {
    /**
     * Evaluates the play based on playInfo.
     * @param playInfo The play info of the current turn.
     */
    public void evaluatePlay(PlayInfo playInfo);
}
