package LegendsCode;

/* This class implements the Spells interface.
 * This class hold all the functionalities related to 
 * specific spell items called Fire spells */
public class FireSpells implements Consumable, Spells{
    private String name; // Name of the spell
    private int cost; // Cost of the spell
    private int reqLevel; // Level required to buy this spell
    private int damage; // Damage caused by this spell
    private int manaCost; // Mana cost required to use this spell
    private String type; // Type of item in this case "spell"
    private String spellType; // Type of spell in this case "fire"
    private String status; // Whether the spell has been used or not

    public FireSpells(String name){
        this.name = name;
        type = "spell";
        spellType = "fire";
        status = "left";
        if(name.equalsIgnoreCase("Flame_Tornado")){
            cost = 750;
            reqLevel = 4;
            damage = 850;
            manaCost = 300;
        }
        else if(name.equalsIgnoreCase("Breath_of_Fire")){
            cost = 350;
            reqLevel = 1;
            damage = 450;
            manaCost = 100;
        }
        else if(name.equalsIgnoreCase("Heat_Wave")){
            cost = 450;
            reqLevel = 2;
            damage = 600;
            manaCost = 150;
        }
        else if(name.equalsIgnoreCase("Lava_Comet")){
            cost = 800;
            reqLevel = 7;
            damage = 1000;
            manaCost = 550;
        }
        else if(name.equalsIgnoreCase("Hell_Storm")){
            cost = 600;
            reqLevel = 3;
            damage = 950;
            manaCost = 600;
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
