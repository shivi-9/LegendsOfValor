package LegendsCode;
import java.util.*;;

/* Instance generator factory for Monsters typed Roles */
public class MonsterFactory {
    private Random random = new Random();
    //Function to create instances of Monster
    public ArrayList<Roles> getMonster(ArrayList<Roles> heroList){
        int temp; 
        ArrayList<Roles> mList = new ArrayList<Roles>();
        for(int i = 0; i < heroList.size(); i++){
            temp = random.nextInt(3);
            Monster m;
            if(temp == 0){
                m = new Dragon();
                Boolean monsterCreated = true;
                while(monsterCreated){
                    if(((Dragon) m).createMonster(heroList.get(i).getLevel())){
                        monsterCreated = false;
                    }
                }
                mList.add(m);
            }
            else if(temp == 1){
                m = new Exoskeletons();
                Boolean monsterCreated = true;
                while(monsterCreated){
                    if(((Exoskeletons) m).createMonster(heroList.get(i).getLevel())){
                        monsterCreated = false;
                    }
                }
                mList.add(m);
            }
            else if(temp == 2){
                m = new Spirits();
                Boolean monsterCreated = true;
                while(monsterCreated){
                    if(((Spirits) m).createMonster(heroList.get(i).getLevel())){
                        monsterCreated = false;
                    }
                }
                mList.add(m);
            }
        }
        return mList;
    }
}
