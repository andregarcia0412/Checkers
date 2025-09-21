import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Audio {
    private AudioInputStream audioStream;
    private Clip clip;

    Audio(InputStream inputStream){
        try{
            InputStream bufferedIn = new BufferedInputStream(inputStream);
            this.audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            this.clip = AudioSystem.getClip();
            this.clip.open(this.audioStream);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void play(){
        this.clip.stop();
        this.clip.setFramePosition(0);
        this.clip.start();
    }
}
