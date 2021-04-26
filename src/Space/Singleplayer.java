package Space;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Singleplayer extends JPanel implements ActionListener {
    Timer timer;
    private Player player;
    Singleplayer(){
        timer =new Timer(80,this);
        timer.start();
        player = new Player(this.getWidth(),0,50);
    }
    public void paint(Graphics g){
        super.paint(g);
        player.paintPlayer(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
