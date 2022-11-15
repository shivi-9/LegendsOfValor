import java.util.ArrayList;


import java.util.*;
//hero abstract class that implements character interface
abstract class hero implements character{


    int money=1000;
    private int experience=1;
    int mana=0;
    int hp = 1000;
    int agility=0;
    int attack=0;
    int dexterity=0;
    int health=1000;
    String name = null;
    items equippedWeapon= null;
    items equippedArmor= null;

    ArrayList<items> inventory = new ArrayList<items>();



    public ArrayList<items> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<items> inventory) {
        this.inventory = inventory;
    }





    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getAgility() {
        return agility;
    }
    public void setAgility(int agility) {
        this.agility = agility;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getDexterity() {
        return dexterity;
    }
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public hero (String name, int attack, int agility, int dexterity, int money, int mana){
        this.name = name;
        this.attack = attack;
        this.agility = agility;
        this.dexterity = dexterity;
        this.money = money;
        this.mana = mana;

    }



    public void attack(monsters m) {
        m.health= (int) (m.health-Math.max(( this.attack + this.equippedWeapon.damageOrHeal - m.defence),(75)));


    }

    public void faint() {

    }




    public abstract void castSpell();

    public void openInventory() {
        int j=1;
        for (items i : inventory) {

            System.out.println(j+ ". Item name: " + i.name + " | Mana cost: " +i.manaCost + "Damage/Heal value: " + i.damageOrHeal);
            j++;
        }
    }

    public void addItem(items x){
        this.inventory.add(x);
    }


    public void removeItem(items x){
        this.inventory.remove(x);
    }


    public void addSpell(items x){
        this.inventory.add(x);
    }

    public abstract void levelUpAttributes();

    public void displayInfo(){

        System.out.println("Hero Name: " + this.name + " | Health: " + this.health + " | Attack: " + this.attack + " | Agility: "
                + this.agility + " | Dexterity " + this.dexterity + " | Mana: " + this.mana + " | Level: " + this.experience +
                " | Weapon: " + this.equippedWeapon.name + " | Armor: " + this.equippedArmor.name);
    }



}
