package LegendsCode;
import java.util.*;

/* This class hold everything that happends during a battle. */
public class Battle {
    private Scanner userInput = new Scanner(System.in);
    private Random random = new Random();

    // Function to create random listof monsters
    public ArrayList<Roles> createMonsters(ArrayList<Roles> heroList){
        MonsterFactory mFactory = new MonsterFactory();
        return mFactory.getMonster(heroList);
    }

    // Function to display the list of monsters
    public void displayMonsterList(ArrayList<Roles> monsterList){
        System.out.println("YOU ARE GOING TO FIGHT THE FOLLOWING MONSTERS");
        for(int i = 0; i < monsterList.size(); i++){
            System.out.println(monsterList.get(i).getName());
            System.out.println("\tHP:" + monsterList.get(i).getHp());
        }
    }

    // Funtion to get total HP of all the Roles
    public int totalHP(ArrayList<Roles> roles){
        int total = 0;
        for(int i = 0; i < roles.size(); i++){
            total += 1;
        }
        return total;
    }
    
    // Function to get hero's action type
    public String getHeroActionType(Roles hero){
        String actionType = new String();
        while(true){
            System.out.println(hero.getName() + ", please choose the action:");
            System.out.println("1. Attack using the weapon");
            System.out.println("2. Cast a spell");
            System.out.println("3. Drink a potion to protect yourself");
            System.out.println("4. View hero's inventory");
            System.out.println("5. View hero's statistics");
            try{
                int userResponse = Integer.parseInt(userInput.nextLine());
                if(userResponse == 1){
                    if(((Hero) hero).getWeaponEquip().size() > 0){
                        actionType = "weapon";
                        break;
                    }
                    else{
                        System.out.println("Hero doesn't have any weapons equipped");
                        System.out.println("Let's first equip a weapon");
                        ((Hero) hero).equipHero();
                    }
                }
                else if(userResponse == 2){
                    if(((Hero) hero).getSpellList().size() > 0){
                        actionType = "spell";
                        break;
                    }
                    else{
                        System.out.println("Hero doesn't have any spells");
                    }
                }
                else if(userResponse == 3){
                    if(((Hero) hero).getPotionList().size() > 0){
                        actionType = "potion";
                        break;
                    }
                    else{
                        System.out.println("Hero doesn't have any potion");
                    }
                }
                else if(userResponse == 4){
                    ((Hero) hero).displayInventory();
                }
                else if(userResponse == 5){
                    ((Hero) hero).displayStats();
                }
                else{
                    System.out.println("Invalid Input\nTry again");
                }
            }
            catch(Exception e){
                System.out.println("Invalid Input\nTry again");
            }
        }
        return actionType;
    }

