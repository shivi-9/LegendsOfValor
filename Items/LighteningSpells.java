package LegendsCode;

/* This class implements the Spells interface.
 * This class hold all the functionalities related to 
 * specific spell items called Lightening spells */
public class LighteningSpells implements Consumable, Spells{
    private String name; // Name of the spell
    private int cost; // Cost of the spell
    private int reqLevel; // Level required to buy this spell
    private int damage; // Damage caused by this spell
    private int manaCost; // Mana cost required to use this spell
    private String type; // Type of item in this case "spell"
    private String spellType; // Type of spell in this case "lightening"
    private String status; // Whether the spell has been used or not

    public LighteningSpells(String name){
        this.name = name;
        type = "spell";
        spellType = "lightening";
        status = "left";
        if(name.equalsIgnoreCase("Lightning_Dagger")){
            cost = 400;
            reqLevel = 1;
            damage = 500;
            manaCost = 150;
        }
        else if(name.equalsIgnoreCase("Thunder_Blast")){
            cost = 750;
            reqLevel = 4;
            damage = 950;
            manaCost = 400;
        }
        else if(name.equalsIgnoreCase("Electric_Arrows")){
            cost = 550;
            reqLevel = 5;
            damage = 650;
            manaCost = 200;
        }
        else if(name.equalsIgnoreCase("Spark_Needles")){
            cost = 500;
            reqLevel = 2;
            damage = 600;
            manaCost = 200;
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
