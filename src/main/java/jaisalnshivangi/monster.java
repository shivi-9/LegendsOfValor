
//monster abstract class implementing character interface
public abstract class monsters implements character  {
    int health;
    int strength;
    int defence;
    int dodge;
    String name;
    int level =1;

    public monsters(int health, int strength, int defence, int dodge, String name) {
        this.health = health;
        this.strength = strength;
        this.defence = defence;
        this.dodge = dodge;
        this.name = name;
    }



    public void attack(hero h){
        h.health= h.health - Math.max(60, this.strength - h.dexterity - h.equippedArmor.damageOrHeal/2);
    }



    public void faint() {

    }
}
