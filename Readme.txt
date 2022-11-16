# CS611-Assignment 3
## Legends: Monsters and Heroes 
---------------------------------------------------------------------------
Shivangi
shivi09@bu.edu
U35642613

## Files
---------------------------------------------------------------------------
Armor.java: This is the class which has functions and attributes related
 	    to all types of Armors.

Battle.java: This class hold everything that happens during a battle.

Board.java: This is the super Board class. This class has attributes and 
	     functions which are common to all possible game boards.

BoardCells.java: This class has attributes and functions which has to be 
		 implemented on a specific board cell.

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

ItemFactory.java: This is the super class of specific instance generator classes 
		  of type Item

Items.java: This is the interface which has functionalities common to all Items

ItemsFactoryProducer.java: This class produces factories specific to required 
		           Item type

Legends.java: This is the class for the Legends game. It has all the attributes 
	      and methods related to Legends game.

LighteningSpells.java: This class implements the Spells interface. This class 
		       hold all the functionalities related to specific spell items
		       called Lightening spells

Market.java: This class handles all the functionalities related to the Market

Monster.java: This is the interface which has signatures of functions
 	   common to all Monster

MonsterFactory.java: Instance generator factory for Monsters typed Roles

Paladin.java: This class has functions and attributes related to all Paladin typed 	
	      Heroes and this class also implements the hero interface

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

Warrior.java: This class has functions and attributes related to all Paladin typed 
	      Heroes and this class also implements the hero interface

Weapon.java: This is the class which has functions and attributes related to all
	     types of Potions

## Bonus
---------------------------------------------------------------------------
1. I have made the battle to be a full team battle rather than a 1-1 battle.
2. I have also updated the functionality so that Hero can equip items whenever 
   they want.
3. Weapons are equipped according to their hand values and empty hands of the hero
4. Spells can be used multiple times based on the mana points hero has and mana 
   required by the spell.

## Overview of the game
---------------------------------------------------------------------------
1. Map is exactly same as the one mentioned in the HW document with limits on 
   Upper and lower bounds. But, this can be easily extended. I just implemented it 
   like so that map can easily fit on my laptop screen.
2. Heroes:
   Can equip an available item, any time they want.
   All Hero start with Experience Level 1 and 1800 Gold.
   Paladin and Warrior begin with a basic swords, and sorcerer begin with a basic lightning spell.
3. Monster:
   They are created randomly at battle locations.
   Can be of any level upto Heroes Max Level.
4. Market:
   Hero can buy items and also, sell items at 90% of their original value.
5. Battle:
   Heroes have the option to equip items at the beginning of the battle.
   Heroes always gets the first turn.
   Heroes can see their game stats any time they want.
   If Hero party wins, all the Hero's levels up by 1 and their attribute increase by a certain factor.
   Heroes cannot leave or quit the game while a battle in underway.
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
************************************************
Welcome to world of Monsters and Legend
1. Start the Game
2. See the Instructions
3. Quit
************************************************
Enter your choice:
1
************************************************
Good choice!
Let's begin your adventure now
************************************************
Enter the size of your Map:(Limit 4-8)
6
************************************************
+---+---+---+---+---+---+
| O |   |   | M |   | M |
+---+---+---+---+---+---+
|   |   |   |   | M | I |
+---+---+---+---+---+---+
| M |   | I | M |   | M |
+---+---+---+---+---+---+
|   |   |   |   | I | I |
+---+---+---+---+---+---+
|   | M |   | I | M | I |
+---+---+---+---+---+---+
| M | I | I | I |   | M |
+---+---+---+---+---+---+
O: Current Position of Hero Party
M: Market Place
I: Inaccessible Place
************************************************
Enter the number of Heros you want (Limit 2-5):
4
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
Enter the index of Hero you want:(Format: 1.1)
1.1
2.1
3.1
4.1
Please choose from the above options only
Try again
3.2 
************************************************
You have chosen the following Heroes:
1. Gaerdal_Ironhand
2. Rillifane_Rallathil
3. Parzival
4. Sehanine_Moonbow
************************************************
Let's explore the land of Legends now
************************************************
+---+---+---+---+---+---+
| O |   |   | M |   | M |
+---+---+---+---+---+---+
|   |   |   |   | M | I |
+---+---+---+---+---+---+
| M |   | I | M |   | M |
+---+---+---+---+---+---+
|   |   |   |   | I | I |
+---+---+---+---+---+---+
|   | M |   | I | M | I |
+---+---+---+---+---+---+
| M | I | I | I |   | M |
+---+---+---+---+---+---+
Press I/i for Instructions
Press P/p to see the Map
Press Q/q to Quit
Enter your next move:
s
************************************************
+---+---+---+---+---+---+
|   |   |   | M |   | M |
+---+---+---+---+---+---+
| O |   |   |   | M | I |
+---+---+---+---+---+---+
| M |   | I | M |   | M |
+---+---+---+---+---+---+
|   |   |   |   | I | I |
+---+---+---+---+---+---+
|   | M |   | I | M | I |
+---+---+---+---+---+---+
| M | I | I | I |   | M |
+---+---+---+---+---+---+
O: Current Position of Hero Party
M: Market Place
I: Inaccessible Place
************************************************
************************************************
Press Y/y if hero party wants to equip or unequip items
Press N/n if hero party does NOT wants to equip or unequip items
n
************************************************
LET's BEGIN THE BATTLE
YOU ARE GOING TO FIGHT THE FOLLOWING MONSTERS
BigBad-Wolf
        HP:1000
