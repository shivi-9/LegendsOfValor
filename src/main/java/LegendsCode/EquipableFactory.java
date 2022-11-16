package LegendsCode;
import java.util.*;

/* Instance generator factory for Equipable type items */
public class EquipableFactory extends ItemFactory{
    private String[] armorArr = {"Platinum_Shield", "Breastplate", "Full_Body_Armor", "Wizard_Shield", "Guardian_Angel"};
    private String[] weaponArr = {"Sword", "Bow", "Scythe", "Axe", "TSwords", "Dagger"};

    // Function to create instances of type consumable based on the type of Item
    public Equipable getItem(String itemType){    
        Random random = new Random();
        int temp;   
        if(itemType.equalsIgnoreCase("armor")){
            temp = random.nextInt(armorArr.length);
            return new Armor(armorArr[temp]);         
        }
        else if(itemType.equalsIgnoreCase("weapon")){
            temp = random.nextInt(weaponArr.length);
            return new Weapons(weaponArr[temp]);
        }	 
        return null;
    }
}
