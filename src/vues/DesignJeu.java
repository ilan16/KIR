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
       // this.monPanel = new ImagePanel("fondJeu.png");
        this.monPanel = new JPanel();
        this.monPanel.setPreferredSize(new Dimension(900, 600));
        this.monPanel.setOpaque(false);
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

        this.monPanel.add(haut);

         for (int i = 0; i < 3; i++) {
            this.monPanel.add(new JLabel("     "));
        }

        
        JPanel centre = new JPanel();
        centre.setOpaque(false);
        centre.setLayout((new BoxLayout(centre, BoxLayout.LINE_AXIS)));

        // cote gauche

        JPanel gauche = new JPanel();
        gauche.setOpaque(false);
        gauche.setBackground(Color.white);
        gauche.setPreferredSize(new Dimension(300, 600));
        
        //JTextArea textGauche = new JTextArea(j.AfficherEnoncer((SingletonJeu.getInstance().getNiveau() * 4 + SingletonJeu.getInstance().getTypeNiveau())));
        JTextArea textGauche = new JTextArea(j.AfficherEnoncer(2));
        textGauche.setEditable(false);
        Font texteDroite = new Font("Courier New", 0, 13);
        gauche.setLayout(new FlowLayout(FlowLayout.LEFT));
        textGauche.setFont(texteDroite);
        
        JScrollPane scrollgauche = new JScrollPane(textGauche);
        //scrollgauche.setHorizontalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollgauche.setVerticalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        gauche.add(scrollgauche);



        //cote droit

        JPanel droite = new JPanel();
        droite.setOpaque(false);
        droite.setBackground(Color.white);
        droite.setPreferredSize(new Dimension(300, 600));
        //final JTextArea textDroite = new JTextArea(j.AfficherZoneRep((SingletonJeu.getInstance().getNiveau() * 4 + SingletonJeu.getInstance().getTypeNiveau())));
        final JTextArea textDroite = new JTextArea(j.AfficherZoneRep(2));
        textDroite.setPreferredSize(new Dimension(390, 490));
        droite.setLayout(new FlowLayout(FlowLayout.LEFT));
        textDroite.setFont(texteDroite);
        JScrollPane scrolldroite = new JScrollPane(textDroite);
//        scrolldroite.setHorizontalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       // scrolldroite.setVerticalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        droite.add(scrolldroite);
        
        JLabel espace = new JLabel(" ");
        
        centre.add(gauche);
        centre.add(espace);
        centre.add(droite);
        
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
