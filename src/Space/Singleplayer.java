package Space;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Singleplayer extends JPanel implements ActionListener {
    Timer timer;
    private Player player;
    Settings s = new Settings();
    Singleplayer(){
        player = new Player(this.getWidth(),this.getY(),50, (ImageIcon) s.lblShip.getIcon());
        this.setOpaque(false);
        timer =new Timer(80,this);
        timer.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        player.paintPlayer(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
