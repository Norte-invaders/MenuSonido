package Space;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;

public class Player implements KeyListener {
    private int x;
    private int y;
    private int speed;
    private int dx;
    private boolean shoot;
    private Image image;
    private ImageIcon ship;
    public  String shipImg;
    private int shootX;
    private int shootY;


    public Image getImage() {
        return image;
    }


    public Player(int x,int y, int speed, String loquesea){
        shipImg = new String();
        shipImg = loquesea;
        System.out.println("Segunda ruta "+shipImg);
        this.x = x;
        this.y = y;
        this.speed = speed;
        declaration();


    }
    public void declaration(){
        ship=new ImageIcon(shipImg);
        image = ship.getImage();
        shoot = false;
    }

    public void move() {
        if( x + dx >= 1230){
            dx = 0;
        }
        if ( x + dx <= -12){
            dx = 0;
        }
        System.out.println("x= " + x);
        x += dx;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(ship.getImage(), x, y, null);

        if (shoot){
            Shoot(g);
        }
    }

    private void Shoot(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRect(shootX, shootY, 5,10);
        shootY -= speed;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                dx = -speed;
                move();
                break;

            case KeyEvent.VK_RIGHT:
                dx = speed;
                move();
                break;
            case KeyEvent.VK_SPACE:
                shoot = true;
                shootX = x + 26;
                shootY = y;
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
