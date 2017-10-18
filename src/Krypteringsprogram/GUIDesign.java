package Krypteringsprogram;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 * Created by Emil Käck on 2017-09-06.
 */
public class GUIDesign extends Canvas implements MouseListener  {

    JFrame firstFrame;
    Image img;
    Image bild;
    Graphics bdg;
    Graphics g;
    MouseEvent e;

    public GUIDesign(String url) {
        LoadImageApp(url);
        Dimension dim = new Dimension(600, 600);
        setPreferredSize(dim);
        addMouseListener(this);
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


    public void mouseClicked(MouseEvent e) {

        int clicks = 0;
        int clicks2 = 0;
        int returnValue1 = 0;
        int returnValue2 = 0;
        JFileChooser chooser1 = new JFileChooser();
        JFileChooser chooser2 = new JFileChooser();

        if ((e.getX() >= 160 && e.getX() <= 437) && (e.getY() >= 120 && e.getY() <= 245)) {
            clicks = e.getClickCount();

            chooser1.setCurrentDirectory(new java.io.File("."));
            chooser1.setDialogTitle("Encrypt File");
            returnValue1 = chooser1.showOpenDialog(GUIDesign.this);

            chooser2.setCurrentDirectory(new java.io.File("."));
            chooser2.setDialogTitle("Key");
            returnValue2 = chooser2.showOpenDialog(GUIDesign.this);

            try {

                File file1 = chooser1.getSelectedFile();
                File file2 = chooser2.getSelectedFile();
                Encrypt.readFile(file1, file2);

            } catch (NullPointerException a){

                //System.out.println("Tomt");
                a.printStackTrace();
            }

        }

        if ((e.getX() >= 166 && e.getX() <= 436) && (e.getY() >= 344 && e.getY() <= 468)) {

            clicks2 = e.getClickCount();

            chooser1.setCurrentDirectory(new java.io.File("."));
            chooser1.setDialogTitle("Decrypt File");
            returnValue1 = chooser1.showOpenDialog(GUIDesign.this);

            chooser2.setCurrentDirectory(new java.io.File("."));
            chooser2.setDialogTitle("Key");
            returnValue2 = chooser2.showOpenDialog(GUIDesign.this);
        }

        try {

            File file1 = chooser1.getSelectedFile();
            File file2 = chooser2.getSelectedFile();
            Encrypt.readFile(file1, file2);

        } catch (NullPointerException a){

            System.out.println("Tomt");

        }

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