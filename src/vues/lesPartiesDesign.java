/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Jeu.Jeu;
import Joueur.GestionnaireDInscription;
import java.applet.Applet;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author ilanmalka
 */
public class lesPartiesDesign extends Applet implements Observateur{

    private JTextArea zoneTexte;
    private ImagePanel monPanel;
    private GestionnaireDInscription gestionnaire;
    private Jeu j;

    public lesPartiesDesign() throws SQLException {
        this.j = new Jeu() {};
        this.monPanel = new ImagePanel("leJeu.png");
    }

    public JPanel initialisation() throws IOException {
        this.contenu();
        return this.monPanel;
    }

    public void contenu() throws IOException {
        
    }

    
    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
