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
        this.connexion = new Connect();
        this.gestionnaire = new GestionnaireDInscription();
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
        titreNom.setFont(lesTitres);
        JLabel nom = new JLabel(infos.getNom());
        
        JPanel leNom = panelLigne(titreNom, nom);
        monContenu.add(leNom);
        
        JLabel titrePrenom = new JLabel("Prenom: ");
        titrePrenom.setFont(lesTitres);
        JLabel prenom = new JLabel(infos.getPrenom());
        
        JPanel lePrenom = panelLigne(titrePrenom, prenom);
        monContenu.add(lePrenom);
        
        JLabel titreDateNaissance = new JLabel("date de naissance: ");
        titreDateNaissance.setFont(lesTitres);
        JLabel DateNaissance = new JLabel(infos.getCalendarNaissance());
        
        JPanel leDateNaissance = panelLigne(titreDateNaissance, DateNaissance);
        monContenu.add(leDateNaissance);
        
        JLabel titreSexe = new JLabel("Sexe: ");
        titreSexe.setFont(lesTitres);
        JLabel Sexe = new JLabel(infos.getSexe());
        
        JPanel leSexe = panelLigne(titreSexe, Sexe);
        monContenu.add(leSexe);
        
        JLabel titreTel = new JLabel("Telelephone: ");
        titreTel.setFont(lesTitres);
        JLabel Tel = new JLabel(infos.getTel());
        
        JPanel leTel = panelLigne(titreTel, Tel);
        titreDateNaissance.setFont(lesTitres);
        monContenu.add(leTel);
        
        JLabel titreMail = new JLabel("Email: ");
        titreMail.setFont(lesTitres);
        JLabel Mail = new JLabel(infos.getMail());
        
        JPanel leMail = panelLigne(titreMail, Mail);
        monContenu.add(leMail);
        
        JLabel titreScore = new JLabel("Score : ");
        titreScore.setFont(lesTitres);
        String tmp="";
        tmp+=infos.getScore();
        JLabel Score = new JLabel(tmp);
        
        JPanel leScore = panelLigne(titreScore, Score);
        monContenu.add(leScore);
        
        JLabel titreNiveau = new JLabel("Niveau : ");
        titreNiveau.setFont(lesTitres);
        String tmp2="";
        tmp2+=infos.getNiveau();
        JLabel Niveau = new JLabel(tmp2);
        
        JPanel leNiveau = panelLigne(titreNiveau, Niveau);
        monContenu.add(leNiveau);
        
        JLabel titreNbconnecte = new JLabel("Nombre de connection : ");
        titreNbconnecte.setFont(lesTitres);
        String tmp3="";
        tmp3+=infos.getNbconnecte();
        JLabel Nbconnecte = new JLabel(tmp3);
        
        JPanel leNbconnecte = panelLigne(titreNbconnecte, Nbconnecte);
        monContenu.add(leNbconnecte);
        


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
