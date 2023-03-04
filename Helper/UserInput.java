package LegendsCode;
import java.util.*;;

public class UserInput {
    private Scanner userInput = new Scanner(System.in);
    private String userResponse;

    public void getUserInput(){
        userResponse = userInput.nextLine();
    }
    
    public String getUserResponse() {
        return userResponse;
    }

    public Boolean checkInput(String expectedInput){
        if(userResponse.equalsIgnoreCase(expectedInput)){
            return true;
        }
        else{
            return false;
        }
    }
}
