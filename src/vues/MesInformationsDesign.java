/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Joueur.Connect;
import Joueur.GestionnaireDInscription;
import Joueur.GestionnaireJoueur;
import Joueur.Information;
import java.applet.Applet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ilanmalka
 */
public class MesInformationsDesign extends Applet implements Observateur {
    
    private JPanel monContenu;
    private Connect connexion;
    private Information infos;
    private GestionnaireJoueur gj;
    private GestionnaireDInscription gestionnaire;

    public MesInformationsDesign() throws SQLException {
        this.monContenu = new JPanel();
        this.monContenu.setOpaque(false);
        this.gj = new GestionnaireJoueur();
        this.connexion = new Connect("jdbc:mysql://localhost:8889/bdd_kir?zeroDateTimeBehavior=convertToNull", "root", "root");
        this.gestionnaire = new GestionnaireDInscription("jdbc:mysql://localhost:8889/bdd_kir?zeroDateTimeBehavior=convertToNull", "root", "root");
    }

    public JPanel initialisation() {
        this.contenu();
        return this.monContenu;
    }

    public void contenu(){
        JLabel titre = new JLabel("Les informations");
        monContenu.add(titre);
        System.out.println("pseudo: " + connexion.getPseudo());
        this.infos = gj.demandeInformation(connexion.getPseudo());
    }

    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//     
//                    System.out.println("pseudo: "+connexion.getPseudo());
//                    Information infos = gj.demandeInformation(connexion.getPseudo());
}
