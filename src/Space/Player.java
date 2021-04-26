package Space;

import javax.swing.*;
import java.awt.*;

public class Player {
    private int x;
    private int y;
    private int speed;
    private ImageIcon ship;
    public Player(int x, int y, int speed,ImageIcon ship){
        this.x=x;
        this.y = y;
        this.speed=speed;
        this.ship =ship;
    }
    public void paintPlayer(Graphics g){
        Graphics2D g2D= (Graphics2D) g;
        g2D.drawImage(ship.getImage(),x,y,null);
    }
}
