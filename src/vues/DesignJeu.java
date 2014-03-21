/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Joueur.GestionnaireDInscription;
import java.applet.Applet;
import java.sql.SQLException;
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
        
    }


    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
