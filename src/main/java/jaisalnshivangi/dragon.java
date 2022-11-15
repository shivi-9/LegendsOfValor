public class dragon extends monsters {

    public dragon(int health, int strength, int defence, int dodge, String name) {
        super(health, strength, defence, dodge, name);
    }




    public void attack(hero h) {
        h.health= h.health - (this.strength- h.dexterity/2);
    }

    public void attack(character c) {

    }
}
