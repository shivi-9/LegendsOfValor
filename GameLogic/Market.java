package LegendsCode;
import java.util.*;

/* This class handles all the functionalities related to the Market */
public class Market {
    private ArrayList<Items> weaponList = new ArrayList<Items>(); // Weapons available in market
    private ArrayList<Items> armorList = new ArrayList<Items>(); // Armors available in market
    private ArrayList<Items> potionList = new ArrayList<Items>(); // Potions available in market
    private ArrayList<Items> spellList = new ArrayList<Items>(); // Spells available in market
    private ArrayList<Items> marketItems = new ArrayList<Items>(); // all items available in market
    private int gold = 0; // Gold available to this market
    private UserInput userInput = new UserInput();
    
    public Market(Hero hero){
        ItemFactory itemEquip = ItemsFactoryProducer.getFactory("equipable");
        weaponList.add(itemEquip.getItem("weapon"));
        armorList.add(itemEquip.getItem("armor"));
        ItemFactory itemConsume = ItemsFactoryProducer.getFactory("consumable");
        spellList.add(itemConsume.getItem("fire_spell"));
        spellList.add(itemConsume.getItem("ice_spell"));
        spellList.add(itemConsume.getItem("lightening_spell"));
        potionList.add(itemConsume.getItem("potion"));
        marketItems.addAll(weaponList);
        marketItems.addAll(armorList);
        marketItems.addAll(spellList);
        marketItems.addAll(potionList);
        gold = 0;
    }

    public void beginShopping(Hero hero){
        // Function to display the Market's welcome Screen
        displayMarketWelcomeScreen();

        Boolean doneShopping = false;
        while(!(doneShopping)){
            // Function to ask hero if they wanna buy/sell anything
            String buyOrSell = buyOrSell(hero);

            // Calling appropriate functions for shopping
            if(buyOrSell.equalsIgnoreCase("b")){
                // Function to input item to buy
                Items itemBuy = inputItemBuy(hero);

                // Function to add the item to hero's inventory
                ((Hero) hero).set_inventory(itemBuy);

                // Function to remove the item from market
                remove_marketItems(itemBuy);
                System.out.println("************************************************************************************************");
            }
            else if(buyOrSell.equalsIgnoreCase("s")){
                // Function to check if hero has any item in their inventory or not
                if(hero.isInventory()){
                    // Function to input item to sell
                    Items itemSell = inputItemSell(hero);

                    if(itemSell != null){
                        // Function to add the item to hero's inventory
                        ((Hero) hero).remove_inventory(itemSell);

                        // Function to remove the item from market
                        add_marketItems(itemSell);
                        System.out.println("************************************************************************************************");
                    }
                }
                else{
                    System.out.println("You do not have any items in your inventory\nPlease buy items first");
                }
            }
            else if(buyOrSell.equalsIgnoreCase("e")){
                doneShopping = true;
            }
        }
    }

    // Function to display the Market's welcome Screen
    public void displayMarketWelcomeScreen(){
        System.out.println("************************************************************************************************");
        System.out.println("***WELCOME TO THE MARKET***");
        System.out.println("You can buy or sell items here");
        System.out.println("Let's begin shopping");
    }
        
    // Function to ask hero if they wanna buy/sell anything
    public String buyOrSell(Roles hero){
        while(true){
            System.out.println("************************************************************************************************");
            System.out.println("Press S/s to sell an Item");
            System.out.println("Press B/b to Buy an Item");
            System.out.println("Press E/e to Exit the Market");
            System.out.println("Press D/d to see your Statistics");
            System.out.println("Press Q/q to Quit the Game");
            System.out.println("************************************************************************************************");
            userInput.getUserInput();
            if(userInput.checkInput("s")){
                if(getGold() > 500){
                    return "s";
                }
                else{
                    System.out.println("Market doesn't have enough gold\nPlease choose a different option");
                }
                
            }
            else if(userInput.checkInput("b")){
                return "b";
            }
            else if(userInput.checkInput("e")){
                return "e";
            }
            else if(userInput.checkInput("d")){
                hero.displayStats();
            }
            else if(userInput.checkInput("q")){
                Legends.quit();
            }
            else{
                System.out.println("Invalid Input\nTry Again");
            }
        }
    }

    // Function to input item to buy
    public Items inputItemBuy(Roles roles){
        while(true){
            // Function to display market's inventory
            displayMarket();
            System.out.println("Enter the name of the Item you want to buy:");
            System.out.println("************************************************************************************************");
            userInput.getUserInput();;
            
            // Function to check if the item is available in market or not
            if(checkItemBuy(userInput.getUserResponse())){
                // Function to retrive the item object using the name of the item
                Items itemBuy = get_itemBuy(userInput.getUserResponse());

                // Function to check if hero has enough gold and Level
                if(checkGoldnLevel(roles, itemBuy)){
                    return itemBuy;
                }
                else{
                    System.out.println("You don't have enough gold or experience\nPlease try buying something else");
                }
            }
            else{
                System.out.println("The item is not available in the market\nTry buying some other item");
            }
        }
    }

