# CS611-Assignment 4
## Legends of Valor 
---------------------------------------------------------------------------
Shivangi
shivi09@bu.edu
U35642613

Jaisal Singh
jaisal@bu.edu
U60118211

## Files
---------------------------------------------------------------------------
Armor.java: This is the class which has functions and attributes related
 	    to all types of Armors.
      
Audio.java: It contains code relating to the background music. 

Battle.java: This class hold everything that happens during a battle.

Board.java: This is the super Board class. This class has attributes and 
	     functions which are common to all possible game boards.

BoardCells.java: This class has attributes and functions which has to be 
		 implemented on a specific board cell.
     
BushCell.java: It extends boardCell class and implements CellsWithBonus interface 
      and contains attributes specific to Koulou cell type

CaveCell.java: It extends boardCell class and implements CellsWithBonus interface 
      and contains attributes specific to Cave cell type

CellswithBonus.java: It is an interface that extends CellsWithRoles

CellsWithRoles.java: It is an Interafce that contains methods relating to hero 
              and monster positioning in cells.
              
ColorBG.java: CLass that contains info about the color for different gamecells 

Consumable.java: Super class for Spells and Potion. This class has
		 functionalities common to both of them.

ConsumableFactory.java: Instance generator factory for Consumable type items

Dragon.java: This class implements the monster interface. Dragons are a 
	     type of monsters and this class holds all the functionalities 
	     specific to Dragons

Equipable.java: Super class for Armor and Weapon. This class has 
		 functionalities common to both of them

Equipable.java: Instance generator factory for Equipable type items

Exoskeletons.java: This class implements the monster interface. Exoskeletons 
		    are a type of monsters and this class holds all the 
		    functionalities specific to Exoskeletons

FireSpells.java: This class implements the Spells interface. This class hold 
	         all the functionalities related to specific spell items 
		 called Fire spells

Game.java: This is the interface which all the game classes implements. 
 	   It has the common functionalities of all the games

GameEngine.java: This is the main class which will call the specific game class.
 		 This class can have instances of different game classes.

GridBoard.java: This is the class for all Grid type boards like chess board, 
		tic-tac-toe board. It has all the attributes and functions
		for Grid type board

Hero.java: This is the interface which has signatures of functions
 	   common to all Heroes

HeroFactory.java: Instance generator factory for Heroes typed Roles

IceSpells.java: This class implements the Spells interface. This class hold all
	        the functionalities related to specific spell items called Ice
		spells

Inaccessible.java: It extends boardCell class and contains info on inaccessible
              game cells

ItemFactory.java: This is the super class of specific instance generator classes 
		  of type Item

Items.java: This is the interface which has functionalities common to all Items

ItemsFactoryProducer.java: This class produces factories specific to required 
		           Item type

Koulou.java: It extends boardCell class and implements CellsWithBonus interface 
      and contains attributes specific to Koulou cell type

Legends.java: This is the class for the Legends game. It has all the attributes 
	      and methods related to Legends game.

LighteningSpells.java: This class implements the Spells interface. This class 
		       hold all the functionalities related to specific spell items
		       called Lightening spells

Market.java: This class handles all the functionalities related to the Market

Monster.java: This is the interface which has signatures of functions
 	   common to all Monster

MonsterFactory.java: Instance generator factory for Monsters typed Roles

Move.java: Class to coer hero and monster movement on gameboard

Nexus.java: It extends boardCell class and implements CellsWithBonus interface 
      and contains attributes specific to Nexus cell type


Paladin.java: This class has functions and attributes related to all Paladin typed 	
	      Heroes and this class also implements the hero interface
        
PlainCell.java: It extends boardCell class and implements CellsWithBonus interface 
      and contains attributes specific to plain cell type


Potions.java: This is the class which has functions and attributes related
 	      to all types of Potions

RolePlayingGame.java: This class has functions and attributes common to all Role 
		      Playing games

Roles.java: This interface has all the functionalities common to all roles

Sorcerer.java: This class has functions and attributes related to all Sorcerer typed 	
	       Heroes and this class also implements the hero interface

