package LegendsCode;
import java.util.*;

public class Move {
    
    private UserInput userInput = new UserInput();

    public Move(Hero hero, ArrayList<Roles> heroList, GridBoard map, int heroIndex){
        // Function to get Hero's location and displaying options accordingly
        if(isNexus(hero, map)){
            nexusCell(hero, heroList, map, heroIndex);
        }
        else if(isCloseToMonster(hero, map)){
            closeToMonsterCell(hero, heroList, map, heroIndex);
        }
        else{
            anywhereElse(hero, heroList, map, heroIndex);
        }
    }

    public Move(Monster monster, ArrayList<Roles> monsterList, GridBoard map, int monsterIndex){
        // Function to get Monster's location and displaying options accordingly
        if(isCloseToHero(monster, map)){
            beginBattleMonster(monster, map);
        }
        else{
            // Move Monster
            moveMonster(monster, map);
        }
    }

    // Move Monster
    public void moveMonster(Monster monster, GridBoard map){
        int[] newLoc = {monster.getLocation()[0] + 1, monster.getLocation()[1]};
        String cellValue = map.getGrid()[monster.getLocation()[0]][monster.getLocation()[1]].getCellValue();
        ((CellsWithRoles) map.getGrid()[monster.getLocation()[0]][monster.getLocation()[1]]).resetMonsterSlot();
        monster.setLocation(newLoc);
        ((CellsWithRoles) map.getGrid()[newLoc[0]][newLoc[1]]).setMonsterSlot(monster);
        map.getGrid()[newLoc[0]][newLoc[1]].setCellValue(cellValue);
        System.out.println("************************************************************************************************");
        map.displayBoard();
    }

    // Function check if hero won or not
    public Boolean checkWinHero(Hero hero){
        if(hero.getLocation()[0] == 0){
            return true;
        }
        else{
            return false;
        }
    }

    // Function check if monster won or not
    public Boolean checkWinMonster(Monster monster){
        if(monster.getLocation()[0] == 7){
            return true;
        }
        else{
            return false;
        }
    }

