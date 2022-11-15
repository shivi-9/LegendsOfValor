//paladin class to extend hero class

public class paladin extends hero{

    public paladin(String name, int attack, int agility, int dexterity, int money, int mana) {
        super(name, attack, agility, dexterity, money, mana);
    }

    public void castSpell() {

    }

    public void attack(character c) {

    }


    public void castSpell(spells x) {

    }


    public void levelUpAttributes() {

        this.agility = (int) (1.1 * agility);
        this.attack =  (int) (1.1 * attack);
        this.dexterity =  (int) (1.3 * dexterity);
        this.mana =  (int) (1.1 * mana);
        this.hp =  (int) (1.25 * hp);

    }
}