    // Function to display items for sale
    public void displayMarket(){
        System.out.println("************************************************************************************************");
        System.out.println("***ITEMS FOR SALE***");
        if(weaponList.size()>=1){
            System.out.println("WEAPONS");
            for(int i = 0; i < weaponList.size(); i++){
                System.out.println(weaponList.get(i).getName());
                System.out.println("\tRequired Level: " + weaponList.get(i).getReqLevel());
                System.out.println("\tCost: " + weaponList.get(i).getCost());
                System.out.println("\tDamage: " + ((Weapons) weaponList.get(i)).getDamage());
                System.out.println("\tHands Required: " + ((Weapons) weaponList.get(i)).getHands());
            }
        }
        if(armorList.size()>=1){
            System.out.println("Armors");
            for(int i = 0; i < armorList.size(); i++){
                System.out.println(armorList.get(i).getName());
                System.out.println("\tRequired Level: " + armorList.get(i).getReqLevel());
                System.out.println("\tCost: " + armorList.get(i).getCost());
                System.out.println("\tDamage Reduction: " + ((Armor) armorList.get(i)).getDamageReduction());
            } 
        }
        if(spellList.size()>=1){
            System.out.println("Spells");
            for(int i = 0; i < spellList.size(); i++){
                System.out.println(spellList.get(i).getName());
                System.out.println("\tRequired Level: " + spellList.get(i).getReqLevel());
                System.out.println("\tCost: " + spellList.get(i).getCost());
                System.out.println("\tDamage: " + ((Spells) spellList.get(i)).getDamage());
                System.out.println("\tMana Cost: " + ((Spells) spellList.get(i)).getManaCost());
            }
        }
        if(potionList.size()>=1){
            System.out.println("Potions");
            for(int i = 0; i < potionList.size(); i++){
                System.out.println(potionList.get(i).getName());
                System.out.println("\tRequired Level: " + potionList.get(i).getReqLevel());
                System.out.println("\tCost: " + potionList.get(i).getCost());
                System.out.println("\tAttribute Increase: " + ((Potions) potionList.get(i)).getAttributeInc());
            }
        }
    }

    // Function to check if the item is available in market or not
    public Boolean checkItemBuy(String item){
        for(int i = 0; i < getMarketItems().size(); i++){
            if(item.equalsIgnoreCase(getMarketItems().get(i).getName())){
                return true;
            }
        }
        return false;
    }

    // Function to retrive the item object using the name of the item
    public Items get_itemBuy(String itemName){
        for(int i = 0; i < getMarketItems().size(); i++){
            if(itemName.equalsIgnoreCase(getMarketItems().get(i).getName())){
                return getMarketItems().get(i);
            }
        }
        return null;
    }

    // Function to check if hero has enough gold
    public Boolean checkGoldnLevel(Roles roles, Items itemBuy){
        if((((Hero) roles).getGold() >= itemBuy.getCost()) && (roles.getLevel() >= itemBuy.getReqLevel())){
            return true;
        }
        else{
            return false;
        }
    }

    // Function to remove items that are sold off
    public void remove_marketItems(Items item){
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

        this.gold = this.gold + item.getCost();
        System.out.println(item.getName() + " bought for " + item.getCost());
    }

    // Function to input item to sell
    public Items inputItemSell(Hero hero){
        while(true){
            System.out.println("************************************************************************************************");
            System.out.println("YOU WILL ONLY GET 90% VALUE OF THE ITEM'S COST");
            hero.displayInventory();
            System.out.println("Enter the name of the Item you want to sell:");
            System.out.println("************************************************************************************************");
            userInput.getUserInput();;
            
            // Function to retrive the item object using the name of the item
            Items itemBuy = get_itemSell(hero, userInput.getUserResponse());

            // Function to check if market has enough gold
            if(checkGoldMkt(itemBuy)){
                return itemBuy;
            }
            else{
                System.out.println("Market doesn't have enough gold\nPlease try selling something else");
            }
        }
    }

    // Function to retrive the item object using the name of the item
    public Items get_itemSell(Hero hero, String itemName){
        for(int i = 0; i < hero.getArmorList().size(); i++){
            if(itemName.equalsIgnoreCase(getArmorList().get(i).getName())){
                return getArmorList().get(i);
            }
        }
        for(int i = 0; i < hero.getWeaponList().size(); i++){
            if(itemName.equalsIgnoreCase(getWeaponList().get(i).getName())){
                return getWeaponList().get(i);
            }
        }
        for(int i = 0; i < hero.getSpellList().size(); i++){
            if(itemName.equalsIgnoreCase(getSpellList().get(i).getName())){
                return getSpellList().get(i);
            }
        }
        for(int i = 0; i < hero.getPotionList().size(); i++){
            if(itemName.equalsIgnoreCase(getPotionList().get(i).getName())){
                return getPotionList().get(i);
            }
        }
        return null;
    }

    // Function to check if market has enough gold
    public Boolean checkGoldMkt(Items itemBuy){
        if(getGold() > 0.9 * itemBuy.getCost()){
            return true;
        }
        else{
            return false;
        }
    }

    // Function to add items that were bought
    public void add_marketItems(Items item){
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
        this.gold = (int) (this.gold - (0.9 * item.getCost()));

        System.out.println(item.getName() + " sold for " + (int) (0.9 * item.getCost()));
    }

    public ArrayList<Items> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(ArrayList<Items> weaponList) {
        this.weaponList = weaponList;
    }

    public ArrayList<Items> getArmorList() {
        return armorList;
    }

    public void setArmorList(ArrayList<Items> armorList) {
        this.armorList = armorList;
    }

    public ArrayList<Items> getPotionList() {
        return potionList;
    }

    public void setPotionList(ArrayList<Items> potionList) {
        this.potionList = potionList;
    }

    public ArrayList<Items> getSpellList() {
        return spellList;
    }

    public void setSpellList(ArrayList<Items> spellList) {
        this.spellList = spellList;
    }

    public ArrayList<Items> getMarketItems() {
        return marketItems;
    }

    public void setMarketItems(ArrayList<Items> marketItems) {
        this.marketItems = marketItems;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

}
