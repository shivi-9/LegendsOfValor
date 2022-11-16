package LegendsCode;
import java.util.*;

/* This is the class for the Legends game.
 * It has all the attributes and methods related to Legends game.*/
public class Legends extends RolePlayingGame implements Game{
    // To ensure only one instance of this game can be created at a time
    private static Legends gameInstance = new Legends(); 
    private Scanner userInput = new Scanner(System.in);
    private Random random = new Random();

    // Implementing the singleton design pattern
    private Legends(){}

    // Function to return the single instance of this class
    public static Legends getInstance(){
        return gameInstance;
    }
    
    // Function to display the Welcome Screen
    public int displayWelcomeScreen(){
        System.out.println("************************************************");
        System.out.println("Welcome to world of Monsters and Legend");
        System.out.println("1. Start the Game\n2. See the Instructions\n3. Quit");
        System.out.println("************************************************");
        System.out.println("Enter your choice:");
        int userResponse;
        while(true){
            try{
                userResponse = Integer.parseInt(userInput.nextLine());
                if(userResponse==1 || userResponse==2 || userResponse == 3){
                    break;
                }
                else{
                    System.out.println("Please choose from the above options only\nLet's try again");
                }
            }
            catch(Exception e){
                System.out.println("Invalid Input\nLet's try again");
            }
        }
        return userResponse;
    }

    // Function to display Instructions of the game to the user
    public void displayInstructions(){ 
        System.out.println("************************************************");
        System.out.println("Monsters & heroes live in a fictional world.");
        System.out.println("They do not get along and fight each other.");
        System.out.println("If heroes win, they gain experience and money.");
        System.out.print("Heroes use the money to buy a variety of items,");
        System.out.println(" to aid them in their battles with the monsters.");
        System.out.print("When they get enough experience they level up,");
        System.out.println(" which improves their skills.");
        System.out.print("The goal of the game is for the heroes to");
        System.out.println(" defeat monsters and level up indefinitely");
        System.out.println("***********************************************");
        System.out.println("Controls:\nW/w: Move up\nA/a: Move left");
        System.out.println("S/s: Move down\nD/d: Move right");
        System.out.println("Q/q: Quit the game\nI/i: See instructions");
        System.out.println("M/m: Enter market\nN/n: Check inventory");
        System.out.println("***********************************************");
        System.out.println("Press Q/q to quit or any other key to go back");
        String userResponse = userInput.nextLine();
        if(userResponse.equals("Q") || userResponse.equals("q")){
            System.exit(0);
        }
    }

    //Function to take input of boardSize
    public int input_boardSize(){
        while(true){
            System.out.println("Enter the size of your Map:(Limit 4-8)");
            try{
                int userResponse = Integer.parseInt(userInput.nextLine());
                if(userResponse < 4 || userResponse > 8){
                    System.out.println("Please enter within the limit\nLet's try again");
                }
                else{
                    return userResponse;
                }
            }
            catch(Exception e){
                System.out.println("Invalid Input\nLet's try again");
            }
        }    
    }

    // Function to set the Map's cells
    public GridBoard set_BoardCells(GridBoard map){
        int totalCells = map.getHeight() * map.getWidth();
        int counter = totalCells;

        while(counter != 0){
            for(int i = 0; i < ((int) Math.round(0.2 * totalCells)); i++){
                int randomHeight = random.nextInt(map.getHeight() - 1) + 1;
                int randomWidth = random.nextInt(map.getWidth() - 1) + 1; 
                if(map.getGrid()[randomHeight][randomWidth].getCellName().equals(" ")){
                    counter --;
                    map.getGrid()[randomHeight][randomWidth].setCellName("inaccessible");
                    map.getGrid()[randomHeight][randomWidth].setCellValue("I");
                }
            }
            for(int i = 0; i < ((int) Math.round(0.3 * totalCells)); i++){
                int randomHeight = random.nextInt(map.getHeight());
                int randomWidth = random.nextInt(map.getWidth()); 
                if(map.getGrid()[randomHeight][randomWidth].getCellName().equals(" ")){
                    counter --;
                    map.getGrid()[randomHeight][randomWidth].setCellName("market");
                    map.getGrid()[randomHeight][randomWidth].setCellValue("M");
                }
            }
            for(int i = 0; i < ((int) Math.round(0.5 * totalCells)); i++){
                int randomHeight = random.nextInt(map.getHeight());
                int randomWidth = random.nextInt(map.getWidth()); 
                if(map.getGrid()[randomHeight][randomWidth].getCellName().equals(" ")){
                    counter --;
                    map.getGrid()[randomHeight][randomWidth].setCellName("common");
                    map.getGrid()[randomHeight][randomWidth].setCellValue(" ");
                }
            }
        }

        map.getGrid()[0][0].setCellName("common");
        map.getGrid()[0][0].setCellValue("O");

        return map;
    }

