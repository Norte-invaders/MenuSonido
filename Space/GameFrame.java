package Space;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameFrame extends JFrame implements ActionListener {
    private JButton btnHelp;
    private JButton btnSource;
    private JButton btnClose;
    private JButton btnSettings;
    private JPanel top;
    private JPanel bottom;
    private JPanel middle;
    private JPanel menu;
    private JButton btnSingleplayerMode;
    private JButton btnMultiplayerMode;
    private JLabel lblTitle;
    private JTextField inputNickname;
    private JPanel settings;
    private JPanel scenes;
    private JSlider sldBackground;
    private JSlider sldEffects;
    private JPanel settingsTop;
    private JPanel settingsBottom;
    private JPanel settingsMiddle;
    private JLabel lblBackground;
    private JLabel lblEffects;
    private JButton btnBack;
    private JLabel lblSettings;
    private JButton btnMuteBg;
    private JButton btnMuteEf;
    private JButton btnLeft;
    private JButton btnRight;
    private JLabel lblShip;
    private JPanel settingsMiddleTop;
    private JPanel settingsMiddleBottom;
    private JPanel settingsLeft;
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

        menuArrange();

        btnApearence();

        lblAppearence();

        topArrange();

        bottomArrange();

        middleArrange();

        settingsArrange();

        btnAction();

        addSounds();

        playBackGround();

    }


    private void declaration() {
        btnHelp = new JButton();
        btnSource = new JButton();
        btnClose = new JButton();
        btnSettings = new JButton();
        btnSingleplayerMode = new JButton();
        btnMultiplayerMode = new JButton();
        lblTitle = new JLabel();
        inputNickname = new JTextField();
        top = new JPanel();
        bottom = new JPanel();
        middle = new JPanel();
        scenes = new JPanel();
        menu = new JPanel();
        settings = new JPanel();
        sldBackground = new JSlider(0,100,50);
        sldEffects = new JSlider(0,100,50);
        settingsTop = new JPanel();
        settingsMiddle = new JPanel();
        settingsBottom = new JPanel();
        lblBackground = new JLabel();
        lblEffects = new JLabel();
        btnBack = new JButton();
        lblSettings = new JLabel();
        btnMuteBg = new JButton();
        btnMuteEf = new JButton();
        btnLeft = new JButton();
        btnRight = new JButton();
        lblShip = new JLabel();
        settingsMiddleTop = new JPanel();
        settingsMiddleBottom = new JPanel();
        settingsLeft = new JPanel();
        gameSounds = new GameSounds("src/Space/Music/");
    }
    private void addSounds(){
        gameSounds.add(GameSounds.BACKGROUND, "background_DuaLipa.wav");
        gameSounds.add(GameSounds.SHOTS, "pewcorto.wav");
        gameSounds.add(GameSounds.GAMEOVER, "gameovermario.wav");
        gameSounds.add(GameSounds.ALIEN, "SpaceInvaderAlienSplash.wav");

    }
    private void btnApearence() {
        btnSource.setIcon(new ImageIcon("src/Space/Assets/GIT.png"));
        btnHelp.setIcon(new ImageIcon("src/Space/Assets/help.png"));
        btnSettings.setIcon(new ImageIcon("src/Space/Assets/settings.png"));
        btnClose.setIcon(new ImageIcon("src/Space/Assets/exiticon2.png"));
        btnSingleplayerMode.setIcon(new ImageIcon("src/Space/Assets/SINGLE3.png"));
        btnMultiplayerMode.setIcon(new ImageIcon("src/Space/Assets/multi3.png"));
        btnBack.setIcon(new ImageIcon("src/Space/Assets/returnArrow.png"));
        btnLeft.setIcon(new ImageIcon("src/Space/Assets/leftArrow.png"));
        btnRight.setIcon(new ImageIcon("src/Space/Assets/rightArrow.png"));
        btnMuteBg.setIcon(new ImageIcon("src/Space/Assets/mutebtn.jpeg"));
        btnMuteEf.setIcon(new ImageIcon("src/Space/Assets/mutebtn.jpeg"));

        btnMuteBg.setBorderPainted(false);
        btnMuteEf.setBorderPainted(false);
        btnRight.setBorderPainted(false);
        btnLeft.setBorderPainted(false);
        btnBack.setBorderPainted(false);
        btnSource.setBorderPainted(false);
        btnHelp.setBorderPainted(false);
        btnSettings.setBorderPainted(false);
        btnClose.setBorderPainted(false);
        btnSingleplayerMode.setBorderPainted(false);
        btnMultiplayerMode.setBorderPainted(false);

    }
    private void lblAppearence() {
        lblTitle.setText("<html><h1 align='CENTER'>Space Invaders</h1><h2 align='CENTER'>Remake</h2></html>");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("SEGOE UI",Font.ITALIC,12));

        lblSettings.setText("<html><h1>Settings Panel</h1></html>");
        lblSettings.setForeground(Color.white);
        lblSettings.setFont(new Font("SEGOE UI",Font.ITALIC,12));

        lblBackground.setText("<html><h2>Background Volume</h2></html>");
        lblBackground.setForeground(Color.white);
        lblBackground.setFont(new Font("SansSerif Bold",Font.ITALIC,12));

        lblEffects.setText("<html><h2>Effects Volume</h2></html>");
        lblEffects.setForeground(Color.white);
        lblEffects.setFont(new Font("SansSerif Bold",Font.ITALIC,12));

    }
    private void sliderAppearence() {
        sldBackground.setMaximumSize(new Dimension(690,40));
        sldEffects.setMaximumSize(new Dimension(690,40));

        sldBackground.setPaintTicks(true);
        sldBackground.setMajorTickSpacing(10);
        sldBackground.setPaintTrack(true);
        sldBackground.setPaintLabels(true);
        sldBackground.setFont(new Font("SEGOE UI",Font.ITALIC,12));
        sldBackground.setOpaque(false);
        sldBackground.setForeground(Color.white);
        sldBackground.setSnapToTicks(true);

        sldEffects.setPaintTicks(true);
        sldEffects.setMajorTickSpacing(10);
        sldEffects.setPaintTrack(true);
        sldEffects.setPaintLabels(true);
        sldEffects.setFont(new Font("SEGOE UI",Font.ITALIC,12));
        sldEffects.setOpaque(false);
        sldEffects.setForeground(Color.white);
        sldEffects.setSnapToTicks(true);
    }
    private void menuArrange(){
        menu.setLayout(new BorderLayout());
        menu.setBackground(Color.BLACK);
        menu.setOpaque(true);
        menu.add(top, BorderLayout.NORTH);
        menu.add(bottom, BorderLayout.SOUTH);
        menu.add(middle, BorderLayout.CENTER);
    }
    private void topArrange() {
        top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));
        top.setPreferredSize(new Dimension(100,60));
        top.add(btnSource);
        top.add(Box.createHorizontalGlue());
        top.add(btnHelp);
        top.setOpaque(false);

        btnHelp.setPreferredSize(new Dimension(71,60));
        btnHelp.setMaximumSize(new Dimension(71,60));
        btnSource.setPreferredSize(new Dimension(71,60));
        btnSource.setMaximumSize(new Dimension(71,60));
    }
    private void middleArrange() {
        middle.setLayout(new BoxLayout(middle, BoxLayout.PAGE_AXIS));
        middle.setPreferredSize(new Dimension(100,100));
        middle.add(Box.createRigidArea(new Dimension(0,80)));
        middle.add(lblTitle);
        middle.add(Box.createRigidArea(new Dimension(0,60)));
        middle.add(inputNickname);
        middle.add(Box.createRigidArea(new Dimension(0,10)));
        middle.add(btnSingleplayerMode);
        middle.add(Box.createRigidArea(new Dimension(0,10)));
        middle.add(btnMultiplayerMode);
        middle.setOpaque(false);

        btnSingleplayerMode.setPreferredSize(new Dimension(180,51));
        btnSingleplayerMode.setMaximumSize(new Dimension(180,51));
        btnMultiplayerMode.setPreferredSize(new Dimension(200,51));
        btnMultiplayerMode.setMaximumSize(new Dimension(200,51));

        inputNickname.setText("NICKNAME");
        inputNickname.setBackground(Color.BLACK);
        inputNickname.setForeground(Color.WHITE);
        inputNickname.setHorizontalAlignment(JTextField.CENTER);
        inputNickname.setPreferredSize(new Dimension(100,30));
        inputNickname.setMaximumSize(new Dimension(100,30));
        inputNickname.setAlignmentX(JTextField.CENTER_ALIGNMENT);

        lblTitle.setMaximumSize(new Dimension(172,100));
        lblTitle.setPreferredSize(new Dimension(172,100));
        lblTitle.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        btnSingleplayerMode.setAlignmentX(JButton.CENTER_ALIGNMENT);
        btnMultiplayerMode.setAlignmentX(JButton.CENTER_ALIGNMENT);
    }
    private void bottomArrange() {
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.LINE_AXIS));
        bottom.setPreferredSize(new Dimension(100,70));
        bottom.add(btnClose);
        bottom.add(Box.createHorizontalGlue());
        bottom.add(btnSettings);
        bottom.setOpaque(false);

        btnClose.setPreferredSize(new Dimension(80,90));
        btnClose.setMaximumSize(new Dimension(80,90));
        btnSettings.setPreferredSize(new Dimension(80,90));
        btnSettings.setMaximumSize(new Dimension(80,90));
    }
    private void settingsArrange() {
        settings.setBackground(Color.BLACK);
        settings.setLayout(new BorderLayout());
        settings.add(settingsTop, BorderLayout.NORTH);
        settings.add(settingsMiddle, BorderLayout.CENTER);
        settings.add(settingsBottom, BorderLayout.SOUTH);
        settings.add(settingsLeft, BorderLayout.WEST);

        settingsTop.setLayout(new BoxLayout(settingsTop, BoxLayout.LINE_AXIS));
        settingsMiddle.setLayout(new BoxLayout(settingsMiddle, BoxLayout.PAGE_AXIS));
        settingsBottom.setLayout(new FlowLayout());
        settingsMiddleTop.setLayout(new BoxLayout(settingsMiddleTop, BoxLayout.LINE_AXIS));
        settingsMiddleBottom.setLayout(new BoxLayout(settingsMiddleBottom, BoxLayout.LINE_AXIS));

        settingsTop.setOpaque(false);
        settingsMiddle.setOpaque(false);
        settingsBottom.setOpaque(false);
        settingsLeft.setOpaque(false);
        settingsMiddleTop.setOpaque(false);
        settingsMiddleBottom.setOpaque(false);

        btnBack.setPreferredSize(new Dimension(70,60));
        btnBack.setMaximumSize(new Dimension(70,60));

        sliderAppearence();

        settingsLeft.setPreferredSize(new Dimension(42,100));

        settingsTop.add(lblSettings);
        settingsTop.add(Box.createHorizontalGlue());
        settingsTop.add(btnBack);

        settingsMiddle.add(Box.createRigidArea(new Dimension(0,20)));
        settingsMiddle.add(lblBackground);
        lblBackground.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        settingsMiddle.add(settingsMiddleTop);
        settingsMiddleTop.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        settingsMiddle.add(Box.createRigidArea(new Dimension(0,80)));
        settingsMiddle.add(lblEffects);
        lblEffects.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        settingsMiddle.add(settingsMiddleBottom);
        settingsMiddleBottom.setAlignmentX(JPanel.LEFT_ALIGNMENT);

        settingsMiddleTop.add(sldBackground);
        settingsMiddleTop.add(btnMuteBg);
        settingsMiddleBottom.add(sldEffects);
        settingsMiddleBottom.add(btnMuteEf);

        settingsBottom.add(btnLeft);
        settingsBottom.add(lblShip);
        settingsBottom.add(btnRight);

        lblShip.setMaximumSize(new Dimension(70,60));
        btnLeft.setPreferredSize(new Dimension(70,60));
        btnLeft.setMaximumSize(new Dimension(70,60));
        btnRight.setPreferredSize(new Dimension(70,60));
        btnRight.setMaximumSize(new Dimension(70,60));
        btnMuteEf.setMaximumSize(new Dimension(50,50));
        btnMuteBg.setMaximumSize(new Dimension(50,50));
        lblShip.setIcon(new ImageIcon("src/Space/Assets/shipdemo2.png"));
    }
    private void btnAction() {
        btnSettings.addActionListener(this);
        btnSource.addActionListener(this);
        btnBack.addActionListener(this);
        btnClose.addActionListener(this);
    }
    private void playBackGround(){ gameSounds.play("background"); }

    public void slds(){
        sldBackground.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(sldBackground.getValue());
                int value = sldBackground.getValue();
                gameSounds.setVolume("background", value);
            }
        });
        sldEffects.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = sldEffects.getValue();
                gameSounds.setVolume("alien", value);
                gameSounds.setVolume("shots", value);
                gameSounds.setVolume("gameover", value);
            }
        });
    }
    public void btnMute(){
        btnMuteBg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(isOffBackground);
                isOffBackground = !isOffBackground;
                gameSounds.mute("background", isOffBackground);



            }
        });
        btnMuteEf.addActionListener(new ActionListener() {
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
        if(e.getSource()==btnSettings){
            scenes.removeAll();
            scenes.add(settings);
            scenes.validate();
            scenes.repaint();
            isOffEffects = false;
            isOffBackground = false;
            btnMute();
            slds();
        }
        if (e.getSource()==btnSource){
            try {
                Desktop.getDesktop().browse(URI.create("https://github.com/Norte-invaders"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if(e.getSource()==btnBack){
            scenes.removeAll();
            scenes.add(menu);
            scenes.validate();
            scenes.repaint();
        }
        if(e.getSource()==btnClose){
            this.dispose();
        }
    }
}
