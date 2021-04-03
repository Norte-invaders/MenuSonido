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

    public void setVolume(String alias, float db){
        try {
            c = this.songs.get(alias);
            volCtrl = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
            if((db >=40) && (db<50)){
                db = -10f;
            }else{
                if((db >=30) && (db <40)){
                    db= -20f;
                }else{
                    if((db>= 20) && (db <30)){
                        db = -30f;
                    }else{
                        if((db>=10) && (db <20)){
                            db = -40f;
                        }else{
                            if((db>=0) && (db <10)){
                                db = -50f;
                            }else{
                                if((db>= 50) && (db<60)){
                                    db = 1f;
                                }else{
                                    if((db>= 60) && (db<70)){
                                        db = 2f;
                                    }else{
                                        if((db>=70) && (db<80)){
                                            db = 3f;
                                        }else{
                                            if((db>= 80) && (db<90)){
                                                db = 4f;
                                            }else{
                                                if((db>=90) && (db<=100)){
                                                    db = 5f;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            volCtrl.setValue(db);
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
