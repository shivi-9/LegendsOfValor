package LegendsCode;
import java.util.*;

/* This is the class for the Legends game.
 * It has all the attributes and methods related to Legends game.*/
public class Legends extends RolePlayingGame implements Game{
    // To ensure only one instance of this game can be created at a time
    private static Legends gameInstance = new Legends();
    private Random random = new Random();
    private UserInput userInput = new UserInput();

    // Implementing the singleton design pattern
    private Legends(){}

    // Function to return the single instance of this class
    public static Legends getInstance(){
        return gameInstance;
    }
    
    // Function to display the Welcome Screen
    // @Override
    public String displayWelcomeScreen(){
        System.out.println("************************************************************************************************");
        try {
            while(true){
                System.out.print("W");
                Thread.sleep(100);
                System.out.print("E");
                Thread.sleep(100);
                System.out.print("L");
                Thread.sleep(100);
                System.out.print("C");
                Thread.sleep(100);
                System.out.print("O");
                Thread.sleep(100);
                System.out.print("M");
                Thread.sleep(100);
                System.out.print("E");
                Thread.sleep(100);
                System.out.print("!");
                Thread.sleep(100);
                System.out.print("\nThis");
                Thread.sleep(300);
                System.out.print(" is");
                Thread.sleep(300);
                System.out.print(" the");
                Thread.sleep(300);
                System.out.print(" land");
                Thread.sleep(300);
                System.out.print(" of");
                Thread.sleep(300);
                System.out.print(" LEGENDS");
                Thread.sleep(400);
                break;
            }
            
        } catch (Exception e) {
            System.out.println("Welcome to the Land of Legends");
        }

        System.out.println("\n************************************************************************************************");
        System.out.println("1. Start the Game\n2. See the Instructions\n3. Quit");
        System.out.println("Enter your choice:");

        while(true){
            try{
                userInput.getUserInput();
                if(userInput.checkInput("1") || userInput.checkInput("2") || userInput.checkInput("3")){
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
        return userInput.getUserResponse();
    }

    // Function to display Instructions of the game to the user
    public void displayInstructions(){ 
        System.out.println("************************************************************************************************");
        System.out.println("Legends of Valor is a MOBA (multiplayer online battle arena)-like game. The player will control");
        System.out.println("a team of 3 heroes who will attempt to fight their way through to the monsters' Nexus. The ");
        System.out.println("heroes win if any of them reach the monsters' Nexus. The heroes lose if any monster reaches the");
        System.out.println("heroes' Nexus.");
        System.out.println("************************************************************************************************");
    }

    // Function to put heroes and monsters on the map
    public GridBoard putHeroMonster(GridBoard map, ArrayList<Roles> heroList, ArrayList<Roles> monsterList){
        int j = 0;
        for(int i = 0; i < monsterList.size(); i++){
            ((CellsWithRoles) map.getGrid()[0][j]).setMonsterSlot(monsterList.get(i));
            map.getGrid()[0][j].setCellValue("M" + (i+1));
            int[] temp = {0,j};
            monsterList.get(i).setLocation(temp);
            ((CellsWithRoles) map.getGrid()[7][j]).setHeroSlot(heroList.get(i));
            map.getGrid()[7][j].setCellValue("H" + (i+1));
            int[] temp1 = {7,j};
            heroList.get(i).setLocation(temp1);
            j += 3;
        }

        return map;
    }

    // Function to set the Map's cells
    public GridBoard set_BoardCells(GridBoard map){
        ColourBG colour = new ColourBG();
        // Creating Inaccessible Cells
        for(int i = 0; i < map.getHeight(); i++){
            int[] temp = {i, 2};
            BoardCells Cell = new InaccessibleCell("inaccessible", "", temp, colour.getWhitebg());
            map.createBoard(Cell);
            int[] temp1 = {i, 5};
            BoardCells Cell1 = new InaccessibleCell("inaccessible", "", temp1, colour.getWhitebg());
            map.createBoard(Cell1);
        }

        // Creating Nexus Cells
        for(int i = 0; i < map.getHeight(); i++){
            int[] temp = {0, i};
            if(map.getGrid()[0][i] == null){
                BoardCells Cell = new NexusCell("nexus", "", temp, "monster", colour.getRedbg());
                map.createBoard(Cell);
            }
            int[] temp1 = {7, i};
            if(map.getGrid()[7][i] == null){
                BoardCells Cell1 = new NexusCell("nexus", "", temp1, "hero", colour.getBluebg());
                map.createBoard(Cell1);
            }
        }

        // Randomly creating one cell of each type
        for(int i = 0; i < 4; i++){
            Boolean notNull = true;
            while(notNull){
                int n = random.nextInt(map.getHeight());
                int m = random.nextInt(map.getHeight());
                if(map.getGrid()[n][m] == null){
                    int[] temp1 = {n, m};
                    switch(i){
                        case 0:
                            BoardCells Cell = new PlainCell("plain", "", temp1, colour.getResetbg());
                            map.createBoard(Cell);
                            break;
                        case 1:
                            BoardCells Cell1 = new BushCell("bush", "", temp1, colour.getGreenbg());
                            map.createBoard(Cell1);
                            break;
                        case 2:
                            BoardCells Cell2 = new CaveCell("cave", "", temp1, colour.getYellowbg());
                            map.createBoard(Cell2);
                            break;
                        case 3:
                            BoardCells Cell3 = new KoulouCell("koulou", "", temp1, colour.getPurplebg());
                            map.createBoard(Cell3);
                            break;
                    }
                    notNull = false;
                }
            }
        }

        // Creating other cells
        for(int i = 1; i < map.getHeight()-1; i++){
            for(int j = 0; j < map.getHeight(); j++){
                int temp = random.nextInt(4);
                int[] temp1 = {i,j};
                if(map.getGrid()[i][j] == null){
                    switch(temp){
                        case 0:
                            BoardCells Cell = new PlainCell("plain", "", temp1, colour.getResetbg());
                            map.createBoard(Cell);
                            break;
                        case 1:
                            BoardCells Cell1 = new BushCell("bush", "", temp1, colour.getGreenbg());
                            map.createBoard(Cell1);
                            break;
                        case 2:
                            BoardCells Cell2 = new CaveCell("cave", "", temp1, colour.getYellowbg());
                            map.createBoard(Cell2);
                            break;
                        case 3:
                            BoardCells Cell3 = new KoulouCell("koulou", "", temp1, colour.getPurplebg());
                            map.createBoard(Cell3);
                            break;
                    }
                }
            }
        }

        return map;
    }

    // Function to initialise board
    public GridBoard initBoard(){
        GridBoard map = new GridBoard();
        
        // Function to take input and set Map's size
        map.set_boardSize(8);

        // Function to set the Map's cells
        map = set_BoardCells(map);

        return map;
    }

    // Function to display Map instructions
    public void displayBoardInstructions(){
        System.out.println("************************************************************************************************");
        System.out.println("Blue cells: Hero's nexus");
        System.out.println("Red cells: Monter's nexus");
        System.out.println("White Cells: Heroes and Monsters can't enter these spaces");
        System.out.println("Purple Cells: Koulou spaces increase the strength of any hero who is inside them");
        System.out.println("Yellow Cells: Cave spaces increase the agility of any hero inside them");
        System.out.println("Green Cells: Bush spaces increase the dexterity of any hero inside them");
        System.out.println("Black Cells: These spaces have no special attributes");
        System.out.println("************************************************************************************************");         
    }

    // Function to create heros
    public ArrayList<Roles> createHero(){
        
        HeroFactory hFactory = new HeroFactory();
        // Function to display all the heros to choose from
        hFactory.displayHeroList();
        System.out.println("************************************************************************************************");

        //Array list of Heros
        ArrayList<Roles> heroList= new ArrayList<Roles>();

        int totalHeroes = 3;
        for(int i = 0; i < totalHeroes; i++){
            System.out.println("Enter the index of Hero you want for Lane " + (i+1) + ":(Format: 1.1)");
            while(true){
                try{
                    userInput.getUserInput();
                    String userResponse = userInput.getUserResponse();
                    String[] parts = userResponse.split("\\.");
                    if(parts.length > 2){
                        System.out.println("Invalid Input Format\nTry again");
                    }
                    else if(Integer.parseInt(parts[0]) > 3 || Integer.parseInt(parts[0]) < 1 || Integer.parseInt(parts[1]) < 1 || Integer.parseInt(parts[1]) > 6){
                        System.out.println("Please choose from the above options only\nTry again");
                    }
                    else{
                        Hero hero = (Hero) hFactory.getHero(parts[0],parts[1]);
                        hero.setLane(i+1);
                        heroList.add(hero);
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
    public void displaySelectedHeroList(ArrayList<Roles> heroList){
        System.out.println("You have chosen the following Heroes:");
        for(int i =0; i < heroList.size(); i++){
            System.out.println("H" + (int)(i+1) + ": " + heroList.get(i).getName());
        }
    }

    // Function to create random list of monsters
    public ArrayList<Roles> createMonsters(ArrayList<Roles> heroList){
        MonsterFactory mFactory = new MonsterFactory();
        ArrayList<Integer> levels = new ArrayList<>();
        for(int i = 0; i < heroList.size(); i++){
            levels.add(heroList.get(i).getLevel());
        }
        return mFactory.getMonster(levels);
    }

    // Function to display the list of monsters
    public void displaySelectedMonsterList(ArrayList<Roles> monsterList){
        System.out.println("You are going to fight the following Monsters:");
        for(int i = 0; i < monsterList.size(); i++){
            System.out.println("M" + (int)(i+1) + ": " + monsterList.get(i).getName());
            System.out.println("\tHP:" + monsterList.get(i).getHp() + "\t Damage:" + ((Monster) monsterList.get(i)).getDamage() + "\tDefense:" + ((Monster) monsterList.get(i)).getDefense());
        }
    }

    public void setMonsterLanes(ArrayList<Roles> monsterList){
        for(int i = 0; i < 3; i++){
            monsterList.get(i).setLane(i+1);
        }
    }

    // Function to handle the game
    public void letsPlay(){
        Boolean keepPlaying = true;
        while(keepPlaying){
            // Audio play
            Audio audio = new Audio();
            audio.playAudio("/Users/shivangidhiman/Desktop/CS611/legendsofvalor/src/main/audio.wav");

            // Function to display the Welcome Screen
            String userResponse = displayWelcomeScreen();
            if(userResponse.equalsIgnoreCase("1")){
                System.out.println("************************************************************************************************");
                System.out.println("Good choice!");
                System.out.println("Let's begin your adventure now");
                System.out.println("************************************************************************************************");

                // Function to create Heroes
                ArrayList<Roles> heroList = createHero();

                // Printing the list of hero
                System.out.println("************************************************************************************************");
                displaySelectedHeroList(heroList);
                System.out.println("************************************************************************************************");

                // Function to create random listof monsters
                ArrayList<Roles> monsterList = createMonsters(heroList);

                // Function to set lanes for monsters
                setMonsterLanes(monsterList);

                // Printing the list of Monster
                displaySelectedMonsterList(monsterList);
                System.out.println("************************************************************************************************");

                // Function to initialise the Map
                GridBoard map = initBoard();

                // Function to put heroes and monsters on the map
                map = putHeroMonster(map, heroList, monsterList);
                
                // Calling the function to display the board
                map.displayBoard();

                // Function to display Map instructions
                displayBoardInstructions();

                System.out.println("Let's explore the land of Legends now");
                
                Boolean gameEnd = true;
                int round = 0;
                while(gameEnd){
                    round ++;
                    int heroCount = -1;
                    System.out.println("************************************************************************************************");
                    System.out.println("Round " + round + " begins!");
                    System.out.println("************************************************************************************************");

                    for(int i = 0; i < monsterList.size(); i++){
                        if(heroCount == 3){
                            heroCount = 0;
                        }
                        else{
                            heroCount ++;
                        }

                        System.out.println("Hero " + (heroCount+1) + "'s turn");
                        Move moveHero = new Move((Hero) heroList.get(heroCount), heroList, map, (heroCount+1));
                        if(moveHero.checkWinHero((Hero) heroList.get(heroCount))){
                            gameEnd = false;
                            System.out.println("************************************************************************************************");
                            System.out.println("HEROES WIN!");
                            System.out.println("************************************************************************************************");
                            break;
                        }

                        System.out.println("************************************************************************************************");
                        System.out.println("Monster " + (i+1) + "'s turn");
                        Move moveMonster = new Move((Monster) monsterList.get(i), monsterList, map, (i+1));
                        if(moveMonster.checkWinMonster((Monster) monsterList.get(i))){
                            gameEnd = false;
                            System.out.println("************************************************************************************************");
                            System.out.println("MONSTERS WIN!");
                            System.out.println("************************************************************************************************");
                            break;
                        }
                    }
                    System.out.println("************************************************************************************************");
                    System.out.println("Round " + round + " ends!");

                    // Creating new monsters after every 8 rounds
                    if((round > 1) && (round % 8 == 0)){
                        // Function to create random listof monsters
                        ArrayList<Roles> newMonsters = createMonsters(heroList);

                        monsterList.addAll(newMonsters);

                        // Function to set lanes for monsters
                        setMonsterLanes(newMonsters);

                        System.out.println("Three new monsters have Spawned");
                        // Printing the list of Monster
                        displaySelectedMonsterList(monsterList);

                        int index = (int) (round / 8);
                        // Function to put new monsters on the map
                        putNewMonster(map, newMonsters, index);
                    }
                }
                System.out.println("************************************************************************************************");
                while(true){
                    System.out.println("Press C/c to Play Again");
                    System.out.println("Press Q/q to Quit");
                    userInput.getClass();
                    if(userInput.checkInput("c")){
                        keepPlaying = true;
                        break;
                    }
                    else if(userInput.checkInput("q")){
                        quit();
                    }
                    else{
                        System.out.println("Invalid Input\nTry again");
                    }
                }
            }
            else if(userInput.checkInput("2")){
                // Function to display Instructions of the game to the user
                displayInstructions();
            }
            else if(userInput.checkInput("3")){
                // Function to print Quit
                quit();
            }
        }
    }

    // Function to print Quit
    public static void quit(){
        System.out.println("************************************************************************************************");
        try {
            System.out.print("Q");
            Thread.sleep(100);
            System.out.print("U");
            Thread.sleep(100);
            System.out.print("I");
            Thread.sleep(100);
            System.out.print("T");
            Thread.sleep(100);
            System.out.print("T");
            Thread.sleep(100);
            System.out.print("I");
            Thread.sleep(100);
            System.out.print("N");
            Thread.sleep(100);
            System.out.print("G");
            Thread.sleep(100);
            System.out.print("!");
            Thread.sleep(300);
            System.out.println("\n************************************************************************************************");
            System.exit(0);
            
        } catch (Exception e) {
            System.out.println("QUITTING!");
            System.out.println("************************************************************************************************");
            System.exit(0);
        }
    }

    // Function to put new monsters on the map
    public void putNewMonster(GridBoard map, ArrayList<Roles> monsterList, int index){
        int j = 0;
        for(int i = (index * 3); i < monsterList.size(); i++){
            ((CellsWithRoles) map.getGrid()[0][j]).setMonsterSlot(monsterList.get(i));
            map.getGrid()[0][j].setCellValue("M" + (i+1));
            int[] temp = {0,j};
            monsterList.get(i).setLocation(temp);
            j += 3;
        }
    }

}