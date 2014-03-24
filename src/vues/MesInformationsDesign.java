/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Joueur.Connect;
import Joueur.GestionnaireDInscription;
import Joueur.GestionnaireJoueur;
import Joueur.Information;
import Joueur.SingletonJoueur;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ilanmalka
 */
public class MesInformationsDesign extends Applet implements Observateur {

    private ImagePanel monContenu;
    private Connect connexion;
    private Information infos;
    private GestionnaireJoueur gj;
    private GestionnaireDInscription gestionnaire;

    public MesInformationsDesign() throws SQLException {
        this.monContenu = new ImagePanel("contenuIns.png");
        this.monContenu.setLayout((new BoxLayout(this.monContenu, BoxLayout.PAGE_AXIS)));
        this.monContenu.setOpaque(false);
        this.gj = new GestionnaireJoueur();
        this.connexion = new Connect("jdbc:mysql://localhost:8889/bdd_kir?zeroDateTimeBehavior=convertToNull", "root", "root");
        this.gestionnaire = new GestionnaireDInscription("jdbc:mysql://localhost:8889/bdd_kir?zeroDateTimeBehavior=convertToNull", "root", "root");
    }

    public JPanel initialisation() {
        this.contenu();
        return this.monContenu;
    }

    public void contenu() {
        Font titreInfos = new Font("Apple Chancery", Font.BOLD, 40);
        JLabel titre = new JLabel("Les informations");
        titre.setFont(titreInfos);
        monContenu.add(titre);

        this.infos = gj.demandeInformation(SingletonJoueur.getInstance().getPseudo());

        for (int i = 0; i < 10; i++) {
            monContenu.add(new JLabel("     "));
        }
        
        // pseudo
        Font lesTitres = new Font("Comic Sans MS", Font.BOLD, 18);

        JLabel titrePseudo = new JLabel("Pseudo: ");
        titrePseudo.setFont(lesTitres);
        JLabel pseudo = new JLabel(SingletonJoueur.getInstance().getPseudo());
        
        JPanel lePseudo = panelLigne(titrePseudo, pseudo);
        monContenu.add(lePseudo);
        
        JLabel titreNom = new JLabel("Nom: ");
        titrePseudo.setFont(lesTitres);
        JLabel nom = new JLabel(infos.getNom());
        
        JPanel leNom = panelLigne(titreNom, nom);
        monContenu.add(leNom);
        
        
        


    }

    public JPanel panelLigne(JLabel titre, JLabel contenu) {
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setLayout((new BoxLayout(panel, BoxLayout.LINE_AXIS)));
        panel.add(titre);
        panel.add(contenu);
        return panel;
    }

    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
