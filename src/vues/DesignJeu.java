/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Joueur.GestionnaireDInscription;
import java.applet.Applet;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Jeu.*;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ilanmalka
 */
public class DesignJeu extends Applet implements Observateur {

    private ImagePanel monPanel;
    private GestionnaireDInscription gestionnaire;
    private Jeu j=new Jeu() {};

    public DesignJeu() throws SQLException {
        this.monPanel = new ImagePanel("fondJeu.png");
    }
    
    public JPanel initialisation() throws IOException {
        this.contenu();
        return this.monPanel;
    }
     
    public void contenu() throws IOException{
        
        JPanel haut = new JPanel();
        haut.setOpaque(false);
        haut.setLayout((new BoxLayout(haut, BoxLayout.PAGE_AXIS)));
        
        JLabel niveau = new JLabel("                      Type niveau                            ");
        Font titreNiveau = new Font("Apple Chancery", Font.BOLD, 40);
        niveau.setFont(titreNiveau);
        haut.add(niveau);
        

        
        this.monPanel.add(haut);
        
        JPanel centre = new JPanel();
        centre.setLayout((new BoxLayout(centre, BoxLayout.LINE_AXIS)));
        
        // cote gauche
        
        JPanel gauche = new JPanel();
        gauche.setBackground(Color.white);
        gauche.setPreferredSize(new Dimension(400,500 ));
        
        System.out.println(j.AfficherEnoncer(1));
        JLabel textGauche = new JLabel("<html>   "+j.AfficherEnoncer(1)+"</html>");
        Font texte2 = new Font("Apple Chancery", 0, 13);
        gauche.setLayout(new FlowLayout(FlowLayout.LEFT));
        textGauche.setFont(texte2);
        gauche.add(textGauche);
        
        
        this.monPanel.add(gauche);
        
        //cote droit
        
        JPanel droit = new JPanel();
        droit.setBackground(Color.BLUE);
        droit.setPreferredSize(new Dimension(400, 500));
        
        JLabel textDroit = new JLabel();
        
        
        
        centre.add(droit);
        this.monPanel.add(droit);
        
        
    }



    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