    //Function to check if Monster is close to Hero
    public Boolean isCloseToHero(Monster monster, GridBoard map){
        int[] monsLoc = monster.getLocation();
        try{
            if(!(map.getGrid()[monsLoc[0] - 1][monsLoc[1]].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[monsLoc[0] - 1][monsLoc[1]]).getIsHeroSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[monsLoc[0] - 1][monsLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[monsLoc[0] - 1][monsLoc[1] - 1]).getIsHeroSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[monsLoc[0] - 1][monsLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[monsLoc[0] - 1][monsLoc[1] + 1]).getIsHeroSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[monsLoc[0] + 1][monsLoc[1]].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[monsLoc[0] + 1][monsLoc[1]]).getIsHeroSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[monsLoc[0] + 1][monsLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[monsLoc[0] + 1][monsLoc[1] - 1]).getIsHeroSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[monsLoc[0] + 1][monsLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[monsLoc[0] + 1][monsLoc[1] + 1]).getIsHeroSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[monsLoc[0]][monsLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[monsLoc[0]][monsLoc[1] - 1]).getIsHeroSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[monsLoc[0]][monsLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[monsLoc[0]][monsLoc[1] + 1]).getIsHeroSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        catch(ArrayIndexOutOfBoundsException exception){
            return false;
        }
    }

    // Function to check if hero is in Nexus
    public Boolean isNexus(Roles roles, GridBoard map){
        int[] heroLoc = roles.getLocation();
        if(map.getGrid()[heroLoc[0]][heroLoc[1]].getCellName().equalsIgnoreCase("nexus")){
            return true;
        }
        else{
            return false;
        }
    }

    // Function to check if current cell is plain
    public Boolean isPlain(Hero hero, GridBoard map){
        int[] heroLoc = hero.getLocation();
        if(map.getGrid()[heroLoc[0]][heroLoc[1]].getCellName().equalsIgnoreCase("plain")){
            return true;
        }
        else{
            return false;
        }
    }

    // Function to check if hero is in close proximity with Monster
    public Boolean isCloseToMonster(Hero hero, GridBoard map){
        int[] heroLoc = hero.getLocation();
        try{
            if(!(map.getGrid()[heroLoc[0] - 1][heroLoc[1]].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[heroLoc[0] - 1][heroLoc[1]]).getIsMonsterSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[heroLoc[0] - 1][heroLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[heroLoc[0] - 1][heroLoc[1] - 1]).getIsMonsterSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[heroLoc[0] - 1][heroLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[heroLoc[0] - 1][heroLoc[1] + 1]).getIsMonsterSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[heroLoc[0] + 1][heroLoc[1]].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[heroLoc[0] + 1][heroLoc[1]]).getIsMonsterSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[heroLoc[0] + 1][heroLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[heroLoc[0] + 1][heroLoc[1] - 1]).getIsMonsterSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[heroLoc[0] + 1][heroLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[heroLoc[0] + 1][heroLoc[1] + 1]).getIsMonsterSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[heroLoc[0]][heroLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[heroLoc[0]][heroLoc[1] - 1]).getIsMonsterSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(!(map.getGrid()[heroLoc[0]][heroLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[heroLoc[0]][heroLoc[1] + 1]).getIsMonsterSlot()){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        catch(ArrayIndexOutOfBoundsException exception){
            return false;
        }
    }

    // Function to check teleporting can be done or not
    public Boolean canTeleport(ArrayList<Roles> heroList, int heroIndex, GridBoard map){
        ArrayList<Roles> notMyTurn = new ArrayList<Roles>();
        for(int i = 0; i < heroList.size(); i++){
            if((i + 1) == heroIndex){
                continue;
            }
            else {
                notMyTurn.add(heroList.get(i));
            }
        }
        int isNexus = 0;
        for(int i = 0; i < notMyTurn.size(); i++){
            if(!(isNexus(notMyTurn.get(i), map))){
                isNexus = 1;
            }
        }
        if(isNexus == 1){
            if(notMyTurn.get(0).getLocation()[0] == notMyTurn.get(1).getLocation()[0]){
                int i = notMyTurn.get(0).getLocation()[0];
                int j = notMyTurn.get(0).getLocation()[1];
                if((notMyTurn.get(1).getLocation()[1] == j + 1) || (notMyTurn.get(1).getLocation()[1] == j - 1)){
                    if(!(map.getGrid()[i - 1][j].getCellName().equalsIgnoreCase("nexus"))){
                        return false;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    return true;
                }
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

    // Function to display and perform actions availble in Nexus
    public void nexusCell(Hero hero, ArrayList<Roles> heroList, GridBoard map, int heroIndex){
        System.out.println("Welcome to your Nexus");
        while(true){
            System.out.println("************************************************************************************************");
            System.out.println("You can choose to do any of the following:");
            System.out.println("Press E/e to Equip/Unequip/Change a Weapon/Armor");
            System.out.println("Press P/p to Drink a Potion");
            System.out.println("Press M/m to Move to another Cell");
            System.out.println("Press T/t to Teleport to another Lane");
            System.out.println("Press S/s to Shop");
            System.out.println("Press I/i to See your Inventory");
            System.out.println("Press D/d to See your Statistics");
            System.out.println("Press Q/q to Quit the Game");
            System.out.println("************************************************************************************************");
            userInput.getUserInput();
            if(userInput.checkInput("e")){
                // To check if hero is eligible for these actions or not
                if(hero.canEquipItem() || hero.canUnequipItem() || hero.canChangeItem()){
                    // Function to equip/unequip/change item
                    equipItem(hero);
                    break;
                }
                else{
                    System.out.println("You don't have enough Items in your Inventory\nPlease choose a different action");
                }
            }
            else if(userInput.checkInput("p")){
                // To check if hero is eligible for these actions or not
                if(hero.canDrinkPotion()){
                    // Function to drink potion
                    drinkPotion(hero);
                    break;
                }
                else{
                    System.out.println("You don't have enough Potions in your Inventory\nPlease choose a different action");
                }
            }
            else if(userInput.checkInput("m")){
                // Function to move Hero
                moveHero(hero, map);
                break;
            }
            else if(userInput.checkInput("t")){
                // Function to check teleporting can be done or not
                if(canTeleport(heroList, heroIndex, map)){
                    // Function to teleport to another lane
                    teleportLane(hero, heroList, map, heroIndex);
                    break;
                }
                else{
                    System.out.println("You can't teleport\nPlease try a different option");
                }
            }
            else if(userInput.checkInput("s")){
                // Function to do shopping
                shop(hero);
            }
            else if(userInput.checkInput("i")){
                hero.displayInventory();
            }
            else if(userInput.checkInput("d")){
                hero.displayStats();
            }
            else if(userInput.checkInput("q")){
                Legends.quit();
            }
            else{
                System.out.println("Invalid Input\nTry again");
            }
        }
    }

    // Function to display and perform actions availble in Cells close to Monster
    public void closeToMonsterCell(Hero hero, ArrayList<Roles> heroList, GridBoard map, int heroIndex){
        while(true){
            System.out.println("************************************************************************************************");
            System.out.println("You can choose to do any of the following:");
            System.out.println("Press E/e to Equip/Unequip/Change a Weapon/Armor");
            System.out.println("Press P/p to Drink a Potion");
            System.out.println("Press B/b to Fight the Monster");
            System.out.println("Press M/m to Move to another Cell");
            System.out.println("Press T/t to Teleport to another Lane");
            System.out.println("Press R/r to Recall to your Nexus");
            System.out.println("Press I/i to See your Inventory");
            System.out.println("Press D/d to See your Statistics");
            System.out.println("Press Q/q to Quit the Game");
            System.out.println("************************************************************************************************");
            userInput.getUserInput();
            if(userInput.checkInput("e")){
                // To check if hero is eligible for these actions or not
                if(hero.canEquipItem() || hero.canUnequipItem() || hero.canChangeItem()){
                    // Function to equip/unequip/change item
                    equipItem(hero);
                    break;
                }
                else{
                    System.out.println("You don't have enough Items in your Inventory\nPlease choose a different action");
                }
            }
            else if(userInput.checkInput("p")){
                // To check if hero is eligible for these actions or not
                if(hero.canDrinkPotion()){
                    // Function to drink potion
                    drinkPotion(hero);
                    break;
                }
                else{
                    System.out.println("You don't have enough Potions in your Inventory\nPlease choose a different action");
                }
            }
            else if(userInput.checkInput("b")){
                // Function to do battle
                beginBattleHero(hero, map);
                break;
            }
            else if(userInput.checkInput("m")){
                // Fuction to move hero
                moveHero(hero, map);
                break;
            }
            else if(userInput.checkInput("t")){
                // Function to check teleporting can be done or not
                if(canTeleport(heroList, heroIndex, map)){
                    // Function to teleport to another lane
                    teleportLane(hero, heroList, map, heroIndex);
                    break;
                }
                else{
                    System.out.println("You can't teleport\nPlease try a different option");
                }
            }
            else if(userInput.checkInput("r")){
                // Function to recall to your nexus
                recallNexus(hero, map);
                break;
            }
            else if(userInput.checkInput("i")){
                hero.displayInventory();
            }
            else if(userInput.checkInput("d")){
                hero.displayStats();;
            }
            else if(userInput.checkInput("q")){
                Legends.quit();
            }
            else{
                System.out.println("Invalid Input\nTry again");
            }
        }
    }

    public void anywhereElse(Hero hero, ArrayList<Roles> heroList, GridBoard map, int heroIndex){
        while(true){
            System.out.println("************************************************************************************************");
            System.out.println("You can choose to do any of the following:");
            System.out.println("Press E/e to Equip/Unequip/Change a Weapon/Armor");
            System.out.println("Press P/p to Drink a Potion");
            System.out.println("Press M/m to Move to another Cell");
            System.out.println("Press T/t to Teleport to another Lane");
            System.out.println("Press R/r to Recall to your Nexus");
            System.out.println("Press I/i to See your Inventory");
            System.out.println("Press D/d to See your Statistics");
            System.out.println("Press Q/q to Quit the Game");
            System.out.println("************************************************************************************************");
            userInput.getUserInput();
            if(userInput.checkInput("e")){
                // To check if hero is eligible for these actions or not
                if(hero.canEquipItem() || hero.canUnequipItem() || hero.canChangeItem()){
                    // Function to equip/unequip/change item
                    equipItem(hero);
                    break;
                }
                else{
                    System.out.println("You don't have enough Items in your Inventory\nPlease choose a different action");
                }
            }
            else if(userInput.checkInput("p")){
                // To check if hero is eligible for these actions or not
                if(hero.canDrinkPotion()){
                    // Function to drink potion
                    drinkPotion(hero);
                    break;
                }
                else{
                    System.out.println("You don't have enough Potions in your Inventory\nPlease choose a different action");
                }
            }
            else if(userInput.checkInput("m")){
                // Fuction to move hero
                moveHero(hero, map);
                break;
            }
            else if(userInput.checkInput("t")){
                // Function to check teleporting can be done or not
                if(canTeleport(heroList, heroIndex, map)){
                    // Function to teleport to another lane
                    teleportLane(hero, heroList, map, heroIndex);
                    break;
                }
                else{
                    System.out.println("You can't teleport\nPlease try a different option");
                }
            }
            else if(userInput.checkInput("r")){
                // Function to recall to your nexus
                recallNexus(hero, map);
                break;
            }
            else if(userInput.checkInput("i")){
                hero.displayInventory();
            }
            else if(userInput.checkInput("d")){
                hero.displayStats();;
            }
            else if(userInput.checkInput("q")){
                Legends.quit();
            }
            else{
                System.out.println("Invalid Input\nTry again");
            }
        }
    }

    // Function to equip/unequip/change item
    public void equipItem(Hero hero){
        while(true){
            System.out.println("************************************************************************************************");
            System.out.println("Press E/e if you want to Equip an Item");
            System.out.println("Press U/u if you want to unequip an Item");
            System.out.println("Press C/c if you want to Change an Item with another");
            System.out.println("Press Q/q if you want to Quit the Game");
            System.out.println("************************************************************************************************");
            userInput.getUserInput();
            if(userInput.checkInput("e")){
                if(hero.canEquipItem()){
                    hero.equipItem();
                    break;
                }
                else{
                    System.out.println("You don't have enough Items in your Inventory\nPlease choose a different option");
                }
            }
            else if(userInput.checkInput("u")){
                if(hero.canUnequipItem()){
                    hero.unequipItem();
                    break;
                }
                else{
                    System.out.println("You don't have enough Items in your Inventory\nPlease choose a different option");
                }
            }
            else if(userInput.checkInput("c")){
                if(hero.canChangeItem()){
                    hero.changeItem();
                    break;
                }
                else{
                    System.out.println("You don't have enough Items in your Inventory\nPlease choose a different option");
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

    // Function to drink potion
    public void drinkPotion(Hero hero){
        hero.potionUsed();
    }

    // Function check if hero is trying to move past the monster
    public Boolean checkMovePastMonster(int[] newLoc, Hero hero, GridBoard map){
        int[] heroLoc = hero.getLocation();
        ArrayList<Integer> monsterLoc = new ArrayList<Integer>();
        try{
            if(!(map.getGrid()[heroLoc[0] + 1][heroLoc[1]].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[heroLoc[0] + 1][heroLoc[1]]).getIsMonsterSlot()){
                    monsterLoc.add(heroLoc[0] + 1);
                }
            }
            if(!(map.getGrid()[heroLoc[0] + 1][heroLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[heroLoc[0] + 1][heroLoc[1] - 1]).getIsMonsterSlot()){
                    monsterLoc.add(heroLoc[0] + 1);
                }
            }
            if(!(map.getGrid()[heroLoc[0] + 1][heroLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[heroLoc[0] + 1][heroLoc[1] + 1]).getIsMonsterSlot()){
                    monsterLoc.add(heroLoc[0] + 1);
                }
            }
            if(!(map.getGrid()[heroLoc[0]][heroLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[heroLoc[0]][heroLoc[1] - 1]).getIsMonsterSlot()){
                    monsterLoc.add(heroLoc[0]);
                }
            }
            if(!(map.getGrid()[heroLoc[0]][heroLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
                if(((CellsWithRoles) map.getGrid()[heroLoc[0]][heroLoc[1] + 1]).getIsMonsterSlot()){
                    monsterLoc.add(heroLoc[0]);
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException exception) {
            return false;
        }
        int maxI = Collections.max(monsterLoc);
        if(newLoc[0] > maxI){
            return false;
        }
        else{
            return true;
        }
    }

    // Function to check if the move if valid or not
    public Boolean checkMove(int[] newLoc, Hero hero, GridBoard map){
        int hMax = map.getHeight();
        int hMin = 0;
        int wMax = map.getWidth();
        int wMin = 0;
        if(newLoc[0] < hMax && newLoc[0] >= hMin && newLoc[1] < wMax && newLoc[1] >= wMin){
            if(map.getGrid()[newLoc[0]][newLoc[1]].getCellName().equalsIgnoreCase("inaccessible")){
                return false;
            }
            else if(((CellsWithRoles) map.getGrid()[newLoc[0]][newLoc[1]]).getIsHeroSlot()){
                return false;
            }
            // Function check if hero is trying to move past the monster
            else if(checkMovePastMonster(newLoc, hero, map)){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

    // Function to move Hero
    public void moveHero(Hero hero, GridBoard map){
        while(true){
            System.out.println("************************************************************************************************");
            System.out.println("Controls:");
            System.out.println("Press W/w to Move up");
            System.out.println("Press A/a to Move left");
            System.out.println("Press S/s to Move down");
            System.out.println("Press D/d to Move right");
            System.out.println("Press Q/q to Quit the Game");
            System.out.println("************************************************************************************************");
            userInput.getUserInput();
            if(userInput.checkInput("w")){
                int[] newLoc = {hero.getLocation()[0] - 1, hero.getLocation()[1]}; 
                // Function to check if the move if valid or not
                if(checkMove(newLoc, hero, map)){
                    if((!(isNexus(hero, map)) && !(isPlain(hero, map)))){
                        ((CellsWithBonus) map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]]).resetHeroPowers(hero);
                    }
                    String cellValue = map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]].getCellValue();
                    ((CellsWithRoles) map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]]).resetHeroSlot();
                    hero.setLocation(newLoc);
                    ((CellsWithRoles) map.getGrid()[newLoc[0]][newLoc[1]]).setHeroSlot(hero);
                    map.getGrid()[newLoc[0]][newLoc[1]].setCellValue(cellValue);
                    if((!(isNexus(hero, map)) && !(isPlain(hero, map)))){
                        ((CellsWithBonus) map.getGrid()[newLoc[0]][newLoc[1]]).updateHeroPowers(hero);
                    }
                    break;
                }
                else{
                    System.out.println("Invalid Move\nTry Again");
                }
            }
            else if(userInput.checkInput("a")){
                int[] newLoc = {hero.getLocation()[0], hero.getLocation()[1] - 1}; 
                // Function to check if the move if valid or not
                if(checkMove(newLoc, hero, map)){
                    if((!(isNexus(hero, map)) && !(isPlain(hero, map)))){
                        ((CellsWithBonus) map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]]).resetHeroPowers(hero);
                    }
                    String cellValue = map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]].getCellValue();
                    ((CellsWithRoles) map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]]).resetHeroSlot();
                    hero.setLocation(newLoc);
                    ((CellsWithRoles) map.getGrid()[newLoc[0]][newLoc[1]]).setHeroSlot(hero);
                    map.getGrid()[newLoc[0]][newLoc[1]].setCellValue(cellValue);
                    if((!(isNexus(hero, map)) && !(isPlain(hero, map)))){
                        ((CellsWithBonus) map.getGrid()[newLoc[0]][newLoc[1]]).updateHeroPowers(hero);
                    }
                    break;
                }
                else{
                    System.out.println("Invalid Move\nTry Again");
                }
            }
            else if(userInput.checkInput("s")){
                int[] newLoc = {hero.getLocation()[0] + 1, hero.getLocation()[1]}; 
                // Function to check if the move if valid or not
                if(checkMove(newLoc, hero, map)){
                    if((!(isNexus(hero, map)) && !(isPlain(hero, map)))){
                        ((CellsWithBonus) map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]]).resetHeroPowers(hero);
                    }
                    String cellValue = map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]].getCellValue();
                    ((CellsWithRoles) map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]]).resetHeroSlot();
                    hero.setLocation(newLoc);
                    ((CellsWithRoles) map.getGrid()[newLoc[0]][newLoc[1]]).setHeroSlot(hero);
                    map.getGrid()[newLoc[0]][newLoc[1]].setCellValue(cellValue);
                    if((!(isNexus(hero, map)) && !(isPlain(hero, map)))){
                        ((CellsWithBonus) map.getGrid()[newLoc[0]][newLoc[1]]).updateHeroPowers(hero);
                    }
                    break;
                }
                else{
                    System.out.println("Invalid Move\nTry Again");
                }
            }
            else if(userInput.checkInput("d")){
                int[] newLoc = {hero.getLocation()[0], hero.getLocation()[1] + 1}; 
                // Function to check if the move if valid or not
                if(checkMove(newLoc, hero, map)){
                    if((!(isNexus(hero, map)) && !(isPlain(hero, map)))){
                        ((CellsWithBonus) map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]]).resetHeroPowers(hero);
                    }
                    String cellValue = map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]].getCellValue();
                    ((CellsWithRoles) map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]]).resetHeroSlot();
                    hero.setLocation(newLoc);
                    ((CellsWithRoles) map.getGrid()[newLoc[0]][newLoc[1]]).setHeroSlot(hero);
                    map.getGrid()[newLoc[0]][newLoc[1]].setCellValue(cellValue);
                    if((!(isNexus(hero, map)) && !(isPlain(hero, map)))){
                        ((CellsWithBonus) map.getGrid()[newLoc[0]][newLoc[1]]).updateHeroPowers(hero);
                    }
                    break;
                }
                else{
                    System.out.println("Invalid Move\nTry Again");
                }
            }
            else if(userInput.checkInput("q")){
                Legends.quit();
            }
            else{
                System.out.println("Invalid Input\nTry again");
            }
        }
        System.out.println("************************************************************************************************");
        map.displayBoard();
    }

    // Function to get teleport loactions
    public int[] getTeleportLoc(Hero targetHero, GridBoard map){
        int[] heroLoc = new int[2];
        heroLoc[0] = targetHero.getLocation()[0];
        heroLoc[1] = targetHero.getLocation()[1] - 1;
        if(checkMove(heroLoc, targetHero, map)){
            return heroLoc;
        }
        int[] heroLoc1 = new int[2];
        heroLoc1[0] = targetHero.getLocation()[0];
        heroLoc1[1] = targetHero.getLocation()[1] + 1;
        if(checkMove(heroLoc1, targetHero, map)){
            return heroLoc1;
        }
        int[] heroLoc2 = new int[2];
        heroLoc2[0] = targetHero.getLocation()[0] + 1;
        heroLoc2[1] = targetHero.getLocation()[1];
        if(checkMove(heroLoc2, targetHero, map)){
            return heroLoc2;
        }
        else{
            return null;
        }

    }

    // Function to teleport to another lane
    public void teleportLane(Hero hero, ArrayList<Roles> heroList, GridBoard map, int heroIndex){
        int index = -1;
        while(true){
            System.out.println("************************************************************************************************");
            System.out.println("Enter the Target Hero Index(Eg: 1, 2, 3):");
            System.out.println("************************************************************************************************");
            userInput.getUserInput();
            if(userInput.checkInput("1")){
                index = 0;
                if(index == heroIndex - 1){
                    System.out.println("You can't teleport to your own lane\nPlease try a different option");
                }
                else if(isNexus((Hero) heroList.get(index), map)){
                    System.out.println("You can't teleport to another Hero's Nexus\nPlease try a different option");
                }
                else{
                    break;
                }
            }
            else if(userInput.checkInput("2")){
                index = 1;
                if(index == heroIndex - 1){
                    System.out.println("You can't teleport to your own lane\nPlease try a different option");
                }
                else if(isNexus((Hero) heroList.get(index), map)){
                    System.out.println("You can't teleport to another Hero's Nexus\nPlease try a different option");
                }
                else{
                    break;
                }
            }
            else if(userInput.checkInput("3")){
                index = 2;
                if(index == heroIndex - 1){
                    System.out.println("You can't teleport to your own lane\nPlease try a different option");
                }
                else if(isNexus((Hero) heroList.get(index), map)){
                    System.out.println("You can't teleport to another Hero's Nexus\nPlease try a different option");
                }
                else{
                    break;
                }
            }
            else{
                System.out.println("Invalid Input\nTry again");
            }
        }
        Hero targetHero = (Hero) heroList.get(index);
        // Function to get teleport loactions
        int[] teleportLoc = getTeleportLoc(targetHero, map);
        String cellValue = map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]].getCellValue();
        ((CellsWithRoles) map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]]).resetHeroSlot();
        hero.setLocation(teleportLoc);
        ((CellsWithRoles) map.getGrid()[teleportLoc[0]][teleportLoc[1]]).setHeroSlot(hero);
        map.getGrid()[teleportLoc[0]][teleportLoc[1]].setCellValue(cellValue);
        System.out.println("************************************************************************************************");
        map.displayBoard();
        System.out.println("************************************************************************************************");
    }

    // Function to do shopping
    public void shop(Hero hero){
        //Creating the Market Object
        Market mkt = new Market(hero);

        // Function ton start shopping
        mkt.beginShopping(hero);
    }

    public Hero getInRangeHero(Monster monster, GridBoard map){
        int[] monsLoc = monster.getLocation();
        if(monsLoc[0] - 1 > -1 && !(map.getGrid()[monsLoc[0] - 1][monsLoc[1]].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[monsLoc[0] - 1][monsLoc[1]]).getIsHeroSlot()){
                return ((CellsWithRoles) map.getGrid()[monsLoc[0] - 1][monsLoc[1]]).getHeroSlot();
            }
        }
        else if(monsLoc[0] - 1 > -1 && monsLoc[1] - 1 > -1 && !(map.getGrid()[monsLoc[0] - 1][monsLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[monsLoc[0] - 1][monsLoc[1] - 1]).getIsHeroSlot()){
                return ((CellsWithRoles) map.getGrid()[monsLoc[0] - 1][monsLoc[1] - 1]).getHeroSlot();
            }
        }
        else if(monsLoc[0] - 1 > -1 && monsLoc[1] + 1 < 8 && !(map.getGrid()[monsLoc[0] - 1][monsLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[monsLoc[0] - 1][monsLoc[1] + 1]).getIsHeroSlot()){
                return ((CellsWithRoles) map.getGrid()[monsLoc[0] - 1][monsLoc[1] + 1]).getHeroSlot();
            }
        }
        else if(monsLoc[0] + 1 < 8 && !(map.getGrid()[monsLoc[0] + 1][monsLoc[1]].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[monsLoc[0] + 1][monsLoc[1]]).getIsHeroSlot()){
                return ((CellsWithRoles) map.getGrid()[monsLoc[0] + 1][monsLoc[1]]).getHeroSlot();
            }
        }
        else if(monsLoc[0] + 1 < 8 && monsLoc[1] - 1 > -1 && !(map.getGrid()[monsLoc[0] + 1][monsLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[monsLoc[0] + 1][monsLoc[1] - 1]).getIsHeroSlot()){
                return ((CellsWithRoles) map.getGrid()[monsLoc[0] + 1][monsLoc[1] - 1]).getHeroSlot();
            }
        }
        else if(monsLoc[0] + 1 < 8 && monsLoc[1] + 1 < 8 && !(map.getGrid()[monsLoc[0] + 1][monsLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[monsLoc[0] + 1][monsLoc[1] + 1]).getIsHeroSlot()){
                return ((CellsWithRoles) map.getGrid()[monsLoc[0] + 1][monsLoc[1] + 1]).getHeroSlot();
            }
        }
        else if(monsLoc[1] - 1 > -1 && !(map.getGrid()[monsLoc[0]][monsLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[monsLoc[0]][monsLoc[1] - 1]).getIsHeroSlot()){
                return ((CellsWithRoles) map.getGrid()[monsLoc[0]][monsLoc[1] - 1]).getHeroSlot();
            }
        }
        else if(monsLoc[1] + 1 < 8 && !(map.getGrid()[monsLoc[0]][monsLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[monsLoc[0]][monsLoc[1] + 1]).getIsHeroSlot()){
                return ((CellsWithRoles) map.getGrid()[monsLoc[0]][monsLoc[1] + 1]).getHeroSlot();
            }
        }
        return null;
    }

    public ArrayList<Monster> getInRangeMonsters(Hero hero, GridBoard map){
        int[] heroLoc = hero.getLocation();
        ArrayList<Monster> monsList = new ArrayList<Monster>();
        if(heroLoc[0] - 1 > -1 && !(map.getGrid()[heroLoc[0] - 1][heroLoc[1]].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[heroLoc[0] - 1][heroLoc[1]]).getIsMonsterSlot()){
                monsList.add(((CellsWithRoles) map.getGrid()[heroLoc[0] - 1][heroLoc[1]]).getMonsterSlot());
            }
        }
         if(heroLoc[0] - 1 > -1 && heroLoc[1] - 1 > -1 && !(map.getGrid()[heroLoc[0] - 1][heroLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[heroLoc[0] - 1][heroLoc[1] - 1]).getIsMonsterSlot()){
                monsList.add(((CellsWithRoles) map.getGrid()[heroLoc[0] - 1][heroLoc[1] - 1]).getMonsterSlot());
            }
        }
         if(heroLoc[0] - 1 > -1 && heroLoc[1] + 1 < 8 && !(map.getGrid()[heroLoc[0] - 1][heroLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[heroLoc[0] - 1][heroLoc[1] + 1]).getIsMonsterSlot()){
                monsList.add(((CellsWithRoles) map.getGrid()[heroLoc[0] - 1][heroLoc[1] + 1]).getMonsterSlot());
            }
        }
         if(heroLoc[0] + 1 < 8 && !(map.getGrid()[heroLoc[0] + 1][heroLoc[1]].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[heroLoc[0] + 1][heroLoc[1]]).getIsMonsterSlot()){
                monsList.add(((CellsWithRoles) map.getGrid()[heroLoc[0] + 1][heroLoc[1]]).getMonsterSlot());
            }
        }
         if(heroLoc[0] + 1 < 8 && heroLoc[1] - 1 > -1 && !(map.getGrid()[heroLoc[0] + 1][heroLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[heroLoc[0] + 1][heroLoc[1] - 1]).getIsMonsterSlot()){
                monsList.add(((CellsWithRoles) map.getGrid()[heroLoc[0] + 1][heroLoc[1] - 1]).getMonsterSlot());
            }
        }
        else if(heroLoc[0] + 1 < 8 && heroLoc[1] + 1 < 8 && !(map.getGrid()[heroLoc[0] + 1][heroLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[heroLoc[0] + 1][heroLoc[1] + 1]).getIsMonsterSlot()){
                monsList.add(((CellsWithRoles) map.getGrid()[heroLoc[0] + 1][heroLoc[1] + 1]).getMonsterSlot());
            }
        }
         if(heroLoc[1] - 1 > -1 && !(map.getGrid()[heroLoc[0]][heroLoc[1] - 1].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[heroLoc[0]][heroLoc[1] - 1]).getIsMonsterSlot()){
                monsList.add(((CellsWithRoles) map.getGrid()[heroLoc[0]][heroLoc[1] - 1]).getMonsterSlot());
            }
        }
         if(heroLoc[1] + 1 < 8 && !(map.getGrid()[heroLoc[0]][heroLoc[1] + 1].getCellName().equalsIgnoreCase("inaccessible"))){
            if(((CellsWithRoles) map.getGrid()[heroLoc[0]][heroLoc[1] + 1]).getIsMonsterSlot()){
                monsList.add(((CellsWithRoles) map.getGrid()[heroLoc[0]][heroLoc[1] + 1]).getMonsterSlot());
            }
        }
        return monsList;
    }


    // Function to do battle for monster
    public void beginBattleMonster(Monster monster, GridBoard map){
        Battle battle = new Battle();

        Hero hero = getInRangeHero(monster, map);

        //battle.monsterAttack(monster, hero);
    }

    // Function to do battle for hero
    public void beginBattleHero(Hero hero, GridBoard map){
        Battle battle = new Battle();
        
        ArrayList<Monster> monsterList = getInRangeMonsters(hero, map);

        //battle.heroAttack(hero, monsterList);
    }

    // Function to recall to your nexus
    public void recallNexus(Hero hero, GridBoard map){
        if(hero.getLane() == 1){
            int[] newLoc = {7,0};
            String cellValue = map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]].getCellValue();
            ((CellsWithRoles) map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]]).resetHeroSlot();
            hero.setLocation(newLoc);
            ((CellsWithRoles) map.getGrid()[newLoc[0]][newLoc[1]]).setHeroSlot(hero);
            map.getGrid()[newLoc[0]][newLoc[1]].setCellValue(cellValue);
        }
        else if(hero.getLane() == 2){
            int[] newLoc = {7,3};
            String cellValue = map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]].getCellValue();
            ((CellsWithRoles) map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]]).resetHeroSlot();
            hero.setLocation(newLoc);
            ((CellsWithRoles) map.getGrid()[newLoc[0]][newLoc[1]]).setHeroSlot(hero);
            map.getGrid()[newLoc[0]][newLoc[1]].setCellValue(cellValue);
        }
        else if(hero.getLane() == 3){
            int[] newLoc = {7,6};
            String cellValue = map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]].getCellValue();
            ((CellsWithRoles) map.getGrid()[hero.getLocation()[0]][hero.getLocation()[1]]).resetHeroSlot();
            hero.setLocation(newLoc);
            ((CellsWithRoles) map.getGrid()[newLoc[0]][newLoc[1]]).setHeroSlot(hero);
            map.getGrid()[newLoc[0]][newLoc[1]].setCellValue(cellValue);
        }
        map.displayBoard();
    }

}