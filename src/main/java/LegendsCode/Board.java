package LegendsCode;

/* This is the super Board class. This class has attributes and functions
 * which are common to all possible game boards */
public abstract class Board {
    public abstract void createBoardCells();
    public abstract void displayBoard();
    public abstract void updateBoard(String cellName, String cellValue, int[] cellLocation);
}
