package Space;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JPanel implements ActionListener {
    public JSlider sldBackground;
    public JSlider sldEffects;
    private JPanel settingsTop;
    private JPanel settingsBottomMid;
    private JPanel settingsMiddle;
    private JLabel lblBackground;
    private JLabel lblEffects;
    public JButton btnBack;
    private JLabel lblSettings;
    public JButton btnMuteBg;
    public JButton btnMuteEf;
    private JButton btnLeft;
    private JButton btnRight;
    public JLabel lblShip;
    private JPanel settingsMiddleTop;
    private JPanel settingsMiddleBottom;
    private JPanel settingsBottom;
    public JButton btnBackground;
    public int choice;
    public  String shipImg;

    Settings(){
        declaration();
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(settingsTop, BorderLayout.NORTH);
        this.add(settingsMiddle, BorderLayout.CENTER);
        this.add(settingsBottom, BorderLayout.SOUTH);

        settingsTop.setLayout(new BoxLayout(settingsTop, BoxLayout.LINE_AXIS));
        settingsMiddle.setLayout(new BoxLayout(settingsMiddle, BoxLayout.PAGE_AXIS));
        settingsBottom.setLayout(new BorderLayout());
        settingsBottomMid.setLayout(new FlowLayout());
        settingsMiddleTop.setLayout(new BoxLayout(settingsMiddleTop, BoxLayout.LINE_AXIS));
        settingsMiddleBottom.setLayout(new BoxLayout(settingsMiddleBottom, BoxLayout.LINE_AXIS));

        settingsTop.setOpaque(false);
        settingsMiddle.setOpaque(false);
        settingsBottomMid.setOpaque(false);
        settingsBottom.setOpaque(false);
        settingsMiddleTop.setOpaque(false);
        settingsMiddleBottom.setOpaque(false);

        lblAppearence();
        btnApearence();

        btnBack.setPreferredSize(new Dimension(70,60));
        btnBack.setMaximumSize(new Dimension(70,60));

        sliderAppearence();

        settingsMiddle.setBorder(new EmptyBorder(0,35,0,0));
        settingsBottom.setBorder(new EmptyBorder(0,60,0,0));

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

        settingsBottom.add(settingsBottomMid, BorderLayout.CENTER);
        settingsBottom.add(btnBackground, BorderLayout.EAST);
        settingsBottomMid.add(btnLeft);
        settingsBottomMid.add(lblShip);
        settingsBottomMid.add(btnRight);

        lblShip.setMaximumSize(new Dimension(70,60));
        btnLeft.setPreferredSize(new Dimension(70,60));
        btnLeft.setMaximumSize(new Dimension(70,60));
        btnRight.setPreferredSize(new Dimension(70,60));
        btnRight.setMaximumSize(new Dimension(70,60));
        btnMuteEf.setMaximumSize(new Dimension(50,50));
        btnMuteBg.setMaximumSize(new Dimension(50,50));
        lblShip.setIcon(new ImageIcon("src/Space/Assets/ship1.png"));
        btnBackground.setPreferredSize(new Dimension(70,60));
        btnBackground.setMaximumSize(new Dimension(70,60));

        btnLeft.addActionListener(this);
        btnRight.addActionListener(this);
    }
    private void declaration() {
        sldBackground = new JSlider(0,100,50);
        sldEffects = new JSlider(0,100,50);
        settingsTop = new JPanel();
        settingsMiddle = new JPanel();
        settingsBottomMid = new JPanel();
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
        settingsBottom = new JPanel();
        choice = 0;
        btnBackground = new JButton();
        shipImg = new String();
    }
    private void lblAppearence() {

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
    private void btnApearence() {
        btnBack.setIcon(new ImageIcon("src/Space/Assets/returnArrow.png"));
        btnLeft.setIcon(new ImageIcon("src/Space/Assets/leftArrow.png"));
        btnRight.setIcon(new ImageIcon("src/Space/Assets/rightArrow.png"));
        btnMuteBg.setIcon(new ImageIcon("src/Space/Assets/soundbtn.png"));
        btnMuteEf.setIcon(new ImageIcon("src/Space/Assets/soundbtn.png"));
        btnBackground.setIcon(new ImageIcon("src/Space/Assets/BackgroundIcon.png"));

        btnMuteBg.setBorderPainted(false);
        btnMuteEf.setBorderPainted(false);
        btnRight.setBorderPainted(false);
        btnLeft.setBorderPainted(false);
        btnBack.setBorderPainted(false);
        btnBackground.setBorderPainted(false);


        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
        btnRight.setOpaque(false);
        btnRight.setContentAreaFilled(false);
        btnLeft.setOpaque(false);
        btnLeft.setContentAreaFilled(false);
        btnBackground.setOpaque(false);
        btnBackground.setContentAreaFilled(false);
        btnBackground.setFocusable(false);

        btnMuteBg.setOpaque(false);
        btnMuteBg.setContentAreaFilled(false);
        btnMuteEf.setOpaque(false);
        btnMuteEf.setContentAreaFilled(false);
        btnMuteEf.setFocusable(false);
        btnMuteBg.setFocusable(false);

        btnBack.setRolloverIcon(new ImageIcon("src/Space/Assets/returnArrowS.png"));
        btnRight.setRolloverIcon(new ImageIcon("src/Space/Assets/rightArrowS.png"));
        btnLeft.setRolloverIcon(new ImageIcon("src/Space/Assets/leftArrowS.png"));
        btnBackground.setRolloverIcon(new ImageIcon("src/Space/Assets/BackgroundIconS.png"));
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
    public void setChoice() {
            switch (choice) {
                case (0):
                    shipImg = "src/Space/Assets/ship1.png";
                    lblShip.setIcon(new ImageIcon(shipImg));
                    break;
                case (1):
                    shipImg = "src/Space/Assets/ship2.png";
                    lblShip.setIcon(new ImageIcon(shipImg));
                    break;
                case (2):
                    shipImg = "src/Space/Assets/ship3.png";
                    lblShip.setIcon(new ImageIcon(shipImg));
                    break;
                case (3):
                    shipImg = "src/Space/Assets/ship4.png";
                    lblShip.setIcon(new ImageIcon(shipImg));
                    break;
                case (4):
                    shipImg = "src/Space/Assets/ship5.png";
                    lblShip.setIcon(new ImageIcon(shipImg));
                    break;
                case (5):
                    shipImg = "src/Space/Assets/ship6.png";
                    lblShip.setIcon(new ImageIcon(shipImg));
                    break;
                case (6):
                    shipImg = "src/Space/Assets/ship7.png";
                    lblShip.setIcon(new ImageIcon(shipImg));
                    break;
                case (7):
                    shipImg = "src/Space/Assets/ship8.png";
                    lblShip.setIcon(new ImageIcon(shipImg));
                    break;
                case (8):
                    shipImg = "src/Space/Assets/ship9.png";
                    lblShip.setIcon(new ImageIcon(shipImg));
                    break;
            }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==btnLeft) {
            if(choice>=1){
            choice = choice - 1;
            setChoice();
            }
        }
            if(actionEvent.getSource()==btnRight) {
                if(choice<8){
                choice = choice + 1;
                setChoice();
                }
        }
    }
}
