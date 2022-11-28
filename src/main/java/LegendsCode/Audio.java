package LegendsCode;
import java.io.File; 
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio{
    public void playAudio(String soundName){
        try 
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start(); //start to play the clip
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } 
        catch (Exception e) 
        {
            //Do stuff in case of an exception, for example, file not found
        }
    }
}