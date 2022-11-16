package LegendsCode;

/* This is the class for all Grid type boards like chess board, tic-tac-toe 
 * board. It has all the attributes and functions for Grid type board */
public class GridBoard extends Board {
    private int height, width;
    private BoardCells[][] grid;

    // Function to create board cells
    public void createBoardCells(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                int[] temp = {i, j};
                grid[i][j] = new BoardCells(" ", " ", temp);
            }
        }

    }

    // Function to display the board
    public void displayBoard(){
        int space = 3;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print("+");
                for(int k = 0; k < space; k++){
                    System.out.print("-");
                }
            }
            System.out.print("+\n");
            for(int j = 0; j < width; j++){
                // int temp1 = space - 1;
                System.out.print("| " + grid[i][j].getCellValue() + " ");
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

    public Object[][] get_GridBoard() {
        return null;
    }
}
