package Krypteringsprogram;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 * Created by Emil Käck on 2017-09-06.
 */
public class GUIDesign extends Canvas  {

    GUIMouseEvent gme = new GUIMouseEvent();
    JFrame firstFrame;
    Image img;
    Image bild;
    Graphics bdg;
    Graphics g;

    public GUIDesign(String url) {
        LoadImageApp(url);
        Dimension dim = new Dimension(600, 600);
        setPreferredSize(dim);
        addMouseListener(gme);
        firstFrame = new JFrame("Encryption Program");
        firstFrame.add(this);
        firstFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        firstFrame.pack();
        firstFrame.setVisible(true);
        this.repaint();

    }

    public void LoadImageApp(String url) {
        try {
            bild = ImageIO.read(new File(url));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void paint(Graphics bdg) {
        if (img == null) {
            img = createImage(bild.getWidth(null), bild.getHeight(null));
            if (img == null) {
                System.out.println("Img is still null");
                return;
            } else {
                bdg = img.getGraphics();
            }
            bdg.fillRect(0, 0, (bild.getWidth(null)), bild.getHeight(null));
            draw(bdg);
        }
        bdg.fillRect(0, 0, (bild.getWidth(null)), bild.getHeight(null));
        draw(bdg);
    }

    public void draw(Graphics g) {
        g.drawImage(bild, 0, 0, null);
    }
}