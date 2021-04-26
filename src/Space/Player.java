package Space;

import javax.swing.*;
import java.awt.*;

public class Player {
    private int x;
    private int y;
    private int speed;
    Settings s = new Settings();
    public Player(int x, int y, int speed){
        this.x=x;
        this.y = y;
        this.speed=speed;

    }
    public void paintPlayer(Graphics g){
        Graphics2D g2D= (Graphics2D) g;
        g2D.drawImage(new ImageIcon("").getImage(),x,y,null);
    }
}
