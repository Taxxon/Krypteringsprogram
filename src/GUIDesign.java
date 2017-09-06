import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 * Created by Emil Käck on 2017-09-06.
 */
public class GUIDesign extends Canvas {

    JFrame frame;
    Image img;
    Image bild;
    Graphics bdg;
    Graphics g;

    public GUIDesign() {
        LoadImageApp();
        Dimension dim = new Dimension(600, 602);
        setPreferredSize(dim);
        frame = new JFrame("Encryption Program");
        frame.add(this);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void LoadImageApp() {
        try {
            bild = ImageIO.read(new File("Gui.png"));
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
                bdg = bild.getGraphics();
            }
            bdg.fillRect(0, 0, (bild.getWidth(null)), bild.getHeight(null));
            draw(bdg);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(bild, 0, 0, null);
    }
}
