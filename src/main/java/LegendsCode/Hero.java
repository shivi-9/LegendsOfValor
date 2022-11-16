package LegendsCode;
import java.util.*;

/* This is the interface which has signatures of functions
 * common to all Heroes */
public interface Hero extends Roles{
    public abstract void set_inventory(Items item);
    public abstract void displayInventory();
    public abstract void remove_inventory(Items item);
    public abstract void displayArmorList();
    public abstract void displayWeaponList();
    public abstract void displayPotionList();
    public abstract void displaySpellList();
    public abstract void setWeaponEquip(String wE);
    public abstract void setArmorEquip(String aE);
    public abstract void displayWeaponEquip();
    public abstract void potionUsed(Potions potion);
    public abstract int heroAttacked(Roles monster1);
    public abstract int getMana();
    public abstract void setMana(int mana);
    public abstract int getStrength();
    public abstract void setStrength(int strength);
    public abstract int getAgility();
    public abstract void setAgility(int agility);
    public abstract int getDexterity();
    public abstract void setDexterity(int dexterity);
    public abstract int getGold();
    public abstract void setGold(int gold);
    public abstract ArrayList<Weapons> getWeaponList();
    public abstract void setWeaponList(ArrayList<Weapons> weaponList);
    public abstract ArrayList<Armor> getArmorList();
    public abstract void setArmorList(ArrayList<Armor> armorList);
    public abstract ArrayList<Potions> getPotionList();
    public abstract void setPotionList(ArrayList<Potions> potionList);
    public abstract ArrayList<Spells> getSpellList();
    public abstract void setSpellList(ArrayList<Spells> spellList);
    public abstract ArrayList<String> getWeaponEquip();
    public abstract String getArmorEquip();
    public abstract int getHands();
    public abstract void setHands(int hands);
    public abstract void equipHero();
    public abstract void unequipHero();
}