Spells.java: This is the interface which has functionalities common to all Spells

Spirits.java: This class implements the monster interface. Spirits are a type of 
	      monsters and this class holds all the functionalities specific to 
	      Spirits
        
UserInput.java: Class to take user input at different stages of the game

Warrior.java: This class has functions and attributes related to all Paladin typed 
	      Heroes and this class also implements the hero interface

Weapon.java: This is the class which has functions and attributes related to all
	     types of Potions

## Bonus
---------------------------------------------------------------------------
1. Added background Music
2. Added different color for different cell types
3. Added animation effects 
4. When heros die they respawn in nexus and lose 1 life, If they die and have no life left 
   they will not respawn. 

## Overview of the game
---------------------------------------------------------------------------
1. Map is exactly same as the one mentioned in the HW document with added color effects.

2. Heroes:
   Can equip an available item, any time they want.
   All Hero start with Experience Level 1 and 1800 Gold and 3 lives.
   Paladin and Warrior begin with a basic swords, and sorcerer begin with a basic lightning spell.
3. Monster:
   They are created aat start and after every 8 turns.
   Can be of any level upto Heroes Max Level.
   When they die they are removed from map
4. Market:
   Hero can buy items and also, sell items at 90% of their original value.
5. Battle:
      Heroes always gets the first turn.
   Heroes can see their game stats any time they want.
   If Hero party wins, all the Hero's levels up by 1 and their attribute increase by a certain factor.
   Heroes cannot leave the game while a battle in underway.
   If monsters wins, heroes won't level up and will be revived with HP 100.
*Game will only end after the player presses the q button.

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the folder/directory "java" after unzipping the files
   cd {project_path}/Legends/src/main/java
2. Run the following instructions:
   javac ./LegendsCode/GameEngine.java && java LegendsCode/GameEngine

## Input/Output Example
---------------------------------------------------------------------------
Output:

************************************************************************************************
WELCOME!
This is the land of LEGENDS
************************************************************************************************
1. Start the Game
2. See the Instructions
3. Quit
Enter your choice:

1
************************************************
Good choice!
Let's begin your adventure now
************************************************
**All the Heroes start with experience level 1, 1800 gold coins and 100 HP**
1. Warriors:
        1.1 Gaerdal Ironhand
                Mana: 100       Strength: 700   Agility: 500    Dexterity: 600
        1.2 Sehanine Monnbow
                Mana: 600       Strength: 700   Agility: 800    Dexterity: 500
        1.3 Muamman Duathall
                Mana: 300       Strength: 900   Agility: 500    Dexterity: 750
        1.4 Flandal Steelskin
                Mana: 200       Strength: 750   Agility: 650    Dexterity: 700
        1.5 Undefeated Yoj
                Mana: 400       Strength: 800   Agility: 400    Dexterity: 700
        1.6 Eunoia Cyn
                Mana: 400       Strength: 700   Agility: 800    Dexterity: 600
2. Sorcerers:
        2.1 Rillifane Rallathil
                Mana: 1300      Strength: 750   Agility: 450    Dexterity: 500
        2.2 Segojan Earthcaller
                Mana: 900       Strength: 800   Agility: 500    Dexterity: 650
        2.3 Reign Havoc
                Mana: 800       Strength: 800   Agility: 800    Dexterity: 800
        2.4 Reverie Ashels
                Mana: 900       Strength: 800   Agility: 700    Dexterity: 400
        2.5 Kalabar
                Mana: 800       Strength: 850   Agility: 400    Dexterity: 600
        2.6 Skye Soar
                Mana: 1000      Strength: 700   Agility: 400    Dexterity: 500
3. Paladins:
        3.1 Parzival
                Mana: 300       Strength: 750   Agility: 650    Dexterity: 700
        3.2 Sehanine Moonbow
                Mana: 300       Strength: 750   Agility: 700    Dexterity: 700
        3.3 Skoraeus Stonebones
                Mana: 250       Strength: 650   Agility: 600    Dexterity: 350
        3.4 Garl Glittergold
                Mana: 100       Strength: 600   Agility: 500    Dexterity: 400
        3.5 Amaryllis Astra
                Mana: 500       Strength: 500   Agility: 500    Dexterity: 500
        3.6 Caliber Heist
                Mana: 400       Strength: 400   Agility: 400    Dexterity: 400
