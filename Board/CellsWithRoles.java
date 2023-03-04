package LegendsCode;

public interface CellsWithRoles {
    public abstract Hero getHeroSlot();
    public abstract void setHeroSlot(Roles roles);
    public abstract Monster getMonsterSlot();
    public abstract void setMonsterSlot(Roles roles);
    public abstract Boolean getIsHeroSlot();
    public abstract Boolean getIsMonsterSlot();
    public abstract void resetHeroSlot();
    public abstract void resetMonsterSlot();
}
