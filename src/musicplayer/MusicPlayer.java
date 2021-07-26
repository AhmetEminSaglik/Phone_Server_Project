package musicplayer;

import music.musicpath.MusicPath;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MusicPlayer {

    public Clip clip = null;
    int clipLoop;
    float volume;

    public void playMusicRingTone() {
        playMusic(new MusicPath().getNokiaRingTone());
    }

    public void playMusicTextNotification() {
        try {
            if (!clip.isRunning()) {
                playMusic(new MusicPath().getTextNotification());
            }
        } catch (NullPointerException ex) {
            System.out.println("NULL POINTERDAYYIUZ ");
            playMusic(new MusicPath().getTextNotification());
        }
    }

    private void playMusic(String musicPath) {
        try {
//            stopMusic();
            AudioInputStream stream = AudioSystem.getAudioInputStream(new File(musicPath));

            clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
            clip.loop(clipLoop);

            FloatControl gainControl
                    = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume); // Reduce volume by 10 decibels.
            clip.start();

        } catch (LineUnavailableException ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void setLoopContinuously() {
        clipLoop = Clip.LOOP_CONTINUOUSLY;
    }

    void setLoopOneTime() {
        clipLoop = 0;
    }

    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}

