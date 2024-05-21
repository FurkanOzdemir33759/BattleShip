import GameManager.GameManager;
import GUI.View;
import GameController.GameController;

public class Main {
    public static void main(String[] args) {
        GameManager manager = new GameManager();
        View view = new View();
        GameController controller = new GameController(manager, view);
    }

}
