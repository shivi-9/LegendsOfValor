package LegendsCode;
import java.util.*;

/* This class has functions and attributes related to all Sorcerer typed Heroes
 * and this class also implements the hero interface */
public class Sorcerer implements Hero{
    private int mana; // Power to cast spells
    private int strength; // Amount of damage hero can deal using weapon
    private int agility; // Chance to dodge attacks
    private int dexterity; // Amount of damage hero can deal using spell
    private int gold = 1800; // gold hero have currently
    private int level = 1; // Hero's current experience leve;
    private int hp = 1000; // Hero's health
    private ArrayList<Weapons> weaponList = new ArrayList<Weapons>(); // Weapons hero has
    private ArrayList<Armor> armorList = new ArrayList<Armor>(); // Armors hero has
    private ArrayList<Potions> potionList = new ArrayList<Potions>(); // Potions hero has
    private ArrayList<Spells> spellList = new ArrayList<Spells>(); // Spells hero has
    private String name; // Name of the hero
    private ArrayList<String> weaponEquip = new ArrayList<String>(); // Weapons currently equipped by the hero
    private String armorEquip; // Armor currently equipped by the hero
    private int hands; // Number of empty hands
    private Scanner userInput = new Scanner(System.in);
     
    public Sorcerer(String name){
        this.name = name;
        hands = 2;
        armorEquip = "";
        if(name.equals("Rillifane_Rallathil")){
            this.mana = 1300;
            this.strength = 750;
            this.agility = 450;
            this.dexterity = 500;
            spellList.add(new LighteningSpells("Lightning_Dagger"));
        }
        else if(name.equals("Segojan_Earthcaller")){
            this.mana = 900;
            this.strength = 800;
            this.agility = 500;
            this.dexterity = 650;
            spellList.add(new LighteningSpells("Lightning_Dagger"));
        }
        else if(name.equals("Reign_Havoc")){
            this.mana = 800;
            this.strength = 980;
            this.agility = 800;
            this.dexterity = 800;
            spellList.add(new LighteningSpells("Lightning_Dagger"));
        }
        else if(name.equals("Reverie_Ashels")){
            this.mana = 900;
            this.strength = 800;
            this.agility = 700;
            this.dexterity = 400;
            spellList.add(new LighteningSpells("Lightning_Dagger"));
        }
        else if(name.equals("Kalabar")){
            this.mana = 800;
            this.strength = 850;
            this.agility = 400;
            this.dexterity = 600;
            spellList.add(new LighteningSpells("Lightning_Dagger"));
        }
        else if(name.equals("Skye_Soar")){
            this.mana = 1000;
            this.strength = 700;
            this.agility = 400;
            this.dexterity = 500;
            spellList.add(new LighteningSpells("Lightning_Dagger"));
        }
    }

    // Function to set hero's inevntory
    public void set_inventory(Items item){
        if(item.getType().equalsIgnoreCase("armor")){
            armorList.add((Armor) item);
        }
        else if(item.getType().equalsIgnoreCase("spell")){
            spellList.add((Spells) item);
        }
        else if(item.getType().equalsIgnoreCase("potion")){
            potionList.add((Potions) item);
        }
        else if(item.getType().equalsIgnoreCase("weapon")){
            weaponList.add((Weapons) item);
        }
        this.gold = this.gold - item.getCost();
    }
    
