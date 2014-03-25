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
    private ImagePanel monPanel;
    private GestionnaireDInscription gestionnaire;
    private Jeu j;

    public DesignJeu() throws SQLException {
        this.j = new Jeu() {
        };
        this.monPanel = new ImagePanel("fondJeu.png");
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
        System.out.println("sj" + SingletonJeu.getInstance().getTypeNiveau());
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

        this.monPanel.add(haut);

        JPanel centre = new JPanel();
        centre.setLayout((new BoxLayout(centre, BoxLayout.LINE_AXIS)));

        // cote gauche

        JPanel gauche = new JPanel();
        gauche.setBackground(Color.white);
        gauche.setPreferredSize(new Dimension(400, 500));
        
        JTextArea textGauche = new JTextArea(j.AfficherEnoncer((SingletonJeu.getInstance().getNiveau() * 4 + SingletonJeu.getInstance().getTypeNiveau())));
        textGauche.setEditable(false);
        Font texte2 = new Font("Courier New", 0, 13);
        gauche.setLayout(new FlowLayout(FlowLayout.LEFT));
        textGauche.setFont(texte2);
        gauche.add(textGauche);



        //cote droit

        JPanel droite = new JPanel();
        droite.setBackground(Color.white);
        droite.setPreferredSize(new Dimension(400, 500));
        final JTextArea textDroite = new JTextArea(j.AfficherZoneRep((SingletonJeu.getInstance().getNiveau() * 4 + SingletonJeu.getInstance().getTypeNiveau())));
        textDroite.setPreferredSize(new Dimension(390, 490));
        droite.setLayout(new FlowLayout(FlowLayout.LEFT));
        textDroite.setFont(texte2);
        droite.add(textDroite);

        JScrollPane scrollgauche = new JScrollPane(gauche);
        JScrollPane scrolldroite = new JScrollPane(droite);

        centre.add(droite);
        this.monPanel.add(scrollgauche);
        this.monPanel.add(scrolldroite);

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
