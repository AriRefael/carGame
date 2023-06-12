import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {

    private Clip clip;

    public Audio() throws Exception {

            File file = new File("[YT2mp3.info] - Car Acceleration Sound Effect (320kbps).wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

    }

    public void stopAudio(){
        this.clip.stop();
    };
   public void startAudio(){
       this.clip.start();
   }
}
