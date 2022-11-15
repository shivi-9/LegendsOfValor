package jaisalnshivangi;

/* This is the interface which has functionalities common to all Items */
public interface Items {
    // Getter and Setter Functions
    public abstract String getName();
    public abstract void setName(String name);
    public abstract int getCost();
    public abstract void setCost(int cost);
    public abstract int getReqLevel();
    public abstract void setReqLevel(int reqLevel);
    public abstract String getType();
    public abstract void setType(String type);
    public abstract String getStatus();
    public abstract void setStatus(String status);   
    public abstract void itemUsed(Items item, Roles role);
}