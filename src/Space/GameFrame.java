package Space;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameFrame extends JFrame implements ActionListener {
    JPanel scenes;
    Menu menu;
    Settings settings;
    private GameSounds gameSounds;
    private Boolean isOffBackground;
    private Boolean isOffEffects;

    GameFrame(){
        declaration();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setTitle("Space Invaders");
        this.setMinimumSize(new Dimension(600,600));
        this.add(scenes);
        scenes.setLayout(new CardLayout());
        scenes.add(menu);
        scenes.setOpaque(true);
        scenes.add(settings);
        menu.btnClose.addActionListener(this);
        menu.btnSettings.addActionListener(this);
        settings.btnBack.addActionListener(this);

        addSounds();

        playBackGround();

    }

    private void declaration() {
        scenes = new JPanel();
        gameSounds = new GameSounds("src/Space/Music/");
        menu = new Menu();
        settings = new Settings();
    }
    private void addSounds(){
        gameSounds.add(GameSounds.BACKGROUND, "background_DuaLipa.wav");
        gameSounds.add(GameSounds.SHOTS, "pewcorto.wav");
        gameSounds.add(GameSounds.GAMEOVER, "gameovermario.wav");
        gameSounds.add(GameSounds.ALIEN, "SpaceInvaderAlienSplash.wav");

    }
    private void playBackGround(){ gameSounds.play("background"); }

    public void slds(){
        settings.sldBackground.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(settings.sldBackground.getValue());
                int value = settings.sldBackground.getValue();
                gameSounds.setVolume("background", value);
            }
        });
        settings.sldEffects.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = settings.sldEffects.getValue();
                gameSounds.setVolume("alien", value);
                gameSounds.setVolume("shots", value);
                gameSounds.setVolume("gameover", value);
            }
        });
    }
    public void btnMute(){
        settings.btnMuteBg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isOffBackground = !isOffBackground;
                gameSounds.mute("background", isOffBackground);
            }
        });
        settings.btnMuteEf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isOffEffects = !isOffEffects;
                gameSounds.mute("shots", isOffEffects);
                gameSounds.mute("alien", isOffEffects);
                gameSounds.mute("gameover", isOffEffects);

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menu.btnSettings){
            scenes.removeAll();
            scenes.add(settings);
            scenes.validate();
            scenes.repaint();
            isOffEffects = false;
            isOffBackground = false;
            btnMute();
            slds();
        }
        if(e.getSource()==settings.btnBack){
            scenes.removeAll();
            scenes.add(menu);
            scenes.validate();
            scenes.repaint();
        }
        if(e.getSource()==menu.btnClose){
            this.dispose();
        }
    }
}
