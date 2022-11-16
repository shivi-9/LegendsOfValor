package LegendsCode;

/* This interface has all the functionalities common to all roles */
public interface Roles {
    public abstract String getName();
    public abstract void setName(String name);
    public abstract int getLevel();
    public abstract void setLevel(int level);
    public abstract int getHp();
    public abstract void setHp(int hp);
    public abstract void displayStats();
}