public class warrior extends hero{


    public warrior(String name, int attack, int agility, int dexterity, int money, int mana) {
        super(name, attack, agility, dexterity, money, mana);
    }

    public void castSpell() {

    }


    public void heal() {

    }


    public void castSpell(spells s) {

    }

    public void levelUpAttributes() {
        this.agility = (int) (1.1 * agility);
        this.attack =  (int) (1.25 * attack);
        this.dexterity =  (int) (1.1 * dexterity);
        this.mana =  (int) (1.1 * mana);
        this.hp =  (int) (1.25 * hp);


    }



}