    // Function to get hero's action
    public Items getHeroAction(Roles hero, String actionType){
        Items action;
        Boolean foundAction = true;
        while(foundAction){
            if(actionType.equalsIgnoreCase("weapon")){
                // Function to display weapon list
                ((Hero) hero).displayWeaponEquip();
                System.out.println("Enter the name of weapon you want to use:");
                String userResponse = userInput.nextLine();
                int index = -1;
                for(int i = 0; i < ((Hero) hero).getWeaponEquip().size(); i++){
                    if(userResponse.equalsIgnoreCase(((Hero) hero).getWeaponEquip().get(i))){
                        index = i;
                    }
                }
                if(index == -1){
                    System.out.println("This weapon doesn't exist\nTry again");
                }
                else{
                    for(int i = 0; i < ((Hero) hero).getWeaponList().size(); i++){
                        if(((Hero) hero).getWeaponEquip().get(i).equalsIgnoreCase(((Hero) hero).getWeaponList().get(i).getName())){
                            action = ((Hero) hero).getWeaponList().get(i);
                            foundAction = false;
                            return action;
                        }
                    }
                }
            }
            else if(actionType.equalsIgnoreCase("spell")){
                // Function to display spell list
                ((Hero) hero).displaySpellList();
                System.out.println("Enter the name of spell you want to use");
                String userResponse = userInput.nextLine();
                int index = -1;
                for(int i = 0; i < ((Hero) hero).getSpellList().size(); i++){
                    if(userResponse.equalsIgnoreCase(((Hero) hero).getSpellList().get(i).getName())){
                        index = i;
                    }
                }
                if(index == -1){
                    System.out.println("This spell doesn't exist\nTry again");
                }
                else{
                    if(((Hero) hero).getSpellList().get(index).getStatus().equalsIgnoreCase("left")){
                        action = ((Hero) hero).getSpellList().get(index);
                        if(((Hero) hero).getMana() > ((Spells) ((Hero) hero).getSpellList().get(index)).getManaCost()){
                            action = ((Hero) hero).getSpellList().get(index);
                            ((Hero) hero).setMana(((Hero) hero).getMana() - ((Spells) action).getManaCost());
                            if(((Hero) hero).getMana() == 0){
                                action.setStatus("consumed");
                            }
                            foundAction = false;
                            return action;
                        }
                        else{
                            System.out.println("You do not have enough mana points to cast this spell\nTry again");
                        }
                    }
                    else{
                        System.out.println("This spell has been fully consumed\nTry again");
                    }
                }
            }
            else if(actionType.equalsIgnoreCase("potion")){
                // Function to display list of potions
                ((Hero) hero).displayPotionList();
                System.out.println("Enter the name of potion you want to use");
                String userResponse = userInput.nextLine();
                int index = -1;
                for(int i = 0; i < ((Hero) hero).getPotionList().size(); i++){
                    if(userResponse.equalsIgnoreCase(((Hero) hero).getPotionList().get(i).getName())){
                        index = i;
                    }
                }
                if(index == -1){
                    System.out.println("This potion doesn't exist\nTry again");
                }
                else{
                    if(((Hero) hero).getPotionList().get(index).getStatus().equalsIgnoreCase("left")){
                        action = ((Hero) hero).getPotionList().get(index);
                        action.setStatus("consumed");
                        foundAction = false;
                        return action;
                    }
                    else{
                        System.out.println("This spell has been fully consumed\nTry again");
                    }
                }
            }
        }
        return null;
    }

    // Asking the hero to enter the monster they want to fight
    public Roles chooseMonster(ArrayList<Roles> monsterList){
        Boolean foundMonster = true;
        Monster monster;
        while(foundMonster){
            System.out.println("Enter the name of the monster you want to target:");
            String userResponse = userInput.nextLine();
            for(int i = 0; i < monsterList.size(); i++){
                if(userResponse.equalsIgnoreCase(monsterList.get(i).getName())){
                    monster = (Monster) monsterList.get(i);
                    foundMonster = false;
                    return monster;
                }
            }
            System.out.println("This monster doesn't exist\nTry again");
            displayMonsterList(monsterList);
        }
        return null;
    }
    
    // function to equip or unequip items
    public void askEquipUnequip(ArrayList<Roles> heroList){
        for(int i = 0; i < heroList.size(); i++){
            while(true){
                System.out.println("************************************************");
                System.out.println(heroList.get(i).getName());
                System.out.println("Press E/e to equip a item");
                System.out.println("Press U/u to unequip a item");
                System.out.println("Press Q/q to quit");
                System.out.println("Press B/b to get back");
                System.out.println("************************************************");
                String userResponse = userInput.nextLine();
                if(userResponse.equalsIgnoreCase("e")){
                    ((Hero) heroList.get(i)).equipHero();
                    break;
                }
                else if(userResponse.equalsIgnoreCase("u")){
                    ((Hero) heroList.get(i)).unequipHero();
                    break;
                }
                else if(userResponse.equalsIgnoreCase("q")){
                    System.exit(0);
                }
                else if(userResponse.equalsIgnoreCase("b")){
                    break;
                }
                else{
                    System.out.println("Invalid Input\nTry again");
                }
            }
        }
    }

