package LegendsCode;
import java.util.*;

/* This class implements the monster interface.
 * Dragons are a type of monsters and this class holds all the 
 * functionalities specific to Dragons */
public class Dragon implements Monster{
    private String name; // Name of the monster
    private int level; // Level of that monster
    private int damage; // Damage that the monster can cause
    private int defense; // An attribute which is used to calculate the reduced effective attack
    private int dodgeChance; // An attribute which is used to calculate the reduced effective attack
    private int hp; // Health points of monster
    private Random random = new Random();

    // This function randomly creates instances of type monster based on the level
    public Boolean createMonster(int level){
        this.hp = 1000;
        this.level = level;
        if(level == 1){
            name = "Natsunomeryu";
            damage = 400;
            defense = 500;
            dodgeChance = 45;
        }
        else if(level == 2){
            name = "Chrysophylax";
            damage = 200;
            defense = 500;
            dodgeChance = 20;
        }
        else if(level == 3){
            name = "Desghidorrah";
            damage = 300;
            defense = 400;
            dodgeChance = 35;
        }
        else if(level == 4){
            name = "BunsenBurner";
            damage = 400;
            defense = 500;
            dodgeChance = 45;
        }
        else if(level == 5){
            return false;
        }
        else if(level == 6){
            int temp = random.nextInt(2);
            if(temp == 0){
                name = "Igneel";
                damage = 600;
                defense = 400;
                dodgeChance = 60;
            }
            else if(temp == 1){
                name = "Phaarthurnax";
                damage = 600;
                defense = 700;
                dodgeChance = 60;
            }
        }
        else if(level == 7){
            int temp = random.nextInt(2);
            if(temp == 0){
                name = "TheScaleless";
                damage = 700;
                defense = 600;
                dodgeChance = 75;
            }
            else if(temp == 1){
                name = "Kas-Ethelinh";
                damage = 600;
                defense = 500;
                dodgeChance = 60;
            }
        }
        else if(level == 8){
            name = "TheWeatherbe";
            damage = 800;
            defense = 900;
            dodgeChance = 80;
        }
        else if(level == 9){
            int temp = random.nextInt(2);
            if(temp == 0){
                name = "D-Maleficent";
                damage = 900;
                defense = 950;
                dodgeChance = 85;
            }
            else if(temp == 1){
                name = "BlueEyesWhite";
                damage = 900;
                defense = 600;
                dodgeChance = 75;
            }
        }
        else if(level == 10){
            name = "Alexstraszan";
            damage = 1000;
            defense = 9000;
            dodgeChance = 55;
        }
        return true; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    // Function to update the effects of hero's attacks
    public int monsterAttacked(Items action, Roles hero) {
        int attackValue = 0;
        if(action.getType().equalsIgnoreCase("spell")){
            attackValue = ((Spells) action).getDamage() + ((((Hero) hero).getDexterity() * ((Spells) action).getDamage())/10000);
            attackValue = attackValue - ((defense + dodgeChance)/10);
            if(attackValue < 0){
                attackValue = 0;
            }
            hp = hp - attackValue;
            if(hp < 0){
                hp = 0;
            }
        }
        else if(action.getType().equalsIgnoreCase("weapon")){
            attackValue = (int) ((((Weapons) action).getDamage() + ((Hero) hero).getStrength()) * 0.05);
            attackValue = attackValue - ((defense + dodgeChance)/10); 
            if(attackValue < 0){
                attackValue = 0;
            }
            hp = hp - attackValue;
            if(hp < 0){
                hp = 0;
            }      
        } 
        else {
            attackValue = (int) ((((Hero) hero).getStrength()) * 0.05);
            attackValue = attackValue - ((defense + dodgeChance)/10); 
            if(attackValue < 0){
                attackValue = 0;
            }
            hp = hp - attackValue;
            if(hp < 0){
                hp = 0;
            }
        }
        return attackValue;
    }

    // function to display stats
    public void displayStats(){
        System.out.println("************************************************");
        System.out.println(name);
        System.out.println("\tHP: " + hp);
        System.out.println("************************************************");
    }
}