************************************************

Enter the index of Hero you want for Lane 1:(Format: 1.1)
1.1
Enter the index of Hero you want for Lane 2:(Format: 1.1)
2.5
Enter the index of Hero you want for Lane 3:(Format: 1.1)
6.4
Please choose from the above options only
Try again
3.1


************************************************************************************************
You have chosen the following Heroes:
H1: Gaerdal_Ironhand
H2: Kalabar
H3: Parzival
************************************************************************************************
You are going to fight the following Monsters:
M1: Blinky
	HP:1000	 Damage:450	Defense:350
M2: Casper
	HP:1000	 Damage:100	Defense:100
M3: Blinky
	HP:1000	 Damage:450	Defense:350
************************************************************************************************

(*******Cell Color is not visible in readme *****)

+-------+-------+-------+-------+-------+-------+-------+-------+
| M1    |       |       | M2    |       |       | M3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| H1    |       |       | H2    |       |       | H3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
************************************************************************************************
Blue cells: Hero's nexus
Red cells: Monter's nexus
White Cells: Heroes and Monsters can't enter these spaces
Purple Cells: Koulou spaces increase the strength of any hero who is inside them
Yellow Cells: Cave spaces increase the agility of any hero inside them
Green Cells: Bush spaces increase the dexterity of any hero inside them
Black Cells: These spaces have no special attributes
************************************************************************************************
Let's explore the land of Legends now
************************************************************************************************
Round 1 begins!
************************************************************************************************
Hero 1's turn
Welcome to your Nexus
************************************************************************************************
You can choose to do any of the following:
Press E/e to Equip/Unequip/Change a Weapon/Armor
Press P/p to Drink a Potion
Press M/m to Move to another Cell
Press T/t to Teleport to another Lane
Press S/s to Shop
Press I/i to See your Inventory
Press D/d to See your Statistics
Press Q/q to Quit the Game
************************************************************************************************
m
************************************************************************************************
Controls:
Press W/w to Move up
Press A/a to Move left
Press S/s to Move down
Press D/d to Move right
Press Q/q to Quit the Game
************************************************************************************************
w
Koulou has increased Hero's strength by 10%
************************************************************************************************
+-------+-------+-------+-------+-------+-------+-------+-------+
| M1    |       |       | M2    |       |       | M3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| H1    |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       | H2    |       |       | H3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
************************************************************************************************
Monster 1's turn
************************************************************************************************
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       | M2    |       |       | M3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| M1    |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| H1    |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       | H2    |       |       | H3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
Hero 2's turn
Welcome to your Nexus
************************************************************************************************
You can choose to do any of the following:
Press E/e to Equip/Unequip/Change a Weapon/Armor
Press P/p to Drink a Potion
Press M/m to Move to another Cell
Press T/t to Teleport to another Lane
Press S/s to Shop
Press I/i to See your Inventory
Press D/d to See your Statistics
Press Q/q to Quit the Game
************************************************************************************************
t
************************************************************************************************
Enter the Target Hero Index(Eg: 1, 2, 3):
************************************************************************************************
1
************************************************************************************************
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       | M2    |       |       | M3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| M1    |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| H1    | H2    |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       | H3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
************************************************************************************************
************************************************************************************************
Monster 2's turn
************************************************************************************************
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       | M3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| M1    |       |       | M2    |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| H1    | H2    |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       | H3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
Hero 3's turn
Welcome to your Nexus
************************************************************************************************
You can choose to do any of the following:
Press E/e to Equip/Unequip/Change a Weapon/Armor
Press P/p to Drink a Potion
Press M/m to Move to another Cell
Press T/t to Teleport to another Lane
Press S/s to Shop
Press I/i to See your Inventory
Press D/d to See your Statistics
Press Q/q to Quit the Game
************************************************************************************************
s
************************************************************************************************
***WELCOME TO THE MARKET***
You can buy or sell items here
Let's begin shopping
************************************************************************************************
Press S/s to sell an Item
Press B/b to Buy an Item
Press E/e to Exit the Market
Press D/d to see your Statistics
Press Q/q to Quit the Game
************************************************************************************************
b
************************************************************************************************
***ITEMS FOR SALE***
WEAPONS
Dagger
	Required Level: 1
	Cost: 200
	Damage: 250
	Hands Required: 1
