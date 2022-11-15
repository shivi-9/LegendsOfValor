package jaisalnshivangi;

/* This class produces factories specific to required Item type */
public class ItemsFactoryProducer {
    // This function returns object of Item factory specific to the required Item type
    public static ItemsFactory getFactory(String type){   
        if(type.equalsIgnoreCase("equippable")){
           return new EquippableFactory();         
        }
        else if(type.equalsIgnoreCase("consumable")){
           return new ConsumableFactory();
        }
        else{
            return null;
        }
     }
}