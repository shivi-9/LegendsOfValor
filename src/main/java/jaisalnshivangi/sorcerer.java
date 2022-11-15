public class sorcerer extends hero{


    public sorcerer(String name, int attack, int agility, int dexterity, int money, int mana) {
        super(name, attack, agility, dexterity, money, mana);
    }

    public void castSpell() {

    }

    public void attack(character c) {

    }

    public void castSpell(spells x) {

    }

    public void levelUpAttributes() {

        this.agility = (int) (1.2 * agility);
        this.attack =  (int) (1.1 * attack);
        this.dexterity =  (int) (1.1 * dexterity);
        this.mana =  (int) (1.3 * mana);
        this.hp =  (int) (1.2 * hp);

    }
}