    // Function to initialise board
    public GridBoard initBoard(){
        GridBoard map = new GridBoard();
        
        // Function to take input and set Map's size
        map.set_boardSize(input_boardSize());

        // Calling the function to create Map's cells
        map.createBoardCells();

        // Function to set the Map's cells
        map = set_BoardCells(map);

        return map;
    }

    // Function to display Map instructions
    public void displayBoardInstructions(){
        System.out.println("O: Current Position of Hero Party");
        System.out.println("M: Market Place");
        System.out.println("I: Inaccessible Place");
    }

    // Function to input number of heros
    public int input_totalHeroes(){
        int ret = 0;
        while(true){
            System.out.println("Enter the number of Heros you want (Limit 2-5):");
            try{
                int userResponse = Integer.parseInt(userInput.nextLine());
                if(userResponse >= 2 && userResponse <= 5){
                    ret = userResponse;
                    break;
                }
                else{
                    System.out.println("Invalid Input\nLet's try again");
                }
            }
            catch(Exception e){
                System.out.println("Invalid Input\nLet's try again");
            }
        }
        return ret;
    }

    // Function to create heros
    public ArrayList<Roles> createHero(){
        // Function to input number of heros
        int totalHeroes = input_totalHeroes();

        HeroFactory hFactory = new HeroFactory();
        // Function to display all the heros to choose from
        System.out.println("************************************************");
        hFactory.displayHeroList();
        System.out.println("************************************************");

        //Array list of Heros
        ArrayList<Roles> heroList= new ArrayList<Roles>();
        
        System.out.println("Enter the index of Hero you want:(Format: 1.1)");
        for(int i = 0; i < totalHeroes; i++){
            while(true){
                try{
                    String userResponse = userInput.nextLine();
                    String[] parts = userResponse.split("\\.");
                    if(parts.length > 2){
                        System.out.println("Invalid Input Format\nTry again");
                    }
                    else if(Integer.parseInt(parts[0]) > 3 || Integer.parseInt(parts[0]) < 1 || Integer.parseInt(parts[1]) < 1 || Integer.parseInt(parts[1]) > 6){
                        System.out.println("Please choose from the above options only\nTry again");
                    }
                    else{
                        heroList.add((Hero) hFactory.getHero(parts[0],parts[1]));
                        break;
                    }
                }
                catch(Exception e){
                    System.out.println("Invalid Input\nTry again");
                }
            }
        }

        return heroList;
    }

    // Function to print list of chosen heroes
    public void displayHeroList(ArrayList<Roles> heroList){
        System.out.println("You have chosen the following Heroes:");
        for(int i =0; i < heroList.size(); i++){
            System.out.println(i+1 + ". " + heroList.get(i).getName());
        }
    }

