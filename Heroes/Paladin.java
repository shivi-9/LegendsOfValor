package LegendsCode;
import java.util.*;

/* This class has functions and attributes related to all Paladin typed Heroes
 * and this class also implements the hero interface */
public class Paladin implements Hero{
    private int mana; // Power to cast spells
    private int strength; // Amount of damage hero can deal using weapon
    private int agility; // Chance to dodge attacks
    private int dexterity; // Amount of damage hero can deal using spell 
    private int gold = 1800; // gold hero have currently
    private int level = 1; // Hero's current experience level;
    private int hp = 1000; // Hero's health
    private ArrayList<Weapons> weaponList = new ArrayList<Weapons>(); // Weapons hero has
    private ArrayList<Armor> armorList = new ArrayList<Armor>(); // Armors hero has
    private ArrayList<Potions> potionList = new ArrayList<Potions>(); // Potions hero has
    private ArrayList<Spells> spellList = new ArrayList<Spells>(); // Spells hero has
    private String name; // Name of the hero
    private ArrayList<String> weaponEquip = new ArrayList<String>(); // Weapons currently equipped by the hero
    private String armorEquip; // Armor currently equipped by the hero
    private int hands; // Number of empty hands
    private int[] location = new int[2]; // Location of Hero
    private UserInput userInput = new UserInput();
    private int lane; // lane of hero
    private int life = 3; // everytime hero is respawned, it's life decremets by 1
     
