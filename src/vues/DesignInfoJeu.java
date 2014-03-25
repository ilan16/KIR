/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Joueur.Connect;
import Joueur.GestionnaireDInscription;
import Joueur.GestionnaireJoueur;
import Joueur.SingletonJoueur;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
public class DesignInfoJeu extends Applet implements Observateur {

    private JPanel monContenu;
    private Connect connexion;
    private GestionnaireDInscription gestionnaire;
    private GestionnaireJoueur gj;

    public DesignInfoJeu() throws SQLException {
        this.monContenu = new JPanel();
        this.monContenu.setOpaque(false);
        this.connexion = new Connect();
        this.gestionnaire = new GestionnaireDInscription();
    }

    public JPanel initialisation() {
        this.contenu();
        return this.monContenu;
    }

    public void contenu() {
        final JPanel lesBoutons = new JPanel();
        lesBoutons.setOpaque(false);
        lesBoutons.setLayout((new BoxLayout(lesBoutons, BoxLayout.PAGE_AXIS)));

        for (int i = 0; i < 20; i++) {
            lesBoutons.add(new JLabel("     "));
        }

        JPanel vertical = new JPanel();
        vertical.setOpaque(false);
        vertical.setLayout((new BoxLayout(vertical, BoxLayout.LINE_AXIS)));

        JButton mesInformations = new JButton(new ImageIcon("Images/Boutons/MesInformations.png"));
        mesInformations.setOpaque(false);
        mesInformations.setContentAreaFilled(false);
        mesInformations.setBorderPainted(false);

        mesInformations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monContenu.removeAll();
                MesInformationsDesign infos;
                try {
                    infos = new MesInformationsDesign();
                    monContenu.add(infos.initialisation());
                } catch (SQLException ex) {
                    Logger.getLogger(DesignInfoJeu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        vertical.add(mesInformations);

        JButton comparer = new JButton(new ImageIcon("Images/Boutons/comparer.png"));
        comparer.setOpaque(false);
        comparer.setContentAreaFilled(false);
        comparer.setBorderPainted(false);
        comparer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
                String pseudo = jop.showInputDialog(null, "Veuillez entrer le pseudo de la personne avec qui vous voulez vous comparer !", "Comparer votre résultat !", JOptionPane.QUESTION_MESSAGE);
                
                int nv = gj.compareToNv(SingletonJoueur.getInstance().getPseudo(), pseudo);
                System.out.println(nv);
                StringBuilder str = new StringBuilder();
                
                if (nv > 0) {
                    str.append("Vous avez un meilleur niveau que " + pseudo + "de : " + nv + " niveau(x) ");
                } else if (nv == 0) {
                    str.append("Vous avez un niveau égal ");
                } else {
                    str.append("Vous avez un moins bon niveau que " + pseudo + "de : " + (-1 * nv) + " niveau(x) ");
                }
                
                int score = gj.compareToScore(SingletonJoueur.getInstance().getPseudo(), pseudo);
                
                if (score > 0) {
                    str.append("puis vous avez un meilleur score que " + pseudo + "de : " + score);
                } else if (score == 0) {
                    str.append("puis vous avez un score égal");
                } else {
                    str.append("puis vous avez un moins bon score que " + pseudo + "de : " + (-1 * score));
                }
                
                jop2.showMessageDialog(null, str, "Le résultat", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        vertical.add(comparer);

        JButton jouer = new JButton(new ImageIcon("Images/Boutons/jouer.png"));
        jouer.setOpaque(false);
        jouer.setContentAreaFilled(false);
        jouer.setBorderPainted(false);

        jouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lesBoutons.removeAll();
                monContenu.removeAll();
                lesPartiesDesign parties;
                try {
                    parties = new lesPartiesDesign();
                    monContenu.add(parties.initialisation());
                    monContenu.setOpaque(false);
                } catch (SQLException ex) {
                    Logger.getLogger(DesignInfoJeu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(DesignInfoJeu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        lesBoutons.add(vertical);
        lesBoutons.add(jouer);

        this.monContenu.add(lesBoutons);

    }

    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
