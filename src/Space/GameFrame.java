package Space;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameFrame extends JFrame implements ActionListener {
    JLayeredPane scenes;
    Menu menu;
    Settings settings;
    private GameSounds gameSounds;
    private Boolean isOffBackground;
    private Boolean isOffEffects;
    Singleplayer SinglePLayer;
    HighScore frmHighScore;
    ImageIcon icon;
    OnlineGames onlineG;
    JPanel pnlBackground;
    JLabel lblBackground;
    private int bgchoice=0;
    GameFrame(){
        declaration();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setTitle("Space Invaders");
        this.setMinimumSize(new Dimension(600,600));
        this.setIconImage(icon.getImage());
        this.add(scenes);
        scenes.setLayout(new OverlayLayout(scenes));
        scenes.add(menu, JLayeredPane.PALETTE_LAYER);
        scenes.add(pnlBackground, JLayeredPane.DEFAULT_LAYER);
        pnlBackground.setLayout(new BorderLayout());
        pnlBackground.add(lblBackground);
        lblBackground.setIcon(new ImageIcon("src/Space/Assets/outerspace-6.gif"));

        menu.btnClose.addActionListener(this);
        menu.btnSettings.addActionListener(this);
        settings.btnBack.addActionListener(this);
        menu.btnSingleplayerMode.addActionListener(this);
        menu.btnMultiplayerMode.addActionListener(this);
        settings.btnBackground.addActionListener(this);

        addSounds();

        playBackGround();


    }

    private void declaration() {
        scenes = new JLayeredPane();
        gameSounds = new GameSounds("src/Space/Music/");
        menu = new Menu();
        settings = new Settings();
        SinglePLayer = new Singleplayer();
        frmHighScore = new HighScore();
        icon = new ImageIcon("src/Space/Assets/MainIcon.png");
        onlineG = new OnlineGames();
        pnlBackground = new JPanel();
        lblBackground = new JLabel();
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
                System.out.println(isOffBackground);
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
            scenes.remove(menu);
            scenes.add(settings, JLayeredPane.PALETTE_LAYER);
            scenes.validate();
            scenes.repaint();
            isOffEffects = false;
            isOffBackground = false;
            btnMute();
            slds();
        }
        if(e.getSource()==settings.btnBack){
            scenes.remove(settings);
            scenes.add(menu, JLayeredPane.PALETTE_LAYER);
            scenes.validate();
            scenes.repaint();
        }
        if(e.getSource()==menu.btnClose){
            this.dispose();
            System.exit(0);
        }
        if(e.getSource()==menu.btnSingleplayerMode){
            scenes.remove(menu);
            scenes.add(SinglePLayer, JLayeredPane.PALETTE_LAYER);
            scenes.validate();
            scenes.repaint();
        }
        if(e.getSource()==menu.btnMultiplayerMode){
            frmHighScore.setVisible(true);
            onlineG.setVisible(true);
        }
        if(e.getSource()==settings.btnBackground){
            bgchoice= bgchoice+1;
            switch (bgchoice % 2){
                case(0):
                    lblBackground.setIcon(new ImageIcon("src/Space/Assets/outerspace-6.gif"));
                    break;
                case(1):
                    lblBackground.setIcon(new ImageIcon("src/Space/Assets/Background.jpg"));
                    break;
            }
        }
    }
}
