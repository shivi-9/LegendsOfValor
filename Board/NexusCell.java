package LegendsCode;

public class NexusCell extends BoardCells implements CellsWithRoles{
    private String nexusType;
    private Hero heroSlot;
    private Monster monsterSlot;
    private Boolean isHeroSlot = false;
    private Boolean isMonsterSlot = false;
    
    public NexusCell(String cellName, String cellValue, int[] cellLocation, String nexusType, String bgColour) {
        super(cellName, cellValue, cellLocation, bgColour);
        this.nexusType = nexusType;
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

    public String getNexusType() {
        return nexusType;
    }

    public void setNexusType(String nexusType) {
        this.nexusType = nexusType;
    }

    public Hero getHeroSlot() {
        return heroSlot;
    }

    public void setHeroSlot(Roles roles) {
        if(!(isHeroSlot)){
            this.heroSlot = (Hero) roles;
            isHeroSlot = true;
        }
    }

    public Monster getMonsterSlot() {
        return monsterSlot;
    }

    public void setMonsterSlot(Roles roles) {
        if(!(isMonsterSlot)){
            this.monsterSlot = (Monster) roles;
            isMonsterSlot = true;
        }
    }

    public Boolean getIsHeroSlot() {
        return isHeroSlot;
    }

    public Boolean getIsMonsterSlot() {
        return isMonsterSlot;
    }

    public void resetHeroSlot(){
        isHeroSlot = false;
        this.heroSlot = null;
        setCellValue("");
    }

    public void resetMonsterSlot(){
        isMonsterSlot = false;
        this.monsterSlot = null;
        setCellValue("");
    }
}
