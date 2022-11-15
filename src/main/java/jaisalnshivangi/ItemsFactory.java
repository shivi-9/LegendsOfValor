package jaisalnshivangi;

/* This is the super class of specific instance generator classes of type Item */
public abstract class ItemsFactory {
    public abstract Items getItem(String itemType);
}