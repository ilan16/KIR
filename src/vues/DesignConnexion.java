/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Joueur.Connect;
import Joueur.GestionnaireDInscription;
import java.applet.Applet;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ilanmalka
 */
public class DesignConnexion extends Applet implements Observateur {

    private ImagePanel champsInscription;
    private Connect connexion;
    private GestionnaireDInscription gestionnaire;
    private boolean[] verification;

    public DesignConnexion() throws SQLException {
        this.champsInscription = new ImagePanel("contenuIns.png");
        this.connexion = new Connect("jdbc:mysql://localhost:8889/bdd_kir?zeroDateTimeBehavior=convertToNull", "root", "root");
        this.gestionnaire = new GestionnaireDInscription("jdbc:mysql://localhost:8889/bdd_kir?zeroDateTimeBehavior=convertToNull", "root", "root");
        this.verification = new boolean[2];
    }

    public ImagePanel initialisation() {
        this.contenuConnexion();
        return this.champsInscription;
    }

    public void contenuConnexion() {
        JPanel contenuConnexion = new JPanel();
        contenuConnexion.setLayout((new BoxLayout(contenuConnexion, BoxLayout.PAGE_AXIS)));
        contenuConnexion.setOpaque(false);

        for (int i = 0; i < 10; i++) {
            contenuConnexion.add(new JLabel("     "));
        }


        champsInscription.setLayout((new BoxLayout(champsInscription, BoxLayout.PAGE_AXIS)));
        champsInscription.setPreferredSize(new Dimension(400, 500));


        champsInscription.add(new JLabel("     "));

        // PSEUDO

        JLabel pseudo = new JLabel("Pseudo: ");
        final JTextField contenuPseudo = new JTextField("entrez votre pseudo");
        contenuPseudo.setPreferredSize(new Dimension(150, 30));

        JPanel panelPseudo = new JPanel();
        panelPseudo.setOpaque(false);
        panelPseudo.add(pseudo);
        panelPseudo.add(contenuPseudo);
        champsInscription.add(panelPseudo);

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
                System.out.println("Code touche tapée : " + e.getKeyCode() + " - caractère touche tapée : " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Code touche pressée : " + e.getKeyCode() + " - caractère touche pressée : " + e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Code touche relâchée : " + e.getKeyCode() + " - caractère touche relâchée : " + e.getKeyChar());
                if (e.getKeyCode() == 10) {
                    verification[0] = gestionnaire.verifierPseudo(contenuPseudo.getText());
                    if (!verification[0]) {
                        System.out.println("erreur");
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Votre pseudo n'est pas bon", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        contenuPseudo.setText("");
                    } else {
                        connexion.setPseudo(contenuPseudo.getText());
                        System.out.println("c'est bon");
                    }
                }
            }
        });

        

        //PASSWORD 

        JLabel password = new JLabel("Password: ");
        final JTextField contenuPassword = new JTextField("entrez votre password");
        contenuPassword.setPreferredSize(new Dimension(150, 30));

        JPanel panelPassword = new JPanel();
        panelPassword.setOpaque(false);
        panelPassword.add(password);
        panelPassword.add(contenuPassword);
        champsInscription.add(panelPassword);

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
                System.out.println("Code touche tapée : " + e.getKeyCode() + " - caractère touche tapée : " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Code touche pressée : " + e.getKeyCode() + " - caractère touche pressée : " + e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Code touche relâchée : " + e.getKeyCode() + " - caractère touche relâchée : " + e.getKeyChar());
                if (e.getKeyCode() == 10) {
                    verification[2] = gestionnaire.verifierPassword(contenuPassword.getText());
                    if (!verification[2]) {
                        System.out.println("erreur");
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Votre password est mauvaise", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        contenuPassword.setText("");
                    } else {
                        connexion.setPassword(contenuPassword.getText());
                        System.out.println("c'est bon");
                    }
                }
            }
        });


        //BOUTON

        final JButton validation = new JButton("Valider");
        champsInscription.add(validation);

        validation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < verification.length; i++) {
                    if (verification[i] = false){
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Il y a une erreur dans la saisie " + (i + 1), "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        break;
                    }

                    if (verification[i] == false) {
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Il y a une erreur dans la saisie " + (i + 1), "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        break;
                    }
                }
                if (verification[0] && verification[1] && verification[2] && verification[3]) {
                    if(connexion.getIsConnexion()){
                    System.out.println("connexion finie");
                    champsInscription.removeAll();
                    }
                }
            }
        });

        this.champsInscription.add(contenuConnexion);
    }
    
    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
