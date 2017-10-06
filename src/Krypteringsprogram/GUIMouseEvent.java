package Krypteringsprogram;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Emil Käck on 2017-10-04.
 */
public class GUIMouseEvent implements MouseListener {


    public void mouseClicked(MouseEvent e) {
        int clicks = 0;
        int clicks2 = 0;

        if((e.getX() >= 160 && e.getX() <= 437) && (e.getY() >= 120 && e.getY() <= 245)){
            clicks = e.getClickCount();
        }
        if((e.getX() >= 166 && e.getX() <= 436) && (e.getY() >= 344 && e.getY() <= 468)){
            clicks2 = e.getClickCount();
        }
        int x = e.getX();
        int y = e.getY();
        System.out.println( x + " " + y + " " + clicks + " " + clicks2);
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {


    }
}