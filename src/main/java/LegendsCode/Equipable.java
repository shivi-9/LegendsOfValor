package LegendsCode;

/* Super class for Armor and Weapon
 * This class has functionalities common to both of them */
public abstract class Equipable implements Items{
    public abstract void setEquipStatus(String s);
    public abstract String getEquipStatus();
}
