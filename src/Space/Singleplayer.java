package Space;

import javax.swing.*;
import java.awt.*;

public class Singleplayer extends JPanel{
    Singleplayer(){

    }
    public void paint(Graphics2D g){
        Graphics2D g2D =  (Graphics2D) g;
        g2D.drawLine(0,0,500,500);
    }
}
