package helpers;

import environment.Position;
import org.newdawn.slick.Graphics;

public class StringPrinter {

    public void print(String s, Graphics g, Position p){
        g.drawString(s, p.getX(), p.getY());
    }
}
