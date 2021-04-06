package Space;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.util.HashMap;

public class GameSounds {
    static final String BACKGROUND = "background";
    static final String SHOTS = "shots";
    static final String ALIEN = "alien";
    static final String GAMEOVER = "gameover";

    private final String basePath;
    private final HashMap<String, Clip> songs;

    Clip c;
    FloatControl volCtrl;

    public GameSounds(String path) {
        this.basePath = path;
        this.songs = new HashMap<>();
    }

    public void add(String alias, String soundPath) {
        try {
            c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(new File(this.basePath + soundPath)));
            this.songs.put(alias, c);

        } catch(Exception exc){
            System.out.println(exc);
        }
    }

    public void setVolume(String alias, int db){
        try {
            c = this.songs.get(alias);
            volCtrl = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
            switch (db) {
                case 0 -> db = (int) -60f;
                case 10 -> db = (int) -37f;
                case 20 -> db = (int) -27f;
                case 30 -> db = (int) -20f;
                case 40 -> db = (int) -7f;
                case 50 -> db = (int) 0f;
                case 60 -> db = (int) 1f;
                case 70 -> db = (int) 2f;
                case 80 -> db = (int) 3f;
                case 90 -> db = (int) 4f;
                case 100 -> db = (int) 5f;
            }
            if ((db>-61) && (db<6)){
                volCtrl.setValue(db);
            }

        }catch(Exception exc){
            System.out.println(exc);
        }
    }

    public void mute(String alias, Boolean op){
        c = this.songs.get(alias);
        BooleanControl muteCtrl = (BooleanControl) c.getControl(BooleanControl.Type.MUTE);
        muteCtrl.setValue(op);

    }

    public void play(String alias) {
        c = this.songs.get(alias);
        c.setFramePosition(0);
        c.start();
        c.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void overridePlay(String alias) {
        this.songs.get(BACKGROUND).close();
        this.play(alias);
    }





}
