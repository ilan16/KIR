/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Joueur.GestionnaireDInscription;
import java.applet.Applet;
import java.awt.Color;
import static java.awt.Color.white;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ilanmalka
 */
public class DesignJeu extends Applet implements Observateur {

    JTextArea zoneTexte;
    private ImagePanel monPanel;
    private GestionnaireDInscription gestionnaire;
    private Jeu j;

    public DesignJeu() throws SQLException {
        this.j = new Jeu() {};
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

        JLabel niveau = new JLabel("                      Type niveau                            ");
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

        JTextArea textGauche = new JTextArea(j.AfficherEnoncer(1));
        textGauche.setEditable(false);
        Font texte2 = new Font("Apple Chancery", 0, 13);
        gauche.setLayout(new FlowLayout(FlowLayout.LEFT));
        textGauche.setFont(texte2);
        gauche.add(textGauche);



        //cote droit

        JPanel droite = new JPanel();
        droite.setBackground(Color.white);
        droite.setPreferredSize(new Dimension(400, 500));
        final JTextArea textDroite = new JTextArea(j.AfficherZoneRep(1));
        Font texte3 = new Font("Apple Chancery", 0, 13);
        textDroite.setPreferredSize(new Dimension(390, 490));
        droite.setLayout(new FlowLayout(FlowLayout.LEFT));
        textDroite.setFont(texte3);
        droite.add(textDroite);


        centre.add(droite);
        this.monPanel.add(gauche);
        this.monPanel.add(droite);

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
