package LegendsCode;

/* This is the main class which will call the specific game class.
 * This class can have instances of different game classes.*/
public final class GameEngine {
    public static void main(String[] args) {
        Legends legends = Legends.getInstance();
        legends.letsPlay();
    }
}
