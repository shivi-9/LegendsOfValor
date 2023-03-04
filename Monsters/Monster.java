package LegendsCode;

/* This is the interface which has signatures of functions
 * common to all Monsters */
public interface Monster extends Roles{
    public Boolean createMonster(int level);
    public int getDamage();
    public void setDamage(int damage);
    public int getDefense();
    public void setDefense(int defense);
    public int getDodgeChance();
    public void setDodgeChance(int dodgeChance);
    public int monsterAttacked(Items action, Roles hero);
}
