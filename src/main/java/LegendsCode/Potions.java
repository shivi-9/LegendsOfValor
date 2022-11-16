package LegendsCode;

/* This is the class which has functions and attributes related
 * to all types of Potions */
public class Potions implements Consumable{
    private String name; // Name of the potion
    private int cost; // Cost of the potion
    private int reqLevel; // Level required to buy that potion
    private int attributeInc; // Amount by which attribute will increase after drinking the potion
    private String attribute; // Attributes that will be affected after drinking the potions
    private String type; // Type of item
    private String status; // Whether the potion is left or fully consumed

    public Potions(String name){
        this.name = name;
        type = "potion";
        status = "left";
        if(name.equalsIgnoreCase("Healing_Potion")){
            cost = 250;
            reqLevel = 1;
            attributeInc = 100;
            attribute = "hp";
        }
        else if(name.equalsIgnoreCase("Strength_Potion")){
            cost = 200;
            reqLevel = 1;
            attributeInc = 75;
            attribute = "strength";
        }
        else if(name.equalsIgnoreCase("Magic_Potion")){
            cost = 350;
            reqLevel = 2;
            attributeInc = 100;
            attribute = "mana";
        }
        else if(name.equalsIgnoreCase("Luck_Elixir")){
            cost = 500;
            reqLevel = 4;
            attributeInc = 65;
            attribute = "agility";
        }
        else if(name.equalsIgnoreCase("Mermaid_Tears")){
            cost = 850;
            reqLevel = 5;
            attributeInc = 100;
            attribute = "hp|mana|strength|agility";
        }
        else if(name.equalsIgnoreCase("Ambrosia")){
            cost = 1000;
            reqLevel = 8;
            attributeInc = 150;
            attribute = "hp|mana|strength|agility|dexterity|defense";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getReqLevel() {
        return reqLevel;
    }

    public void setReqLevel(int reqLevel) {
        this.reqLevel = reqLevel;
    }

    public int getAttributeInc() {
        return attributeInc;
    }

    public void setAttributeInc(int attributeInc) {
        this.attributeInc = attributeInc;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}