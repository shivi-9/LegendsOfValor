package LegendsCode;

/* This is the super class of specific instance generator classes of type Item */
public abstract class ItemFactory {
    public abstract Items getItem(String itemType);
}
