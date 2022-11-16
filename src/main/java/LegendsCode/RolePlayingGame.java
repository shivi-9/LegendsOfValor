package LegendsCode;

/* This class has functions and attributes common to all Role Playing games */
public abstract class RolePlayingGame{
    public abstract GridBoard set_BoardCells(GridBoard board);
    public abstract int[] nextMove(GridBoard board, int[] currentLoc);
    public abstract void displayMoveInstructions();
    public abstract Boolean checkMove(GridBoard board, int[] newIndex);
    

}