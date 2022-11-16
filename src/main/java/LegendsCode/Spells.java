package LegendsCode;

/* This is the interface which has functionalities common to all Spells */
public interface Spells extends Items{
    public abstract String getSpellType();
    public abstract void setSpellType(String spellType);
    public abstract int getDamage();
    public abstract void setDamage(int damage);
    public abstract int getManaCost();
    public abstract void setManaCost(int manaCost);
}
