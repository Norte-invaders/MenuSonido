package Space;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Singleplayer extends JPanel {
    private Player player;
    Timer timer;
    String ruta;
    Pausemenu pause = new Pausemenu();

    Singleplayer() {
        ruta = new String();
        setPreferredSize(new Dimension(800, 600));

        setFocusable(true);
        this.setOpaque(false);

       /* player = new Player(370, 540, 30);




        timer = new Timer(20,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                repaint();
            }});
        timer.start();
        addKeyListener(player);*/

    }

    public void createPath(String p) {
        ruta = p;
        if (ruta.isEmpty()) {
            player = new Player(470, 655, 30, "src/Space/Assets/ship1.png");
        } else {
            player = new Player(470, 655, 30, ruta);
        }


        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
        addKeyListener(player);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), null);
    }

    }