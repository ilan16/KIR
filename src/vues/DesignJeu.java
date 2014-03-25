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
import Joueur.SingletonJoueur;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.codehaus.commons.compiler.CompileException;

/**
 *
 * @author ilanmalka
 */
public class DesignJeu extends Applet implements Observateur {

    private JTextArea zoneTexte;
    private JPanel monContenu;
    private GestionnaireDInscription gestionnaire;
    private chrono ch;
    private Jeu j;
    private int nv=(SingletonJeu.getInstance().getNiveau() * 4 + SingletonJeu.getInstance().getTypeNiveau());

    public DesignJeu() throws SQLException {
        this.ch = new chrono();
        this.j = new Jeu() {
        };
        this.monContenu = new ImagePanel("transparent.png");
        // this.monPanel = new JPanel();
        this.monContenu.setPreferredSize(new Dimension(900, 600));
        //this.monPanel.setOpaque(false);
        this.monContenu.setLayout((new BoxLayout(this.monContenu, BoxLayout.PAGE_AXIS)));
    }

    public JPanel initialisation() throws IOException {
        this.contenu();
        return this.monContenu;
    }

    public void contenu() throws IOException {
        JPanel haut = new JPanel();
        haut.setOpaque(false);
        haut.setLayout((new BoxLayout(haut, BoxLayout.PAGE_AXIS)));

        JLabel niveau = null;
        switch (SingletonJeu.getInstance().getTypeNiveau()) {
            case 1:
                niveau = new JLabel("                      Afficher les résultats                            ");
                break;
            case 2:
                niveau = new JLabel("                      Compléter                            ");
                break;
            case 3:
                niveau = new JLabel("                      Trouver les erreurs                            ");
                break;
            case 4:
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

        this.monContenu.add(haut);

        for (int i = 0; i < 3; i++) {
            this.monContenu.add(new JLabel("     "));
        }


        JPanel centre = new JPanel();
        centre.setOpaque(false);
        centre.setLayout((new BoxLayout(centre, BoxLayout.LINE_AXIS)));

        // cote gauche

        JTextArea textGauche = new JTextArea(j.AfficherEnoncer(nv));
        //JTextArea textGauche = new JTextArea(j.AfficherEnoncer(2));
        textGauche.setEditable(false);
        textGauche.setOpaque(false);
        Font texteDroite = new Font("Courier New", 0, 13);
        textGauche.setLayout(new FlowLayout(FlowLayout.LEFT));

        JScrollPane scrollgauche = new JScrollPane(textGauche);

        //cote droit

        final JTextArea textDroite = new JTextArea(j.AfficherZoneRep(nv), 80, 50);
        //final JTextArea textDroite = new JTextArea(j.AfficherZoneRep(2));
        textDroite.setLayout(new FlowLayout(FlowLayout.LEFT));
        textDroite.setFont(texteDroite);
        textDroite.setOpaque(false);
        JScrollPane scrolldroite = new JScrollPane(textDroite);

        JLabel espace = new JLabel(" ");
        centre.add(scrollgauche);
        centre.add(espace);
        centre.add(scrolldroite);

        this.monContenu.add(centre);

        JButton valider = new JButton("Valider");

        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int temp=ch.Sec(ch.Stop_Chrono());
//                monPanel.removeAll();
                try {
                    if(j.nvReussi(nv,textDroite.getText())){
                        JOptionPane error = new JOptionPane();
                        j.ajouterPointAfficher(nv,SingletonJoueur.getInstance().getPseudo(), temp,textDroite.getText() );
                        error.showMessageDialog(null, "Réussi, vous avez" +j.score(nv, temp) + "points", "Réussi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Images/content.png"));
                    }else{
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Vous avez perdu", "Perdu", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Images/pleurer.png"));
                    }
                    
                    
                } catch (IOException ex) {
                    JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Vous avez perdu", "Perdu", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Images/pleurer.png"));
                } catch (CompileException ex) {
                    JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Vous avez perdu", "Perdu", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Images/pleurer.png"));
                } catch (SQLException ex) {
                    JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Vous avez perdu", "Perdu", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Images/pleurer.png"));
                }

            }
        });
        this.monContenu.add(valider);
        this.monContenu.add(this.precedent());
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
                lesPartiesDesign d;
                try {
                    d = new lesPartiesDesign();
                    monContenu.add(d.initialisation());
                } catch (SQLException ex) {
                    Logger.getLogger(DesignConnexion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(DesignJeu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return precedent;
    }

    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
