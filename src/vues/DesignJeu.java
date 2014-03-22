/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Joueur.GestionnaireDInscription;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ilanmalka
 */
public class DesignJeu extends Applet implements Observateur {

    private ImagePanel monPanel;
    private GestionnaireDInscription gestionnaire;

    public DesignJeu() throws SQLException {
        this.monPanel = new ImagePanel("fondJeu.png");
        this.gestionnaire = new GestionnaireDInscription("jdbc:mysql://localhost:8889/bdd_kir?zeroDateTimeBehavior=convertToNull", "root", "root");
    }
    
    public JPanel initialisation() {
        this.contenu();
        return this.monPanel;
    }
     
    public void contenu(){
        
        JPanel haut = new JPanel();
        haut.setOpaque(false);
        haut.setLayout((new BoxLayout(haut, BoxLayout.PAGE_AXIS)));
        
        JLabel niveau = new JLabel("                                                Type niveau");
        Font titreNiveau = new Font("Apple Chancery", Font.BOLD, 40);
        niveau.setFont(titreNiveau);
        haut.add(niveau);
        
        JLabel consigne = new JLabel("                                "
                + "                                           "
                + "                                             **** Ne pas mettre d'espaces ****");
        Font titreConsigne = new Font("Courier New", Font.ITALIC, 14);
        haut.add(consigne);
        
        this.monPanel.add(haut);
        
        JPanel centre = new JPanel();
        centre.setLayout((new BoxLayout(centre, BoxLayout.LINE_AXIS)));
        
        // cote gauche
        
        JPanel gauche = new JPanel();
        gauche.setBackground(Color.red);
        gauche.setPreferredSize(new Dimension(150, 150));
        
        JLabel textGauche = new JLabel();
        textGauche.setText("toto");
        
        
        //cote droit
        
        JPanel droit = new JPanel();
        droit.setBackground(Color.BLUE);
        droit.setPreferredSize(new Dimension(150, 150));
        
        JLabel textDroit = new JLabel();
        
        
        centre.add(gauche);
        centre.add(droit);
        
        this.monPanel.add(centre);
        
    }



    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
