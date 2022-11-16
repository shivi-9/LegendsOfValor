package LegendsCode;

/* This class has attributes and functions which has to be implemented on 
 * a specific board cell */
public class BoardCells {
    private String cellName = ""; // Name of that cell
    private String cellValue = ""; // Value of that cell 
    private int[] cellLocation = new int[2]; // Location of that cell

    public BoardCells(String cellName, String cellValue, int[] cellLocation){
        this.cellName = cellName; 
        this.cellValue = cellValue;
        for(int i = 0; i < cellLocation.length; i++){
            this.cellLocation[i] = cellLocation[i];
        }
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getCellValue() {
        return cellValue;
    }

    public void setCellValue(String cellValue) {
        this.cellValue = cellValue;
    }

    public int[] getCellLocation() {
        return cellLocation;
    }

    public void setCellLocation(int[] cellLocation) {
        for(int i = 0; i < cellLocation.length; i++){
            this.cellLocation[i] = cellLocation[i];
        }
    }
}
