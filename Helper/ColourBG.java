package LegendsCode;

public class ColourBG {
    private final String redBG = "\u001B[41m";
    private final String greenBG = "\u001B[42m";
    private final String yellowBG = "\u001B[43m";
    private final String blueBG = "\u001B[44m";
    private final String purpleBG = "\u001B[45m";
    private final String resetBG = "\u001B[0m";
    private final String whiteBG = "\u001B[47m";    
    
    public String getWhitebg() {
        return whiteBG;
    }

    public String getRedbg() {
        return redBG;
    }

    public String getGreenbg() {
        return greenBG;
    }

    public String getYellowbg() {
        return yellowBG;
    }

    public String getBluebg() {
        return blueBG;
    }

    public String getPurplebg() {
        return purpleBG;
    }

    public String getResetbg() {
        return resetBG;
    }
}