    // Function to display the inventory items hero has
    public void displayInventory(){
        if(armorList.size() > 0 || potionList.size() > 0 || spellList.size() > 0 || weaponList.size() > 0){
            for(int i = 0; i < armorList.size(); i++){
                System.out.println("ARMOR");
                System.out.println(armorList.get(i).getName());
                System.out.println("\tCost: " + armorList.get(i).getCost());
                System.out.println("\tDamage Reduction: " + armorList.get(i).getDamageReduction());
            }
            for(int i = 0; i < potionList.size(); i++){
                System.out.println("POTION");
                System.out.println(potionList.get(i).getName());
                System.out.println("\tCost: " + potionList.get(i).getCost());
                System.out.println("\tAttribute Increase: " + potionList.get(i).getAttributeInc());
                
            }
            for(int i = 0; i < spellList.size(); i++){
                System.out.println("SPELL");
                System.out.println(spellList.get(i).getName());
                System.out.println("\tCost: " + spellList.get(i).getCost());
                System.out.println("\tDamage: " + spellList.get(i).getDamage());
                System.out.println("\tMana Cost: " + spellList.get(i).getManaCost());
                

            }
            for(int i = 0; i < weaponList.size(); i++){
                System.out.println("WEAPON");
                System.out.println(weaponList.get(i).getName());
                System.out.println("\tCost: " + weaponList.get(i).getCost());
                System.out.println("\tDamage: " + weaponList.get(i).getDamage());
                System.out.println("\tHands Required: " + weaponList.get(i).getHands());
            }
        }
        else{
            System.out.println("You do not have any item in your inventory");
        }
    }

    // Function to remove sold items from the inventory     
    public void remove_inventory(Items item){
        if(item.getType().equalsIgnoreCase("armor")){
            armorList.remove((Armor) item);
        }
        else if(item.getType().equalsIgnoreCase("spell")){
            spellList.remove((Spells) item);
        }
        else if(item.getType().equalsIgnoreCase("potion")){
            potionList.remove((Potions) item);
        }
        else if(item.getType().equalsIgnoreCase("weapon")){
            weaponList.remove((Weapons) item);
        }

        setGold((int) (this.gold + (0.9 * item.getCost())));
    }

    // Function to display Armor List
    public void displayArmorList(){
        System.out.println("ARMOR");
        for(int i = 0; i < armorList.size(); i++){
            System.out.println((i + 1) + ". " + armorList.get(i).getName());
        }
    }

    // Function to display Weapon list
    public void displayWeaponList(){
        System.out.println("WEAPON");
        for(int i = 0; i < weaponList.size(); i++){
            System.out.println((i + 1) + ". " + weaponList.get(i).getName());
        }
    }

    // Function to display Potion List
    public void displayPotionList(){
        System.out.println("POTION");
        for(int i = 0; i < potionList.size(); i++){
            System.out.println((i + 1) + ". " + potionList.get(i).getName());
        }
    }

    // Function to display Spell list
    public void displaySpellList(){
        System.out.println("Spells");
        for(int i = 0; i < spellList.size(); i++){
            System.out.println((i + 1) + ". " + spellList.get(i).getName() + " - " + ((Spells) spellList.get(i)).getSpellType());
        }
    }

    public void setWeaponEquip(String wE){
        int check = 0;
        if(hands != 0){
            for(int i = 0; i < weaponList.size(); i++){
                if(wE.equalsIgnoreCase(weaponList.get(i).getName())){
                    if(weaponList.get(i).getStatus().equalsIgnoreCase("unequipped")){
                        weaponEquip.add(wE);
                        check = 1;
                        hands = hands - weaponList.get(i).getHands();
                        weaponList.get(i).setStatus("equipped");
                    }
                    else{
                        System.out.println("Hero has already equipped this weapon");
                    }
                }
            }
            if(check == 0){
                System.out.println("Invalid input\nTry again");
            }
        }
        else{
            System.out.println("Hands of the Hero are full\nPlease first remove the current weapon(/s)");
        }
    }

    public void setArmorEquip(String aE){
        int check = 0;
        if(armorEquip.equals("")){
            for(int i = 0; i < armorList.size(); i++){
                if(aE.equalsIgnoreCase(armorList.get(i).getName())){
                    if(armorList.get(i).getStatus().equalsIgnoreCase("unequipped")){
                        armorEquip = aE;
                        check = 1;
                        armorList.get(i).setStatus("equipped");
                    }
                    else{
                        System.out.println("Hero has already equipped this armor");
                    } 
                }
            }
            if(check == 0){
                System.out.println("Invalid input\nTry again");
            }
        }
        else{
            System.out.println("Hero already has an armor on\nPlease first remove that");
        }
    }

