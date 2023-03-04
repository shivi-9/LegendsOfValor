package LegendsCode;

public class KoulouCell extends BoardCells implements CellsWithBonus{
    private Hero heroSlot;
    private Monster monsterSlot;
    private Boolean isHeroSlot = false;
    private Boolean isMonsterSlot = false;

    public KoulouCell(String cellName, String cellValue, int[] cellLocation, String bgColour) {
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

    public void updateHeroPowers(Hero hero) {
        System.out.println("Koulou has increased Hero's strength by 10%");
        hero.setStrength((int) (hero.getStrength() * 1.1));
    }

    public void resetHeroPowers(Hero hero) {
        System.out.println("Hero has left the Koulou, it's strength is reduced to the original value");
        hero.setStrength((int) (hero.getStrength() / 1.1));
    }

}