    // Function to check if the move is valid or not
    public Boolean checkMove(GridBoard map, int[] index){
        int hMax = map.getHeight();
        int hMin = 0;
        int wMax = map.getWidth();
        int wMin = 0;
        if(index[0] < hMax && index[0] >= hMin && index[1] < wMax && index[1] >= wMin){
            if(map.getGrid()[index[0]][index[1]].getCellName().equals("inaccessible")){
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

    // Function to display instruction to move/play
    public void displayMoveInstructions(){
        System.out.println("***********************************************");
        System.out.println("Controls:\nW/w: Move up\nA/a: Move left");
        System.out.println("S/s: Move down\nD/d: Move right");
        System.out.println("Q/q: Quit the game\nI/i: See instructions");
        System.out.println("M/m: Enter market\nN/n: Check inventory");
        System.out.println("***********************************************");
        System.out.println("Press Q/q to quit or any other key to go back");
        String userResponse = userInput.nextLine();
        if(userResponse.equalsIgnoreCase("q")){
            System.exit(0);
        }
    }

    // Function to input the next location of hero party
    public int[] nextMove(GridBoard map, int[] currentLoc){
        while(true){
            System.out.println("Press I/i for Instructions\nPress P/p to see the Map\nPress Q/q to Quit\nEnter your next move:");
            String move = userInput.nextLine();
            if(move.equalsIgnoreCase("i")){
                // Function to display instruction to move/play
                displayMoveInstructions();
            }
            else if(move.equalsIgnoreCase("q")){
                System.exit(0);
            }
            else if(move.equalsIgnoreCase("p")){
                System.out.println("************************************************");
                map.displayBoard();
                System.out.println("************************************************");
            }
            else if(move.equalsIgnoreCase("w")){
                currentLoc[0] = currentLoc[0]-1;
                break;
            }
            else if(move.equalsIgnoreCase("a")){
                currentLoc[1] = currentLoc[1]-1;
                break;
            }
            else if(move.equalsIgnoreCase("s")){
                currentLoc[0] = currentLoc[0]+1;
                break;
            }
            else if(move.equalsIgnoreCase("d")){
                currentLoc[1] = currentLoc[1]+1;
                break;
            }
            else{
                System.out.println("Invalid Input\nTry again");
            }
        }
        return currentLoc;
    }

    // Function to display the welcome screen when hero party enters the market
    public void marketWelcomeScreen(){
        System.out.println("***WELCOME TO THE MARKET***");
        System.out.println("You can buy or sell items here");
        System.out.println("Each hero will get the chance to shop individually");
        System.out.println("Let's begin shopping");
        System.out.println("Press Q/q to exit the game");
        System.out.println("Press any other key to begin shopping");
        String userResponse = userInput.nextLine();
        if( userResponse.equalsIgnoreCase("q")){
            System.exit(0);
        }
    }
    
    // Function to ask hero if they wanna enter the market or not
    public Boolean isEnter(Roles roles){
        while(true){
            System.out.println(roles.getName());
            System.out.println("Press M/m to enter the market");
            System.out.println("Press Q/q to quit");
            System.out.println("Press N/n to not enter the market");
            String userResponse = userInput.nextLine();
            if(userResponse.equalsIgnoreCase("q")){
                System.exit(0);
            }
            else if(userResponse.equalsIgnoreCase("m")){
                return true;
            }
            else if(userResponse.equalsIgnoreCase("n")){
                return false;
            }
            else{
                System.out.println("Invalid Input\nTry Again");
            }
        }
    }

    // Function to ask hero if they wanna buy/sell anything
    public String buyOrSell(Roles hero){
        while(true){
            System.out.println("Press S/s to sale");
            System.out.println("Press B/b to buy");
            System.out.println("Press Q/q to quit");
            System.out.println("Press S/s to see your Statistics");
            System.out.println("Press E/e to exit market");
            String userResponse = userInput.nextLine();
            if(userResponse.equalsIgnoreCase("s")){
                return "s";
            }
            else if(userResponse.equalsIgnoreCase("b")){
                return "b";
            }
            else if(userResponse.equalsIgnoreCase("e")){
                return "e";
            }
            else if(userResponse.equalsIgnoreCase("q")){
                System.exit(0);
            }
            else if(userResponse.equalsIgnoreCase("s")){
                hero.displayStats();
            }
            else{
                System.out.println("Invalid Input\nTry Again");
            }
        }
    }         

    // Function to check if the item is available in market or not
    public Boolean checkItemBuy(String item, Market mkt){
        for(int i = 0; i < mkt.getMarketItems().size(); i++){
            if(item.equalsIgnoreCase(mkt.getMarketItems().get(i).getName())){
                return true;
            }
        }
        return false;
    }

    // Function to retrive the item object using the name of the item
    public Items get_itemBuy(String itemName, Market mkt){
        for(int i = 0; i < mkt.getMarketItems().size(); i++){
            if(itemName.equalsIgnoreCase(mkt.getMarketItems().get(i).getName())){
                return mkt.getMarketItems().get(i);
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

    // Function to input item to buy
    public Items inputItemBuy(Roles roles, Market mkt){
        while(true){
            System.out.println("Press Q/q to quit");
            System.out.println("Press B/b to go back to previous menu");
            System.out.println("Enter the name of the Item you want to buy:");
            String userResponse = userInput.nextLine();
            
            if(userResponse.equalsIgnoreCase("q")){
                System.exit(0);
            }

            else if(userResponse.equalsIgnoreCase("b")){
                break;
            }

            else{
                // Function to check if the item is available in market or not
                Boolean checkItemBuy = checkItemBuy(userResponse, mkt);

                if(checkItemBuy){
                    // Function to retrive the item object using the name of the item
                    Items itemBuy = get_itemBuy(userResponse, mkt);

                    // Function to check if hero has enough gold
                    Boolean checkGold = checkGoldnLevel(roles, itemBuy);

                    if(checkGold){
                        return itemBuy;
                    }
                    else{
                        System.out.println("You don't have enough gold or experience\nPlease try buying something else");
                    }
                }
                else{
                    System.out.println("The item is not available in the market\nTry buying some other item");
                    mkt.displayMarket();
                }
            }
        }
        return null;
    }

    // Function to ask if the hero wants to shop more
    public Boolean continueShopping(){
        while(true){
            System.out.println("Press S/s to continue shopping");
            System.out.println("Press B/b to leave the market");
            System.out.println("Press Q/q to Quit");
            String userResponse = userInput.nextLine();
            if(userResponse.equalsIgnoreCase("s")){
                return true;
            }
            else if(userResponse.equalsIgnoreCase("b")){
                return false;
            }
            else if(userResponse.equalsIgnoreCase("q")){
                System.exit(0);
            }
            else{
                System.out.println("Invalid Input\nTry again");
            }
        }
    }

    // Function to check if hero has any item in their inventory or not
    public Boolean isInventory(Roles roles){
        if(((Hero) roles).getArmorList().size() > 0 || ((Hero) roles).getPotionList().size() > 0 || ((Hero) roles).getSpellList().size() > 0 || ((Hero) roles).getWeaponList().size() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    // Function to check if market has enough gold
    public Boolean checkGoldMkt(Market mkt, Items itemBuy){
        if(mkt.getGold() > 0.1 * itemBuy.getCost()){
            return true;
        }
        else{
            return false;
        }
    }

    // Function to input item to sell
    public Items inputItemSell(Roles roles, Market mkt){
        while(true){
            System.out.println("YOU WILL ONLY GET 90% VALUE OF THE ITEM'S COST");
            System.out.println("Press Q/q to quit");
            System.out.println("Press B/b to go back to previous menu");
            System.out.println("Press I/i to see your inventory");
            System.out.println("Enter the name of the Item you want to sell:");
            String userResponse = userInput.nextLine();
            
            if(userResponse.equalsIgnoreCase("q")){
                System.exit(0);
            }

            else if(userResponse.equalsIgnoreCase("b")){
                break;
            }

            else if(userResponse.equalsIgnoreCase("i")){
                // Function to display inventory
                ((Hero) roles).displayInventory();
            }

            else{
                // Function to retrive the item object using the name of the item
                    Items itemBuy = get_itemBuy(userResponse, mkt);

                    // Function to check if market has enough gold

                    if(checkGoldMkt(mkt, itemBuy)){
                        return itemBuy;
                    }
                    else{
                        System.out.println("Market doesn't have enough gold\nPlease try buying something else");
                    }
            }
        }
        return null;
    }

    // function to equip or unequip items
    public void askEquipUnequip(ArrayList<Roles> heroList){
        for(int i = 0; i < heroList.size(); i++){
            while(true){
                System.out.println("************************************************");
                System.out.println(heroList.get(i).getName());
                System.out.println("Press E/e to equip a weapon");
                System.out.println("Press U/u to unequip a weapon");
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

    // Ask if hero paty wants to equip or unequip
    public Boolean isEquipUnEquip(){
        while(true){
            System.out.println("************************************************");
            System.out.println("Press Y/y if hero party wants to equip or unequip items");
            System.out.println("Press N/n if hero party does NOT wants to equip or unequip items");
            String userResponse = userInput.nextLine();
            if(userResponse.equalsIgnoreCase("y")){
                return true;
            }
            else if(userResponse.equalsIgnoreCase("n")){
                return false;
            }
            else{
                System.out.println("Invalid Input\nTry again");
            }
        }
    }

    // Function to handle the game
    public void letsPlay(){
        Boolean keepPlaying = true;
        while(keepPlaying){
            // Function to display the Welcome Screen
            int userResponse = displayWelcomeScreen();
            if(userResponse == 1){
                System.out.println("************************************************");
                System.out.println("Good choice!");
                System.out.println("Let's begin your adventure now");
                System.out.println("************************************************");

                // Function to initialise the Map
                GridBoard map = initBoard();

                int[] heroPartyLoc = {0,0};
                
                // Calling the function to display the board
                System.out.println("************************************************");
                map.displayBoard();

                // Function to display Map instructions
                displayBoardInstructions();
                System.out.println("************************************************");


                // Function to creating Hero
                ArrayList<Roles> heroList = createHero();

                // Printing the list of hero
                System.out.println("************************************************");
                displayHeroList(heroList);
                System.out.println("************************************************");

                System.out.println("Let's explore the land of Legends now");
                System.out.println("************************************************");
                map.displayBoard();

                Boolean mapExplore = true;
                while(mapExplore){
                    while(true){
                        int[] new_heroPartyLoc = new int[2];
                        int[] temp = new int[2];
                        for(int i = 0; i < heroPartyLoc.length; i++){
                            new_heroPartyLoc[i] = heroPartyLoc[i];
                            temp[i] = heroPartyLoc[i];
                        }

                        // Function to input the next location of hero party
                        new_heroPartyLoc = nextMove(map, temp);

                        //Function to check if the validity of the move
                        if(checkMove(map, new_heroPartyLoc)){
                            // Moving the hero party out of the current location
                            String cellValue = (map.getGrid()[heroPartyLoc[0]][heroPartyLoc[1]].getCellName().equalsIgnoreCase("common")) ? " " : "M"; 
                            map.updateBoard(map.getGrid()[heroPartyLoc[0]][heroPartyLoc[1]].getCellName(), cellValue, heroPartyLoc);
                            
                            // Moving the hero party into the new location
                            map.updateBoard(map.getGrid()[new_heroPartyLoc[0]][new_heroPartyLoc[1]].getCellName(), "O", new_heroPartyLoc);
                            
                            for(int i = 0; i < heroPartyLoc.length; i++){
                                heroPartyLoc[i] = new_heroPartyLoc[i];
                            }
                            break;
                        }
                        else{
                            System.out.println("Invalid Input\nTry again");
                        }
                    }

                    // Calling the function to display the updated board
                    System.out.println("************************************************");
                    map.displayBoard();
                    displayBoardInstructions();
                    System.out.println("************************************************");

                    // Ask if hero paty wants to equip or unequip
                    if(isEquipUnEquip()){
                        askEquipUnequip(heroList);
                    }

                    // checking if the current position of hero party is market or common space
                    if(map.getGrid()[heroPartyLoc[0]][heroPartyLoc[1]].getCellName().equalsIgnoreCase("market")){
                        // Function to display the welcome screen of market
                        marketWelcomeScreen();

                        //Creating the Market Object
                        Market mkt = new Market();
                        
                        for(int i = 0; i < heroList.size(); i++){
                            // Function to ask hero if they wanna enter the market or not
                            Boolean isEnter = isEnter(heroList.get(i));
                            if(isEnter){
                                // Function to display items on sale
                                // mkt.displayMarket();

                                Boolean continueShopping = true;
                                while(continueShopping){

                                    // Function to display items on sale
                                    mkt.displayMarket();

                                    // Function to ask hero if they wanna buy/sell anything
                                    String buyOrSell = buyOrSell(heroList.get(i));

                                    // Calling appropriate functions for shopping
                                    if(buyOrSell.equalsIgnoreCase("b")){
                                        // Function to input item to buy
                                        Items itemBuy = inputItemBuy(heroList.get(i), mkt);

                                        if(itemBuy != null){
                                            // Function to add the item to hero's inventory
                                            ((Hero) heroList.get(i)).set_inventory(itemBuy);

                                            // Function to remove the item from market
                                            mkt.remove_marketItems(itemBuy);
                                        }

                                        // Function to ask if the hero wants to shop more
                                        continueShopping = continueShopping();
                                    }
                                    else if(buyOrSell.equalsIgnoreCase("s")){
                                        // Function to check if hero has any item in their inventory or not
                                        if(isInventory(heroList.get(i))){
                                            // Function to input item to sell
                                            Items itemSell = inputItemSell(heroList.get(i), mkt);

                                            if(itemSell != null){
                                                // Function to add the item to hero's inventory
                                                ((Hero) heroList.get(i)).remove_inventory(itemSell);

                                                // Function to remove the item from market
                                                mkt.add_marketItems(itemSell);
                                            }
                                        }
                                        else{
                                            System.out.println("You do not have any items in your inventory\nPlease buy items first");
                                        }

                                        // Function to ask if the hero wants to shop more
                                        continueShopping = continueShopping();
                                    }
                                    else if(buyOrSell.equalsIgnoreCase("e")){
                                        continueShopping = false;
                                    }
                                }
                            }
                        }
                    }
                    else if(map.getGrid()[heroPartyLoc[0]][heroPartyLoc[1]].getCellName().equalsIgnoreCase("common")){
                        int isBattle = random.nextInt(2);
                        if(isBattle == 1){
                            // Initiating the battle class
                            Battle thisBattle = new Battle();

                            // Function to create monsters
                            thisBattle.letsFight(heroList);
                        }
                    }
                }

                
                
            }
            else if(userResponse == 2){
                // Function to display Instructions of the game to the user
                displayInstructions();
            }
            else if(userResponse == 3){
                keepPlaying = false;
            }
        }
    }

}
