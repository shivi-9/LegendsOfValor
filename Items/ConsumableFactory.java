package LegendsCode;
import java.util.*;

/* Instance generator factory for Consumable type items */
public class ConsumableFactory extends ItemFactory {
    private String[] fSpellsArr = {"Flame_Tornado", "Breath_of_Fire", "Heat_Wave", "Lava_Comet", "Hell_Storm"};
    private String[] iSpellsArr = {"Snow_Cannon", "Ice_Blade", "Frost_Blizzard", "Arctic_Storm"};
    private String[] lSpellsArr = {"Lightning_Dagger", "Thunder_Blast", "Electric_Arrows", "Spark_Needles"};
    private String[] potionsArr = {"Healing_Potion", "Strength_Potion", "Magic_Potion", "Luck_Elixir", "Mermaid_Tears", "Ambrosia"};

    // Function to create instances of type consumable based on the type of Item
    public Consumable getItem(String itemType){ 
        Random random = new Random();
        int temp;   
        if(itemType.equalsIgnoreCase("fire_spell")){
            temp = random.nextInt(fSpellsArr.length);
            return new FireSpells(fSpellsArr[temp]);         
        }
        else if(itemType.equalsIgnoreCase("ice_spell")){
            temp = random.nextInt(iSpellsArr.length);
            return new IceSpells(iSpellsArr[temp]);         
        }
        else if(itemType.equalsIgnoreCase("lightening_spell")){
            temp = random.nextInt(lSpellsArr.length);
            return new LighteningSpells(lSpellsArr[temp]);         
        }
        else if(itemType.equalsIgnoreCase("potion")){
            temp = random.nextInt(potionsArr.length);
            return new Potions(potionsArr[temp]);
        }	 
        return null;
    }
}