BigBad-Wolf
        HP:1000
Blinky
        HP:1000
BigBad-Wolf
        HP:1000
************************************************
Gaerdal_Ironhand
Press E/e to equip a item
Press U/u to unequip a item
Press Q/q to quit
Press B/b to get back
************************************************
e
************************************************
Gaerdal_Ironhand
Press A/a to equip the Armor
Press W/w to equip the Weapon
Press B/b if you don't want to equip anymore
Press Q/q to quit
************************************************
w
WEAPON
1. Sword
Enter name of the weapon you wanna equip:
Sword
************************************************
Gaerdal_Ironhand
Press A/a to equip the Armor
Press W/w to equip the Weapon
Press B/b if you don't want to equip anymore
Press Q/q to quit
************************************************
b
************************************************
Rillifane_Rallathil
Press E/e to equip a item
Press U/u to unequip a item
Press Q/q to quit
Press B/b to get back
************************************************
b
************************************************
Parzival
Press E/e to equip a item
Press U/u to unequip a item
Press Q/q to quit
Press B/b to get back
************************************************
e
************************************************
Parzival
Press A/a to equip the Armor
Press W/w to equip the Weapon
Press B/b if you don't want to equip anymore
Press Q/q to quit
************************************************
w
************************************************
WEAPON
1. Sword
************************************************
Enter name of the weapon you wanna equip:
sword
************************************************
Parzival
Press A/a to equip the Armor
Press W/w to equip the Weapon
Press B/b if you don't want to equip anymore
Press Q/q to quit
************************************************
b
************************************************
Sehanine_Moonbow
Press E/e to equip a item
Press U/u to unequip a item
Press Q/q to quit
Press B/b to get back
************************************************
e
************************************************
Sehanine_Moonbow
Press A/a to equip the Armor
Press W/w to equip the Weapon
Press B/b if you don't want to equip anymore
Press Q/q to quit
************************************************
w
************************************************
WEAPON
1. Sword
************************************************
Enter name of the weapon you wanna equip:
sword
************************************************
Sehanine_Moonbow
Press A/a to equip the Armor
Press W/w to equip the Weapon
Press B/b if you don't want to equip anymore
Press Q/q to quit
************************************************
b
Gaerdal_Ironhand, please choose the action:
1. Attack using the weapon
2. Cast a spell
3. Drink a potion to protect yourself
4. View hero's inventory
5. View hero's statistics
1
Sword
Enter the name of weapon you want to use:
sword
YOU ARE GOING TO FIGHT THE FOLLOWING MONSTERS
BigBad-Wolf
        HP:1000
BigBad-Wolf
        HP:1000
Blinky
        HP:1000
BigBad-Wolf
        HP:1000
Enter the name of the monster you want to target:
BigBad-Wolf
Hero: Gaerdal_Ironhand attacked Monster: BigBad-Wolf for 49 damage
Monster's Updated Statistics
************************************************
BigBad-Wolf
        HP: 951
************************************************
Monster: Blinky attacked Hero: Rillifane_Rallathil for 446 damage
Hero's Updated Statistics
************************************************
Rillifane_Rallathil
        HP: 554 Mana: 1300      Gold:1800
************************************************
Rillifane_Rallathil, please choose the action:
1. Attack using the weapon
2. Cast a spell
3. Drink a potion to protect yourself
4. View hero's inventory
5. View hero's statistics
2
Spells
1. Lightning_Dagger - lightening
Enter the name of spell you want to use
Lightning_Dagger
YOU ARE GOING TO FIGHT THE FOLLOWING MONSTERS
BigBad-Wolf
        HP:951
BigBad-Wolf
        HP:1000
Blinky
        HP:1000
BigBad-Wolf
        HP:1000
