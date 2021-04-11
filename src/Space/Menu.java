package Space;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

public class Menu extends JPanel implements ActionListener {
    private JButton btnHelp;
    private JButton btnSource;
    public JButton btnClose;
    public JButton btnSettings;
    private JPanel top;
    private JPanel bottom;
    private JPanel middle;
    public JButton btnSingleplayerMode;
    public JButton btnMultiplayerMode;
    private JLabel lblTitle;
    private JTextField inputNickname;
    Menu(){
        declaration();
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.add(top, BorderLayout.NORTH);
        this.add(bottom, BorderLayout.SOUTH);
        this.add(middle, BorderLayout.CENTER);

        lblAppearence();
        btnApearence();

        topArrange();
        middleArrange();
        bottomArrange();
        btnAction();
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
    }
    private void lblAppearence() {
        lblTitle.setText("<html><h1 align='CENTER'>Space Invaders</h1><h2 align='CENTER'>Remake</h2></html>");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("SEGOE UI",Font.ITALIC,12));

    }
    private void btnApearence() {
        btnSource.setIcon(new ImageIcon("src/Space/Assets/GIT.png"));
        btnHelp.setIcon(new ImageIcon("src/Space/Assets/help.png"));
        btnSettings.setIcon(new ImageIcon("src/Space/Assets/settings.png"));
        btnClose.setIcon(new ImageIcon("src/Space/Assets/exiticon2.png"));
        btnSingleplayerMode.setIcon(new ImageIcon("src/Space/Assets/SINGLE3.png"));
        btnMultiplayerMode.setIcon(new ImageIcon("src/Space/Assets/multi3.png"));

        btnSource.setBorderPainted(false);
        btnHelp.setBorderPainted(false);
        btnSettings.setBorderPainted(false);
        btnClose.setBorderPainted(false);
        btnSingleplayerMode.setBorderPainted(false);
        btnMultiplayerMode.setBorderPainted(false);
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
    private void btnAction() {
        btnSource.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnSource){
            try {
                Desktop.getDesktop().browse(URI.create("https://github.com/Norte-invaders"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
