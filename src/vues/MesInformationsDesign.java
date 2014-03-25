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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ilanmalka
 */
public class MesInformationsDesign extends Applet implements Observateur {

    private JPanel monContenu;
    private Connect connexion;
    private JLabel Score;
    private Information infos;
    private GestionnaireJoueur gj;
    private GestionnaireDInscription gestionnaire;

    public MesInformationsDesign() throws SQLException {
        this.monContenu = new JPanel();
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
        JPanel leContenu = new ImagePanel("contenuIns.png");

        leContenu.setLayout((new BoxLayout(leContenu, BoxLayout.PAGE_AXIS)));
        Font titreInfos = new Font("Apple Chancery", Font.BOLD, 40);
        JLabel titre = new JLabel("Les informations");
        titre.setFont(titreInfos);
        leContenu.add(titre);

        this.infos = gj.demandeInformation(SingletonJoueur.getInstance().getPseudo());

        for (int i = 0; i < 10; i++) {
            leContenu.add(new JLabel("     "));
        }

        // pseudo
        Font lesTitres = new Font("Comic Sans MS", Font.BOLD, 18);

        JLabel titrePseudo = new JLabel("Pseudo: ");
        titrePseudo.setFont(lesTitres);
        JLabel pseudo = new JLabel(SingletonJoueur.getInstance().getPseudo());

        JPanel lePseudo = panelLigne(titrePseudo, pseudo);
        leContenu.add(lePseudo);

        JLabel titreNom = new JLabel("Nom: ");
        titreNom.setFont(lesTitres);
        JLabel nom = new JLabel(infos.getNom());

        JPanel leNom = panelLigne(titreNom, nom);
        leContenu.add(leNom);

        JLabel titrePrenom = new JLabel("Prenom: ");
        titrePrenom.setFont(lesTitres);
        JLabel prenom = new JLabel(infos.getPrenom());

        JPanel lePrenom = panelLigne(titrePrenom, prenom);
        leContenu.add(lePrenom);

        JLabel titreDateNaissance = new JLabel("date de naissance: ");
        titreDateNaissance.setFont(lesTitres);
        JLabel DateNaissance = new JLabel(infos.getCalendarNaissance());

        JPanel leDateNaissance = panelLigne(titreDateNaissance, DateNaissance);
        leContenu.add(leDateNaissance);

        JLabel titreSexe = new JLabel("Sexe: ");
        titreSexe.setFont(lesTitres);
        JLabel Sexe = new JLabel(infos.getSexe());

        JPanel leSexe = panelLigne(titreSexe, Sexe);
        leContenu.add(leSexe);

        JLabel titreTel = new JLabel("Telelephone: ");
        titreTel.setFont(lesTitres);
        JLabel Tel = new JLabel(infos.getTel());

        JPanel leTel = panelLigne(titreTel, Tel);
        titreDateNaissance.setFont(lesTitres);
        leContenu.add(leTel);

        JLabel titreMail = new JLabel("Email: ");
        titreMail.setFont(lesTitres);
        JLabel Mail = new JLabel(infos.getMail());

        JPanel leMail = panelLigne(titreMail, Mail);
        leContenu.add(leMail);

        JLabel titreScore = new JLabel("Score : ");
        titreScore.setFont(lesTitres);
        String tmp = "";
        tmp += infos.getScore();
        Score = new JLabel(tmp);

        JPanel leScore = panelLigne(titreScore, Score);
        leContenu.add(leScore);

        JLabel titreNiveau = new JLabel("Niveau : ");
        titreNiveau.setFont(lesTitres);
        String tmp2 = "";
        tmp2 += infos.getNiveau();
        JLabel Niveau = new JLabel(tmp2);

        JPanel leNiveau = panelLigne(titreNiveau, Niveau);
        leContenu.add(leNiveau);

        JLabel titreNbconnecte = new JLabel("Nombre de connection : ");
        titreNbconnecte.setFont(lesTitres);
        String tmp3 = "";
        tmp3 += infos.getNbconnecte();
        JLabel Nbconnecte = new JLabel(tmp3);

        JPanel leNbconnecte = panelLigne(titreNbconnecte, Nbconnecte);
        leContenu.add(leNbconnecte);

        monContenu.add(leContenu);

        JButton miseAzero = new JButton("Remise à zero");
        miseAzero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GestionnaireJoueur gj = new GestionnaireJoueur();
                    gj.remiseAZero(SingletonJoueur.getInstance().getPseudo());
                    JOptionPane error = new JOptionPane();
                    error.showMessageDialog(null, "mise à zéro réussie", " Mise à zéro", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Images/reussi.png"));
                    monContenu.removeAll();
                    DesignInfoJeu d;
                    try {
                        d = new DesignInfoJeu();
                        monContenu.add(d.initialisation());
                    } catch (SQLException ex) {
                        Logger.getLogger(DesignConnexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MesInformationsDesign.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        monContenu.add(miseAzero);

        monContenu.add(this.precedent());


    }

    public JButton precedent() {
        JButton precedent = new JButton(new ImageIcon("Images/Boutons/precedent.png"));
        precedent.setOpaque(false);
        precedent.setContentAreaFilled(false);
        precedent.setBorderPainted(false);
        precedent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monContenu.removeAll();
                //monContenu = new JPanel();
                //monContenu.setOpaque(false);
                DesignInfoJeu d;
                try {
                    d = new DesignInfoJeu();
                    monContenu.add(d.initialisation());
                } catch (SQLException ex) {
                    Logger.getLogger(DesignConnexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return precedent;
    }

    public JPanel panelLigne(JLabel titre, JLabel contenu) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout((new BoxLayout(panel, BoxLayout.LINE_AXIS)));
        panel.add(titre);
        panel.add(contenu);
        return panel;
    }

    @Override
    public void actualiserInformations() {
    }
}
