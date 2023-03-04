# Legends of Valor
Legends of Valor is a MOBA-like game where the player controls a team of 3 heroes who attempt to fight their way through to the monsters’ Nexus. The heroes win if any of them reach the monsters’ Nexus, and they lose if any monster reaches the heroes’ Nexus.

This game is an extension of Legends: Monsters and Heroes and uses the same items, heroes, and monsters. However, there are new spaces called Inaccessible, Plain, Bush, Cave, and Koulou that have different bonuses and behaviors.

The game is played on an 8x8 grid of spaces, divided into three lanes, each separated by a column of impassible spaces. Each lane has a width of two spaces, and each space can hold up to one monster and up to one hero.

The player chooses the three heroes that will be used and which of the three lanes that hero will start in. At the start of the game, the heroes spawn in their Nexus, and three equally-leveled monsters spawn in their Nexus. The game is played in rounds, with the heroes’ turn followed by the monsters’ turn.

## How to Play
1. Navigate to the folder/directory "java" after unzipping the files
   cd {project_path}/Legends/src/main/java
2. Run the following instructions:
   javac ./LegendsCode/GameEngine.java && java LegendsCode/GameEngine

## Gameplay
During the heroes’ turn, the player must perform one valid action for each of the heroes. The available actions are:
* Change Weapon or Armor
* Use a Potion
* Attack
* Cast a Spell
* Move
* Teleport
* Recall

Once all of the heroes have made their move, their turn is over. Then it becomes the monsters’ turn. During the monster’s turn, each monster either attacks a hero (if they meet the conditions to attack) or moves one space “forward” (towards the heroes’ Nexus).

The game continues in rounds until one team wins.