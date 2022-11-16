package LegendsCode;

/* This is the class which has functions and attributes related
 * to all types of Armors */
public class Armor extends Equipable  {
    private String name; // Name of the Item
    private int cost; // Cost of the Item
    private int reqLevel; // Level required to buy the item
    private int damageReduction; // Damage the item will reduce incase of attack
    private String type; // Type of item
    private String status; // Status of item. Whether it has been used to not.

    public Armor(String name){
        this.name = name;
        this.type = "armor";
        this.status = "unequipped";
        if(name.equalsIgnoreCase("Platinum_Shield")){
            cost = 150;
            reqLevel = 1;
            damageReduction = 200;
        }
        else if(name.equalsIgnoreCase("Breastplate")){
            cost = 350;
            reqLevel = 3;
            damageReduction = 600;
        }
        else if(name.equalsIgnoreCase("Full_Body_Armor")){
            cost = 1000;
            reqLevel = 8;
            damageReduction = 1100;
        }
        else if(name.equalsIgnoreCase("Wizard_Shield")){
            cost = 1200;
            reqLevel = 10;
            damageReduction = 1500;
        }
        else if(name.equalsIgnoreCase("Guardian_Angel")){
            cost = 1000;
            reqLevel = 10;
            damageReduction = 1000;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEquipStatus(String s){
        this.status = s;
    }

    public String getEquipStatus(){
        return status;
    }
    
}