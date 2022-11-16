package LegendsCode;

/* This is the interface which all the game classes implements. 
 * It has the common functionalities of all the games */
public interface Game {
    public abstract int displayWelcomeScreen();
    public abstract void displayInstructions();
    public abstract int input_boardSize();
    public abstract Board initBoard();
    public abstract void displayBoardInstructions();
    public abstract void letsPlay();
    
}
