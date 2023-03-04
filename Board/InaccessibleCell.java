package LegendsCode;

public class InaccessibleCell extends BoardCells {

    public InaccessibleCell(String cellName, String cellValue, int[] cellLocation, String bgColour) {
        super(cellName, cellValue, cellLocation, bgColour);
    }

    @Override
    public int[] getCellLocation() {
        return super.getCellLocation();
    }

    @Override
    public String getCellName() {
        return super.getCellName();
    }

    @Override
    public String getCellValue() {
        return super.getCellValue();
    }

    @Override
    public void setCellLocation(int[] cellLocation) {
        super.setCellLocation(cellLocation);
    }

    @Override
    public void setCellName(String cellName) {
        super.setCellName(cellName);
    }

    @Override
    public void setCellValue(String cellValue) {
        super.setCellValue(cellValue);
    }
}