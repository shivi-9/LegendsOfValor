package LegendsCode;
import java.util.*;;

/* This class implements the monster interface.
 * Spirits are a type of monsters and this class holds all the 
 * functionalities specific to Spirits */
public class Spirits implements Monster {
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
            int temp = random.nextInt(2);
            if(temp == 0){
                name = "Blinky";
                damage = 450;
                defense = 350;
                dodgeChance = 35;
            }
            else if(temp == 1){
                name = "Casper";
                damage = 100;
                defense = 100;
                dodgeChance = 50;
            }
        }
        else if(level == 2){
            name = "Andrealphus";
            damage = 600;
            defense = 500;
            dodgeChance = 40;
        }
        else if(level == 3){
            name = "Andromalius";
            damage = 550;
            defense = 450;
            dodgeChance = 25;
        }
        else if(level == 4){
            name = "Chiang-shih";
            damage = 700;
            defense = 600;
            dodgeChance = 40;
        }
        else if(level == 5){
            name = "FallenAngel";
            damage = 800;
            defense = 700;
            dodgeChance = 50;
        }
        else if(level == 6){
            name = "Ereshkigall";
            damage = 950;
            defense = 450;
            dodgeChance = 35;
        }
        else if(level == 7){
            name = "Melchiresas";
            damage = 350;
            defense = 150;
            dodgeChance = 75;
        }
        else if(level == 8){
            name = "Jormunngand";
            damage = 600;
            defense = 900;
            dodgeChance = 20;
        }
        else if(level == 9){
            name = "Rakkshasass";
            damage = 550;
            defense = 600;
            dodgeChance = 35;
        }
        else if(level == 10){
            name = "Taltecuhtli";
            damage = 300;
            defense = 200;
            dodgeChance = 50;
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
