package jaisalnshivangi;

/* Super class for Armor and Weapon
 * This class has functionalities common to both of them */
public abstract class Equippable implements Items{
    public abstract String getEquipStatus();
    public abstract void equipItem(Items item, Roles role);
}
