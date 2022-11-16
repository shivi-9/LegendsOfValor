package LegendsCode;

/* This is the class which has functions and attributes related
 * to all types of Potions */
public class Weapons extends Equipable{
    private String name; // Name of the weapon
    private int cost; // Cost of the weapon
    private int reqLevel; // Level required to buy that weapon
    private int damage; // Ammount of damage caused by that weapon
    private int hands; // Number of hands required by that weapon
    private String type; // Type of item
    private String status; // Whether the weapon is equipped/unequipped

    public Weapons(String name){
        this.name = name;
        type = "weapon";
        status = "unequipped";
        if(name.equalsIgnoreCase("Sword")){
            cost = 500;
            reqLevel = 1;
            damage = 800;
            hands = 1;
        }
        else if(name.equalsIgnoreCase("Bow")){
            cost = 300;
            reqLevel = 2;
            damage = 500;
            hands = 2;
        }
        else if(name.equalsIgnoreCase("Scythe")){
            cost = 1000;
            reqLevel = 6;
            damage = 1100;
            hands = 2;
        }
        else if(name.equalsIgnoreCase("Axe")){
            cost = 550;
            reqLevel = 5;
            damage = 850;
            hands = 1;
        }
        else if(name.equalsIgnoreCase("TSwords")){
            cost = 1400;
            reqLevel = 8;
            damage = 1600;
            hands = 1;
        }
        else if(name.equalsIgnoreCase("Dagger")){
            cost = 200;
            reqLevel = 1;
            damage = 250;
            hands = 1;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHands() {
        return hands;
    }

    public void setHands(int hands) {
        this.hands = hands;
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

    public void setEquipStatus(String s){
        this.status = s;
    }

    public String getEquipStatus(){
        return status;
    }
}