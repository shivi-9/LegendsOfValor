package LegendsCode;
import java.util.*;

/* This class handles all the functionalities related to the Market */
public class Market {
    private ArrayList<Items> weaponList = new ArrayList<Items>(); // Weapons available in market
    private ArrayList<Items> armorList = new ArrayList<Items>(); // Armors available in market
    private ArrayList<Items> potionList = new ArrayList<Items>(); // Potions available in market
    private ArrayList<Items> spellList = new ArrayList<Items>(); // Spells available in market
    private ArrayList<Items> marketItems = new ArrayList<Items>(); // all items available in market
    private int gold; // Gold available to this market
    
    public Market(){
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

    // Function to display items for sale
    public void displayMarket(){
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