    public void beginBattle(ArrayList<Roles> heroList, ArrayList<Roles> monsterList){
        // Equip heroes
        askEquipUnequip(heroList);

        // Funtion to get size of all the Roles
        int totalHeroHp = heroList.size();
        int totalMonsHp = monsterList.size();
        
        int i = -1;
        while(totalHeroHp != 0 && totalMonsHp != 0){
            if(i == heroList.size()-1){
                i = 0;
            }
            else{
                i++;
            }
            
            // HERO's ATTACK
            // Getting the hero doing the actions
            Roles hero = heroList.get(i);

            if(hero.getHp() > 0){
                // Function to get hero's action type
                String actionType = getHeroActionType(hero);

                int attackValue = 0;
                // Function to get hero's action
                Items action = getHeroAction(hero, actionType);

                // Doing the actions
                if(action.getType().equalsIgnoreCase("potion")){
                    // totalHeroHp = totalHeroHp - hero.getHp();
                
                    // Calling the function to implement the effects of potion
                    ((Hero) hero).potionUsed((Potions) action);
                    // totalHeroHp = totalHeroHp + hero.getHp();

                    System.out.println("Hero: " + hero.getName() + " drank " + action.getName() + " to improve its powers");
                    
                    System.out.println("Hero's Updated Statistics");
                    hero.displayStats();

                }
                else{
                    // Function to display the monsters
                    displayMonsterList(monsterList);

                    // Asking the hero to enter the monster they want to fight
                    Roles monster = chooseMonster(monsterList);
                    
                    // Calculate how much damage is caused to monster
                    if(action.getType().equalsIgnoreCase("spell")){
                        if(((Hero) hero).getMana() > ((Spells) action).getManaCost()){
                            attackValue = ((Monster) monster).monsterAttacked(action, hero);
                        }
                    }
                    else if(action.getType().equalsIgnoreCase("weapon")){
                        attackValue = ((Monster) monster).monsterAttacked(action, hero);
                    }
            
                    // totalMonsHp -= attackValue;

                    System.out.println("Hero: " + hero.getName() + " attacked Monster: " + monster.getName() + " for " + attackValue + " damage");
                    System.out.println("Monster's Updated Statistics");
                    monster.displayStats();

                    // Removing the monster from monster list if it hp is <= 0
                    if(monster.getHp() <= 0){
                        System.out.println(monster.getName() + " is dead");
                        monsterList.remove(monster);
                        totalMonsHp --;
                        if(totalMonsHp == 0){
                            break;
                        }
                    }
                }
            }

            // MONSTER's ATTACK
            // Generating monsters and heros randomly
            if(totalMonsHp != 0){
                int temp = random.nextInt(monsterList.size());
                Roles monster1 = (Monster) monsterList.get(temp);

                Roles hero1; 
                while(true){
                    int temp1 = random.nextInt(heroList.size());
                    if(heroList.get(temp1).getHp() > 0){
                        hero1 = (Hero) heroList.get(temp1);
                        break;
                    }
                }

                // Calcuating the attack hero suffered
                int attackValue = ((Hero) hero1).heroAttacked(monster1);

                // totalHeroHp -= attackValue;

                System.out.println("Monster: " + monster1.getName() + " attacked Hero: " + hero1.getName() + " for " + attackValue + " damage");
                System.out.println("Hero's Updated Statistics");
                hero1.displayStats();
                
                if(hero1.getHp() <= 0){
                    System.out.println(hero1.getName() + " fainted");
                    totalHeroHp --;
                    if(totalMonsHp == 0){
                        break;
                    }
                }
            }
        }
        if(totalHeroHp == 0){
            System.out.println("Heroes lost this Battle\nAll Heroes will be revived using a special Potion, but they won't be as powerful as before");
            System.out.println("Hero's Updated Statistics");
            for(int j = 0; j < heroList.size(); j++){
                heroList.get(j).setHp(100);
                heroList.get(j).displayStats();
            }
            
        }
        else if(totalMonsHp == 0){
            System.out.println("HERO PARTY WON");
            System.out.println("Hero's Updated Statistics");
            for(int j = 0; j < heroList.size(); j++){
                Hero hero = (Hero) heroList.get(j);
                hero.setLevel(hero.getLevel()+1);
                hero.setGold(hero.getGold() * 100);
                hero.setMana((int) (hero.getMana() * 1.5));
                hero.setStrength((int) (hero.getStrength() * 1.5));
                hero.setAgility((int) (hero.getAgility() * 1.5));
                hero.setDexterity((int) (hero.getDexterity() * 1.5));
                // to revive fainted heroes
                if(hero.getHp() == 0){
                    hero.setHp(150*10);
                }
                else{
                    hero.setHp(hero.getHp()*10);
                }
                hero.displayStats();
            }
        }        
    }

    public void letsFight(ArrayList<Roles> heroList){
        ArrayList<Roles> monsterList = new ArrayList<Roles>();

        System.out.println("************************************************");
        System.out.println("LET's BEGIN THE BATTLE");
        
        // Function to create monsters
        monsterList.addAll(createMonsters(heroList));

        // print created monsters
        displayMonsterList(monsterList);

        // Function to start the battle
        beginBattle(heroList, monsterList);
    }
    
}