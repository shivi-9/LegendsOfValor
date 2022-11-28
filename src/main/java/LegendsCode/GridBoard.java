package LegendsCode;

/* This is the class for all Grid type boards like chess board, tic-tac-toe 
 * board. It has all the attributes and functions for Grid type board */
public class GridBoard extends Board {
    private int height, width;
    private BoardCells[][] grid;
    private ColourBG colour = new ColourBG();

    // Function to create board cells
    @Override
    public void createBoard(BoardCells cell){
        grid[cell.getCellLocation()[0]][cell.getCellLocation()[1]] = cell;
    }

    // Function to display the board
    @Override
    public void displayBoard(){
        int space = 7;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print("+");
                for(int k = 0; k < space; k++){
                    System.out.print("-");
                }
            }
            System.out.print("+\n");
            for(int j = 0; j < width; j++){
                int len = grid[i][j].getCellValue().length();
                len = space - len - 1;
                System.out.print("|" + grid[i][j].getBgColour() + " " + grid[i][j].getCellValue());
                for(int k = 0; k < len; k++){
                    System.out.print(" ");
                }
                System.out.print(colour.getResetbg());
            }
            System.out.print("|\n");
        }
        for(int j = 0; j < width; j++){
            System.out.print("+");
            for(int k = 0; k < space; k++){
                System.out.print("-");
            }
        }
        System.out.print("+\n");
    }

    // Function to update the board
    @Override
    public void updateBoard(String cellName, String cellValue, int[] cellLocation){
        grid[cellLocation[0]][cellLocation[1]].setCellName(cellName);
        grid[cellLocation[0]][cellLocation[1]].setCellValue(cellValue);
    }

    // Function to set the boardSize when height is not equal to width
    public void set_boardSize(int h, int w){
        this.height = h;
        this.width = w;
        grid = new BoardCells[height][width];
    }

    // Funtion to set the boardSize when height is equal to width
    public void set_boardSize(int h){
        set_boardSize(h, h);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public BoardCells[][] getGrid() {
        return grid;
    }
}