    public Paladin(String name){
        this.name = name;
        hands = 2;
        armorEquip = "";
        if(name.equals("Parzival")){
            this.mana = 300;
            this.strength = 750;
            this.agility = 650;
            this.dexterity = 700;
            weaponList.add(new Weapons("Sword"));
        }
        else if(name.equals("Sehanine_Moonbow")){
            this.mana = 300;
            this.strength = 750;
            this.agility = 700;
            this.dexterity = 700;
            weaponList.add(new Weapons("Sword"));
        }
        else if(name.equals("Skoraeus_Stonebones")){
            this.mana = 200;
            this.strength = 650;
            this.agility = 600;
            this.dexterity = 350;
            weaponList.add(new Weapons("Sword"));
        }
        else if(name.equals("Garl_Glittergold")){
            this.mana = 100;
            this.strength = 600;
            this.agility = 500;
            this.dexterity = 400;
            weaponList.add(new Weapons("Sword"));
        }
        else if(name.equals("Amaryllis_Astra")){
            this.mana = 500;
            this.strength = 500;
            this.agility = 500;
            this.dexterity = 500;
            weaponList.add(new Weapons("Sword"));
        }
        else if(name.equals("Caliber_Heist")){
            this.mana = 400;
            this.strength = 400;
            this.agility = 400;
            this.dexterity = 400;
            weaponList.add(new Weapons("Sword"));
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
        System.out.println("************************************************");
        System.out.println("ARMOR");
        for(int i = 0; i < armorList.size(); i++){
            System.out.println((i + 1) + ". " + armorList.get(i).getName());
        }
        System.out.println("************************************************");
    }

    // Function to display Weapon list
    public void displayWeaponList(){
        System.out.println("************************************************");
        System.out.println("WEAPON");
        for(int i = 0; i < weaponList.size(); i++){
            System.out.println((i + 1) + ". " + weaponList.get(i).getName());
        }
        System.out.println("************************************************");
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
    public void potionUsed(){
        int index = 0;
        int check = 0;
        while(true){
            System.out.println("**********************************************************************************************");
            System.out.println("You have following potion in your Inventory");
            for(int i = 0; i < potionList.size(); i++){
                System.out.println((i+1) + ". " + potionList.get(i).getName());
            }
            System.out.println("Enter the name of the Potion you'd like to use:");
            System.out.println("**********************************************************************************************");
            userInput.getUserInput();
            for(int i = 0; i < potionList.size(); i++){
                if(userInput.checkInput(potionList.get(i).getName())){
                    index = i;
                    check = 1;
                }
            }
            if(check == 0){
                System.out.println("You don't have this potion\nPlease try again");
            }
        
            if(potionList.get(index).getName().equalsIgnoreCase("Healing_Potion")){
                hp += 100;
                System.out.println("Healing Potion used");
                break;
            }
            else if(potionList.get(index).getName().equalsIgnoreCase("Strength_Potion")){
                strength += 75; 
                System.out.println("Strength Potion used");
                break;
            }
            else if(potionList.get(index).getName().equalsIgnoreCase("Magic_Potion")){
                mana += 100; 
                System.out.println("Magic Potion used");
                break;
            }
            else if(potionList.get(index).getName().equalsIgnoreCase("Luck_Elixir")){
                agility += 65; 
                System.out.println("Luck Elixir used");
                break;
            }
            else if(potionList.get(index).getName().equalsIgnoreCase("Mermaid_Tears")){
                hp += 100;
                mana += 100;
                strength += 100;
                agility += 100; 
                System.out.println("Mermaid Tears used");
                break;
            }
            else if(potionList.get(index).getName().equalsIgnoreCase("Ambrosia")){
                hp += 150;
                mana += 150;
                strength += 150;
                agility += 150;
                dexterity += 150;
                System.out.println("Ambrosia used");
                break;
            }
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
  
    // Function to check if Hero has enough inventory to equip an item
    public Boolean canEquipItem(){
        if((weaponList.size() > 0) || (armorList.size() > 0)){
            return true;
        }
        else{
            return false;
        }
    }

    // Function to check if Hero can unequip an item
    public Boolean canUnequipItem(){
        if((weaponEquip.size() > 0) || !(armorEquip.equalsIgnoreCase(""))){
            return true;
        }
        else{
            return false;
        }
    }

    // Function to check if Hero can change an item with another
    public  Boolean canChangeItem(){
        if(canEquipItem() && canUnequipItem()){
            return true;
        }
        else{
            return false;
        }
    }

    // equip items to the hero
    public void equipItem(){
        Boolean itemEquipped = false;
        while(!(itemEquipped)){
            System.out.println("************************************************************************************************");
            System.out.println(name);
            System.out.println("Press A/a to equip an Armor");
            System.out.println("Press W/w to equip a Weapon");
            System.out.println("Press Q/q to Quit the Game");
            System.out.println("************************************************************************************************");
            userInput.getUserInput();
            if(userInput.checkInput("a")){
                if(armorEquip.equalsIgnoreCase("")){
                    // Function to display armorlist
                    if(getArmorList().size() > 0){
                        System.out.println("************************************************************************************************");
                        System.out.println("You have following Armors in the Inventory:");
                        displayArmorList();
                        System.out.println("Enter name of the Armor you wanna Equip:");
                        System.out.println("************************************************************************************************");
                        userInput.getUserInput();
                        int check = 0;
                        for(int i = 0; i < getArmorList().size(); i++){
                            if(userInput.checkInput((getArmorList().get(i).getName()))){
                                check = 1;
                                setArmorEquip(userInput.getUserResponse());
                                getArmorList().get(i).setEquipStatus("equipped");
                                System.out.println("Successfully equipped " + getArmorList().get(i).getName());
                                itemEquipped = true;
                            }
                        }
                        if(check == 0){
                            System.out.println("You don't have this armor\nLet's try again");
                        }
                    }
                    else{
                        System.out.println("You don't have any armors in the Inventory\nPlease try different option");
                    }
                }
                else{
                    System.out.println("Hero already has an Armor on\n Hero can only have one Armor on at a time\nPlease try different option");
                }
            }
            else if(userInput.checkInput("w")){
                if(hands != 0){
                    if(getWeaponList().size() > 0){
                        int check = 0;
                        System.out.println("************************************************************************************************");
                        System.out.println("You have following Weapons in the Inventory:");
                        displayWeaponList();
                        System.out.println("Enter name of the Weapon you wanna Equip:");
                        System.out.println("************************************************************************************************");
                        userInput.getUserInput();
                        for(int i = 0; i < weaponList.size(); i++){
                            if(userInput.checkInput(weaponList.get(i).getName())){
                                if(hands >= weaponList.get(i).getHands()){
                                    hands = hands - weaponList.get(i).getHands();
                                    setWeaponEquip(userInput.getUserResponse());
                                    check = 1;
                                    weaponList.get(i).setEquipStatus("equipped");
                                    System.out.println("Successfully equipped " + getWeaponList().get(i).getName());
                                    itemEquipped = true;
                                }
                                else{
                                    System.out.println("You don't have enough hands to equip this weapon\nPlease try different option");
                                }
                            }
                        }
                        if(check == 0){
                            System.out.println("You don't have this weapon in the inventory\nPlease try different option");;
                        }
                    }
                    else{
                        System.out.println("You don't have any weapons in the inventory\nPlease try different option");
                    }
                }
                else{
                    System.out.println("You don't have any vaccant hands\nPlease try different option");
                }
            }
            else if(userInput.checkInput("q")){
                Legends.quit();
            }
            else{
                System.out.println("Invalid Input\nLet's try again");
            }
        }
    }

    // unequip items to the hero
    public void unequipItem(){
        Boolean itemUnequipped = false;
        while(!(itemUnequipped)){
            System.out.println("************************************************************************************************");
            System.out.println(name);
            System.out.println("Press A/a to unequip the Armor");
            System.out.println("Press W/w to unequip the Weapon");
            System.out.println("Press Q/q to Quit the Game");
            System.out.println("************************************************************************************************");
            userInput.getUserInput();
            if(userInput.checkInput("a")){
                if(armorEquip.equalsIgnoreCase("")){
                    System.out.println("Hero doesn't have any armor on\nPlease try different option");
                }
                else{
                    for(int i = 0; i < getArmorList().size(); i++){
                        if(getArmorEquip().equalsIgnoreCase(getArmorList().get(i).getName())){
                            setArmorEquip("");
                            getArmorList().get(i).setEquipStatus("unequipped");
                            System.out.println("Successfully unequipped " + getArmorList().get(i).getName());
                            itemUnequipped = true;
                        }
                    }
                }
            }
            else if(userInput.checkInput("w")){
                if(hands == 0){
                    System.out.println("Hero doesn't have any equipped weapons\nPlease try different option");
                }
                else{
                    System.out.println("************************************************************************************************");
                    System.out.println("Hero has following weapons equipped:");
                    for(int i = 0; i < getWeaponEquip().size(); i++){
                        System.out.println(getWeaponEquip().get(i));
                    }
                    System.out.println("Enter name of the weapon you wanna unequip:");
                    System.out.println("************************************************************************************************");
                    userInput.getUserInput();
                    int check = 0;
                    int index = -1;
                    for(int i = 0; i < getWeaponEquip().size(); i++){
                        if(userInput.checkInput(getWeaponEquip().get(i))){
                            check = 1;
                            index = i;
                        }
                    }
                    if(check == 1){
                        for(int i = 0; i < getWeaponList().size(); i++){
                            if(userInput.checkInput(getWeaponList().get(i).getName())){
                                getWeaponEquip().remove(index);
                                getWeaponList().get(i).setEquipStatus("unequipped");
                                System.out.println("Successfully unequipped " + getWeaponList().get(i).getName());
                                itemUnequipped = true;
                            }
                        }
                    }
                    else{
                        System.out.println("Hero doesn't have this weapon\nPlease try different option");
                    }
                }
            }
            else if(userInput.checkInput("q")){
                Legends.quit();
            }
            else{
                System.out.println("Invalid Input\nTry again");
            }
        }
    }

    // Change equipped items
    public void changeItem(){
        System.out.println("Let's first unequip the item");
        unequipItem();
        System.out.println("Now, let's equip the item");
        equipItem();
    }

    // function to display stats
    public void displayStats(){
        System.out.println("************************************************************************************************");
        System.out.println(name);
        System.out.println("\tHP: " + hp + "\tMana: " + mana + "\tGold:" + gold);
        System.out.println("************************************************************************************************");
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        for(int i = 0; i < location.length; i++){
            this.location[i] = location[i];
        }
    }

    // Function to check if hero has any potions in the inventory
    public Boolean canDrinkPotion(){
        if(potionList.size() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    // Function to check if hero has any item in their inventory or not
    public Boolean isInventory(){
        if(getArmorList().size() > 0 || getPotionList().size() > 0 || getSpellList().size() > 0 || getWeaponList().size() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void setWeaponEquip(ArrayList<String> weaponEquip) {
        this.weaponEquip = weaponEquip;
    }

    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }
}