Armors
Breastplate
	Required Level: 3
	Cost: 350
	Damage Reduction: 600
Spells
Lava_Comet
	Required Level: 7
	Cost: 800
	Damage: 1000
	Mana Cost: 550
Frost_Blizzard
	Required Level: 5
	Cost: 750
	Damage: 850
	Mana Cost: 350
Spark_Needles
	Required Level: 2
	Cost: 500
	Damage: 600
	Mana Cost: 200
Potions
Mermaid_Tears
	Required Level: 5
	Cost: 850
	Attribute Increase: 100
Enter the name of the Item you want to buy:
************************************************************************************************
dagger
Dagger bought for 200
************************************************************************************************
************************************************************************************************
Press S/s to sell an Item
Press B/b to Buy an Item
Press E/e to Exit the Market
Press D/d to see your Statistics
Press Q/q to Quit the Game
************************************************************************************************
e
************************************************************************************************
You can choose to do any of the following:
Press E/e to Equip/Unequip/Change a Weapon/Armor
Press P/p to Drink a Potion
Press M/m to Move to another Cell
Press T/t to Teleport to another Lane
Press S/s to Shop
Press I/i to See your Inventory
Press D/d to See your Statistics
Press Q/q to Quit the Game
************************************************************************************************
d
************************************************************************************************
Parzival
	HP: 1000	Mana: 300	Gold:1600
************************************************************************************************
************************************************************************************************
You can choose to do any of the following:
Press E/e to Equip/Unequip/Change a Weapon/Armor
Press P/p to Drink a Potion
Press M/m to Move to another Cell
Press T/t to Teleport to another Lane
Press S/s to Shop
Press I/i to See your Inventory
Press D/d to See your Statistics
Press Q/q to Quit the Game
************************************************************************************************
m
************************************************************************************************
Controls:
Press W/w to Move up
Press A/a to Move left
Press S/s to Move down
Press D/d to Move right
Press Q/q to Quit the Game
************************************************************************************************
w
Bushes have increased Hero's dexterity by 10%
************************************************************************************************
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       | M3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| M1    |       |       | M2    |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| H1    | H2    |       |       |       |       | H3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
************************************************************************************************
Monster 3's turn
************************************************************************************************
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| M1    |       |       | M2    |       |       | M3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| H1    | H2    |       |       |       |       | H3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
************************************************************************************************
Round 1 ends!
************************************************************************************************
Round 2 begins!
************************************************************************************************
Hero 1's turn
************************************************************************************************
You can choose to do any of the following:
Press E/e to Equip/Unequip/Change a Weapon/Armor
Press P/p to Drink a Potion
Press M/m to Move to another Cell
Press T/t to Teleport to another Lane
Press R/r to Recall to your Nexus
Press I/i to See your Inventory
Press D/d to See your Statistics
Press Q/q to Quit the Game
************************************************************************************************
r
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| M1    |       |       | M2    |       |       | M3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       | H2    |       |       |       |       | H3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| H1    |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
************************************************************************************************
Monster 1's turn
************************************************************************************************
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       | M2    |       |       | M3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| M1    |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
|       | H2    |       |       |       |       | H3    |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
| H1    |       |       |       |       |       |       |       |
+-------+-------+-------+-------+-------+-------+-------+-------+
Hero 2's turn
************************************************************************************************
You can choose to do any of the following:
Press E/e to Equip/Unequip/Change a Weapon/Armor
Press P/p to Drink a Potion
Press M/m to Move to another Cell
Press T/t to Teleport to another Lane
Press R/r to Recall to your Nexus
Press I/i to See your Inventory
Press D/d to See your Statistics
Press Q/q to Quit the Game
************************************************************************************************



