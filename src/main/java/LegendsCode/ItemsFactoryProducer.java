package LegendsCode;

/* This class produces factories specific to required Item type */
public class ItemsFactoryProducer {
    // This function returns object of Item factory specific to the required Item type
    public static ItemFactory getFactory(String type){   
        if(type.equalsIgnoreCase("equipable")){
           return new EquipableFactory();         
        }
        else if(type.equalsIgnoreCase("consumable")){
           return new ConsumableFactory();
        }
        else{
            return null;
        }
     }
}
