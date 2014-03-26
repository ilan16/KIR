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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ilanmalka
 */
public class DesignConnexion extends Applet implements Observateur {

    private ImagePanel monPanel;
    private Connect connexion;
    private GestionnaireDInscription gestionnaire;
    private boolean[] verification;
    private GestionnaireJoueur joueur=new GestionnaireJoueur();

    public DesignConnexion() throws SQLException {
        this.monPanel = new ImagePanel("fondJeu.png");
        this.connexion = new Connect();
        this.gestionnaire = new GestionnaireDInscription();
        this.verification = new boolean[2];
        
    }

    public JPanel initialisation() {
        this.contenuInscription();
        return this.monPanel;
    }

    public void contenuInscription() {
        JPanel contenuConnexion = new JPanel();
        contenuConnexion.setLayout((new BoxLayout(contenuConnexion, BoxLayout.PAGE_AXIS)));
        contenuConnexion.setOpaque(false);

        for (int i = 0; i < 20; i++) {
            contenuConnexion.add(new JLabel("     "));
        }


        final ImagePanel champsConnexion = new ImagePanel("contenuIns.png");
        champsConnexion.setLayout((new BoxLayout(champsConnexion, BoxLayout.PAGE_AXIS)));
        champsConnexion.setPreferredSize(new Dimension(400, 200));

        contenuConnexion.add(champsConnexion);

        champsConnexion.add(new JLabel("     "));

        // PSEUDO

        JLabel pseudo = new JLabel("Pseudo: ");
        final JTextField contenuPseudo = new JTextField("entrez votre pseudo");
        contenuPseudo.setPreferredSize(new Dimension(150, 30));

        JPanel panelPseudo = new JPanel();
        panelPseudo.setOpaque(false);
        panelPseudo.add(pseudo);
        panelPseudo.add(contenuPseudo);
        champsConnexion.add(panelPseudo);

        contenuPseudo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ("entrez votre pseudo".equals(contenuPseudo.getText())) {
                    contenuPseudo.setText("");
                }
            }
        });

        contenuPseudo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    verification[0] = gestionnaire.verifierPseudo(contenuPseudo.getText());
                    System.out.println(verification[0]);
                    if (!verification[0]) {
                        System.out.println("erreur");
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Votre pseudo n'est pas bon", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        contenuPseudo.setText("");
                    } else {
                        SingletonJoueur.getInstance().setPseudo(contenuPseudo.getText());
                        connexion.setPseudo(contenuPseudo.getText());
                        System.out.println("c'est bon");
                    }
                }
            }
        });

        //PASSWORD 

        JLabel password = new JLabel("Password: ");
        final JPasswordField  contenuPassword = new JPasswordField();
        contenuPassword.setPreferredSize(new Dimension(150, 30));

        JPanel panelPassword = new JPanel();
        panelPassword.setOpaque(false);
        panelPassword.add(password);
        panelPassword.add(contenuPassword);
        champsConnexion.add(panelPassword);

        contenuPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ("entrez votre password".equals(contenuPassword.getText())) {
                    contenuPassword.setText("");
                }
            }
        });

        contenuPassword.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    verification[1] = gestionnaire.verifierPassword(contenuPassword.getText());
                    if (!verification[1]) {
                        System.out.println("erreur");
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Votre password est mauvaise", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        contenuPassword.setText("");
                    } else {
                        SingletonJoueur.getInstance().setPassword(contenuPassword.getText());
                        connexion.setPassword(contenuPassword.getText());
                        System.out.println("c'est bon");
                    }
                }
            }
        });

        //BOUTON

        final JButton validation = new JButton("Valider");
        champsConnexion.add(validation);

        validation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verification[0] = gestionnaire.verifierPseudo(contenuPseudo.getText());
                verification[1] = gestionnaire.verifierPassword(contenuPassword.getText());
                
                for (int i = 0; i < verification.length; i++) {
                    if (verification[i] == false) {
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Il y a une erreur dans la saisie " + (i + 1), "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                    }
                }
                if (verification[0] && verification[1]) {
                    if (connexion.verifier()) {
                        System.out.println("connexion finie");
                        joueur.connectionReussie(contenuPseudo.getText());
                        champsConnexion.removeAll();
                        monPanel.removeAll();
                        DesignInfoJeu d;
                        try {
                            d = new DesignInfoJeu();
                            monPanel.add(d.initialisation());
                        } catch (SQLException ex) {
                            Logger.getLogger(DesignConnexion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Vous n'etes pas inscris", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        monPanel.removeAll();
                        contenuInscription();
                    }
                }
            }
        });

        this.monPanel.add(contenuConnexion);
    }

    public void actualiserInformations() {
    }
}
