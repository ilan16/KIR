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
import Jeu.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ilanmalka
 */
public class DesignJeu extends Applet implements Observateur {

    private JTextArea zoneTexte;
    private JPanel monPanel;
    private GestionnaireDInscription gestionnaire;
    private Jeu j;

    public DesignJeu() throws SQLException {
        this.j = new Jeu() {
        };
       this.monPanel = new ImagePanel("contenuJeu.png");
       // this.monPanel = new JPanel();
        this.monPanel.setPreferredSize(new Dimension(900, 600));
        //this.monPanel.setOpaque(false);
        this.monPanel.setLayout((new BoxLayout(this.monPanel, BoxLayout.PAGE_AXIS)));
    }

    public JPanel initialisation() throws IOException {
        this.contenu();
        return this.monPanel;
    }

    public void contenu() throws IOException {
        JPanel haut = new JPanel();
        haut.setOpaque(false);
        haut.setLayout((new BoxLayout(haut, BoxLayout.PAGE_AXIS)));

        JLabel niveau = null;
        switch (SingletonJeu.getInstance().getTypeNiveau()) {
            case 0:
                niveau = new JLabel("                      Afficher les résultats                            ");
                break;
            case 1:
                niveau = new JLabel("                      Compléter                            ");
                break;
            case 2:
                niveau = new JLabel("                      Trouver les erreurs                            ");
                break;
            case 3:
                niveau = new JLabel("                     Ecrire le programme                            ");
                break;
            default:
                niveau = new JLabel("                      Type d'exercice                           ");
                break;
        }


        Font titreNiveau = new Font("Apple Chancery", Font.BOLD, 40);
        niveau.setFont(titreNiveau);
        haut.add(niveau);
        haut.setOpaque(false);

        this.monPanel.add(haut);

         for (int i = 0; i < 3; i++) {
            this.monPanel.add(new JLabel("     "));
        }

        
        JPanel centre = new JPanel();
        centre.setOpaque(false);
        centre.setLayout((new BoxLayout(centre, BoxLayout.LINE_AXIS)));

        // cote gauche
        
        JTextArea textGauche = new JTextArea(j.AfficherEnoncer((SingletonJeu.getInstance().getNiveau() * 4 + SingletonJeu.getInstance().getTypeNiveau())));
        //JTextArea textGauche = new JTextArea(j.AfficherEnoncer(2));
        textGauche.setEditable(false);
        textGauche.setOpaque(false);
        Font texteDroite = new Font("Courier New", 0, 13);
        textGauche.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JScrollPane scrollgauche = new JScrollPane(textGauche);
       
        //cote droit

        final JTextArea textDroite = new JTextArea(j.AfficherZoneRep((SingletonJeu.getInstance().getNiveau() * 4 + SingletonJeu.getInstance().getTypeNiveau())), 80, 50);
        //final JTextArea textDroite = new JTextArea(j.AfficherZoneRep(2));
        textDroite.setLayout(new FlowLayout(FlowLayout.LEFT));
        textDroite.setFont(texteDroite);
        textDroite.setOpaque(false);
        JScrollPane scrolldroite = new JScrollPane(textDroite);
        
        JLabel espace = new JLabel(" ");
        centre.add(scrollgauche);
        centre.add(espace);
        centre.add(scrolldroite);
        
        this.monPanel.add(centre);

        JButton showButton = new JButton("Show");

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = (textDroite.getText());
                System.out.println(a);
            }
        });
        this.monPanel.add(showButton);
    }

    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
