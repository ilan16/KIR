/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;


import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author ilanmalka
 */
public class ImagePanel extends JPanel {
    
    private String img;
    
    public ImagePanel(String img){
        this.img = img;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        try {
            Image img_fond = ImageIO.read(new File("Images/"+this.img));
            g.drawImage(img_fond, 0, 0, this);
            //JPanel PanelSud = panelSud();
            this.revalidate();
            this.repaint();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
