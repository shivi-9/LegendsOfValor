package LegendsCode;

/* Instance generator factory for Heroes typed Roles */
public class HeroFactory {
    // Function to display all the heros to choose from
    public void displayHeroList(){
        System.out.println("**All the Heroes start with experience level 1, 1800 gold coins and 100 HP**");
        System.out.println("1. Warriors:");
        System.out.println("\t1.1 Gaerdal Ironhand");
        System.out.println("\t\tMana: 100\tStrength: 700\tAgility: 500\tDexterity: 600");
        System.out.println("\t1.2 Sehanine Monnbow");
        System.out.println("\t\tMana: 600\tStrength: 700\tAgility: 800\tDexterity: 500");
        System.out.println("\t1.3 Muamman Duathall");
        System.out.println("\t\tMana: 300\tStrength: 900\tAgility: 500\tDexterity: 750");
        System.out.println("\t1.4 Flandal Steelskin");
        System.out.println("\t\tMana: 200\tStrength: 750\tAgility: 650\tDexterity: 700");
        System.out.println("\t1.5 Undefeated Yoj");
        System.out.println("\t\tMana: 400\tStrength: 800\tAgility: 400\tDexterity: 700");
        System.out.println("\t1.6 Eunoia Cyn");
        System.out.println("\t\tMana: 400\tStrength: 700\tAgility: 800\tDexterity: 600");
        System.out.println("2. Sorcerers:");
        System.out.println("\t2.1 Rillifane Rallathil");
        System.out.println("\t\tMana: 1300\tStrength: 750\tAgility: 450\tDexterity: 500");
        System.out.println("\t2.2 Segojan Earthcaller");
        System.out.println("\t\tMana: 900\tStrength: 800\tAgility: 500\tDexterity: 650");
        System.out.println("\t2.3 Reign Havoc");
        System.out.println("\t\tMana: 800\tStrength: 800\tAgility: 800\tDexterity: 800");
        System.out.println("\t2.4 Reverie Ashels");
        System.out.println("\t\tMana: 900\tStrength: 800\tAgility: 700\tDexterity: 400");
        System.out.println("\t2.5 Kalabar");
        System.out.println("\t\tMana: 800\tStrength: 850\tAgility: 400\tDexterity: 600");
        System.out.println("\t2.6 Skye Soar");
        System.out.println("\t\tMana: 1000\tStrength: 700\tAgility: 400\tDexterity: 500");
        System.out.println("3. Paladins:");
        System.out.println("\t3.1 Parzival");
        System.out.println("\t\tMana: 300\tStrength: 750\tAgility: 650\tDexterity: 700");
        System.out.println("\t3.2 Sehanine Moonbow");
        System.out.println("\t\tMana: 300\tStrength: 750\tAgility: 700\tDexterity: 700");
        System.out.println("\t3.3 Skoraeus Stonebones");
        System.out.println("\t\tMana: 250\tStrength: 650\tAgility: 600\tDexterity: 350");
        System.out.println("\t3.4 Garl Glittergold");
        System.out.println("\t\tMana: 100\tStrength: 600\tAgility: 500\tDexterity: 400");
        System.out.println("\t3.5 Amaryllis Astra");
        System.out.println("\t\tMana: 500\tStrength: 500\tAgility: 500\tDexterity: 500");
        System.out.println("\t3.6 Caliber Heist");
        System.out.println("\t\tMana: 400\tStrength: 400\tAgility: 400\tDexterity: 400");
    }

    //Function to create instances of Hero
    public Roles getHero(String a, String b){
        if(a.equals("1")){
            if(b.equals("1")){
                return new Warrior("Gaerdal_Ironhand");
            }
            else if(b.equals("2")){
                return new Warrior("Sehanine_Monnbow");
            }
            else if(b.equals("3")){
                return new Warrior("Muamman_Duathall");
            }
            else if(b.equals("4")){
                return new Warrior("Flandal_Steelskin");
            }
            else if(b.equals("5")){
                return new Warrior("Undefeated_Yoj");
            }
            else if(b.equals("6")){
                return new Warrior("Eunoia_Cyn");
            }
        }
        else if(a.equals("2")){
            if(b.equals("1")){
                return new Sorcerer("Rillifane_Rallathil");
            }
            else if(b.equals("2")){
                return new Sorcerer("Segojan_Earthcaller");
            }
            else if(b.equals("3")){
                return new Sorcerer("Reign_Havoc");
            }
            else if(b.equals("4")){
                return new Sorcerer("Reverie_Ashels");
            }
            else if(b.equals("5")){
                return new Sorcerer("Kalabar");
            }
            else if(b.equals("6")){
                return new Sorcerer("Skye_Soar");
            }
        }
        else if(a.equals("3")){
            if(b.equals("1")){
                return new Paladin("Parzival");
            }
            else if(b.equals("2")){
                return new Paladin("Sehanine_Moonbow");
            }
            else if(b.equals("3")){
                return new Paladin("Skoraeus_Stonebones");
            }
            else if(b.equals("4")){
                return new Paladin("Garl_Glittergold");
            }
            else if(b.equals("5")){
                return new Paladin("Amaryllis_Astra");
            }
            else if(b.equals("6")){
                return new Paladin("Caliber_Heist");
            }
        }
        return null;
    }
}
