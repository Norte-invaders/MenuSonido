package Space;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Singleplayer extends JPanel {
    private Player player;
    Timer timer;
    Singleplayer(){
        setPreferredSize(new Dimension(800, 600));

        setFocusable(true);

        player = new Player(370, 540, 30);

        this.setOpaque(false);

        timer = new Timer(20,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                repaint();
            }});
        timer.start();
        addKeyListener(player);


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), null);
        //player.draw(g);
    }

}