    // Function to display the equipped weapons
    public void displayWeaponEquip(){
        for(int i = 0; i < weaponEquip.size(); i++){
            System.out.println(weaponEquip.get(i));
        }
    }

    // Function to implement effects of potion taken by hero
    public void potionUsed(Potions potion){
        if(potion.getName().equalsIgnoreCase("Healing_Potion")){
            hp += 100;
        }
        else if(potion.getName().equalsIgnoreCase("Strength_Potion")){
            strength += 75; 
        }
        else if(potion.getName().equalsIgnoreCase("Magic_Potion")){
            mana += 100; 
        }
        else if(potion.getName().equalsIgnoreCase("Luck_Elixir")){
            agility += 65; 
        }
        else if(potion.getName().equalsIgnoreCase("Mermaid_Tears")){
            hp += 100;
            mana += 100;
            strength += 100;
            agility += 100; 
        }
        else if(potion.getName().equalsIgnoreCase("Ambrosia")){
            hp += 150;
            mana += 150;
            strength += 150;
            agility += 150;
            dexterity += 150;
        }
    }
    
    // Function to implement effects after an attack    
    public int heroAttacked(Roles monster){
        int damageReduction = 0;
        if(armorEquip.equals("")){
            damageReduction = 0;
        }
        else{
            for(int i = 0; i < armorList.size(); i++){
                if(armorEquip.equalsIgnoreCase(armorList.get(i).getName())){
                    damageReduction = armorList.get(i).getDamageReduction();
                }
            }
        }
        int attackValue = ((Monster) monster).getDamage() - damageReduction - (agility/100);
        if(attackValue < 0){
            attackValue = 0;
        }
        hp = hp - attackValue;
        if(hp < 0){
            hp = 0;
        } 
        return attackValue;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public ArrayList<Weapons> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(ArrayList<Weapons> weaponList) {
        this.weaponList = weaponList;
    }

    public ArrayList<Armor> getArmorList() {
        return armorList;
    }

    public void setArmorList(ArrayList<Armor> armorList) {
        this.armorList = armorList;
    }

    public ArrayList<Potions> getPotionList() {
        return potionList;
    }

    public void setPotionList(ArrayList<Potions> potionList) {
        this.potionList = potionList;
    }

    public ArrayList<Spells> getSpellList() {
        return spellList;
    }

    public void setSpellList(ArrayList<Spells> spellList) {
        this.spellList = spellList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getWeaponEquip() {
        return weaponEquip;
    }

    public String getArmorEquip() {
        return armorEquip;
    }

    public int getHands() {
        return hands;
    }

    public void setHands(int hands) {
        this.hands = hands;
    }

    // equip items to the hero
    public void equipHero(){
        Boolean doneEquip = true;
        while(doneEquip){
            System.out.println("************************************************");
            System.out.println(name);
            System.out.println("Press A/a to equip the Armor");
            System.out.println("Press W/w to equip the Weapon");
            System.out.println("Press B/b if you don't want to equip anymore");
            System.out.println("Press Q/q to quit");
            System.out.println("************************************************");
            String userResponse = userInput.nextLine();
            if(userResponse.equalsIgnoreCase("a")){
                if(armorEquip.equalsIgnoreCase("")){
                    // Function to display armorlist
                    if(getArmorList().size() > 0){
                        displayArmorList();
                        System.out.println("Enter name of the armor you wanna equip:");
                        String userResponse1 = userInput.nextLine();
                        int check = 0;
                        for(int i = 0; i < getArmorList().size(); i++){
                            if(userResponse1.equalsIgnoreCase(getArmorList().get(i).getName())){
                                check = 1;
                                setArmorEquip(userResponse1);
                                getArmorList().get(i).setEquipStatus("equipped");
                            }
                        }
                        if(check == 0){
                            System.out.println("You don't have this armor");
                        }
                    }
                    else{
                        System.out.println("You don't have any armors in the Inventory");
                    }
                }
                else{
                    System.out.println("Hero already has an Armor on");
                }
            }
            else if(userResponse.equalsIgnoreCase("w")){
                if(hands != 0){
                    if(getWeaponList().size() > 0){
                        displayWeaponList();
                        int check = 0;
                        System.out.println("Enter name of the weapon you wanna equip:");
                        String userResponse1 = userInput.nextLine();
                        for(int i = 0; i < weaponList.size(); i++){
                            if(userResponse1.equalsIgnoreCase(weaponList.get(i).getName())){
                                if(hands >= weaponList.get(i).getHands()){
                                    hands = hands - weaponList.get(i).getHands();
                                    setWeaponEquip(userResponse1);
                                    check = 1;
                                    weaponList.get(i).setEquipStatus("equipped");
                                }
                                else{
                                    System.out.println("You don't have enough hands to equip this weapon");;
                                }
                            }
                        }
                        if(check == 0){
                            System.out.println("You don't have this weapon in the inventory");;
                        }
                    }
                    else{
                        System.out.println("You don't have any weapons in the inventory");
                    }
                }
                else{
                    System.out.println("You don't have any vaccant hands");
                }
            }
            else if(userResponse.equalsIgnoreCase("b")){
                doneEquip = false;
            }
            else if(userResponse.equalsIgnoreCase("q")){
                System.exit(0);
            }
            else{
                System.out.println("Invalid Input\nTry again");
            }
        }
    }

    // unequip items to the hero
    public void unequipHero(){
        Boolean doneEquip = true;
        while(doneEquip){
            System.out.println("************************************************");
            System.out.println(name);
            System.out.println("Press A/a to unequip the Armor");
            System.out.println("Press W/w to unequip the Weapon");
            System.out.println("Press B/b to go back");
            System.out.println("Press Q/q to quit");
            System.out.println("************************************************");
            String userResponse = userInput.nextLine();
            if(userResponse.equalsIgnoreCase("a")){
                if(armorEquip.equalsIgnoreCase("")){
                    System.out.println("Hero doesn't have any armor on");
                }
                else{
                    for(int i = 0; i < getArmorList().size(); i++){
                        if(getArmorEquip().equalsIgnoreCase(getArmorList().get(i).getName())){
                            setArmorEquip("");
                            getArmorList().get(i).setEquipStatus("unequipped");
                        }
                    }
                }
            }
            else if(userResponse.equalsIgnoreCase("w")){
                if(hands == 0){
                    System.out.println("Hero doesn't have any equipped weapons");
                }
                else{
                    System.out.println("Equipped Weapons");
                    for(int i = 0; i < getWeaponEquip().size(); i++){
                        System.out.println(getWeaponEquip().get(i));
                    }
                    System.out.println("Enter name of the weapon you wanna unequip:");
                    String userResponse1 = userInput.nextLine();
                    int check = 0;
                    int index = -1;
                    for(int i = 0; i < getWeaponEquip().size(); i++){
                        if(userResponse1.equalsIgnoreCase(getWeaponEquip().get(i))){
                            check = 1;
                            index = i;
                        }
                    }
                    if(check == 1){
                        for(int i = 0; i < getWeaponList().size(); i++){
                            if(userResponse1.equalsIgnoreCase(getWeaponList().get(i).getName())){
                                getWeaponEquip().remove(index);
                                getWeaponList().get(i).setEquipStatus("unequipped");
                            }
                        }
                    }
                    else{
                        System.out.println("Hero doesn't have this weapon");
                    }
                }
            }
            else if(userResponse.equalsIgnoreCase("b")){
                doneEquip = false;
            }
            else if(userResponse.equalsIgnoreCase("q")){
                System.exit(0);
            }
            else{
                System.out.println("Invalid Input\nTry again");
            }
        }
    }

    // function to display stats
    public void displayStats(){
        System.out.println("************************************************");
        System.out.println(name);
        System.out.println("\tHP: " + hp + "\tMana: " + mana + "\tGold:" + gold);
        System.out.println("************************************************");
    }
}