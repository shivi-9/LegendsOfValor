package LegendsCode;

/* This class implements the Spells interface.
 * This class hold all the functionalities related to 
 * specific spell items called Ice spells */
public class IceSpells implements Consumable, Spells{
    private String name; // Name of the spell
    private int cost; // Cost of the spell
    private int reqLevel; // Level required to buy this spell
    private int damage; // Damage caused by this spell
    private int manaCost; // Mana cost required to use this spell
    private String type; // Type of item in this case "spell"
    private String spellType; // Type of spell in this case "ice"
    private String status; // Whether the spell has been used or not

    public IceSpells(String name){
        this.name = name;
        type = "spell";
        status = "left";
        spellType = "ice";
        if(name.equalsIgnoreCase("Snow_Cannon")){
            cost = 500;
            reqLevel = 2;
            damage = 650;
            manaCost = 250;
        }
        else if(name.equalsIgnoreCase("Ice_Blade")){
            cost = 250;
            reqLevel = 1;
            damage = 450;
            manaCost = 100;
        }
        else if(name.equalsIgnoreCase("Frost_Blizzard")){
            cost = 750;
            reqLevel = 5;
            damage = 850;
            manaCost = 350;
        }
        else if(name.equalsIgnoreCase("Arctic_Storm")){
            cost = 700;
            reqLevel = 6;
            damage = 800;
            manaCost = 300;
        }
    }

    public String getSpellType() {
        return spellType;
    }

    public void setSpellType(String spellType) {
        this.spellType = spellType;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
