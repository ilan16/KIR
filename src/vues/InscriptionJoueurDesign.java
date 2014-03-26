/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Joueur.GestionnaireDInscription;
import com.toedter.calendar.JDateChooser;
import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author ilanmalka
 */
public class InscriptionJoueurDesign extends Applet implements Observateur {

    private ImagePanel champsInscription;
    private GestionnaireDInscription gestionnaire;
    private boolean[] verification;

    public InscriptionJoueurDesign() throws SQLException {
        this.champsInscription = new ImagePanel("contenuIns.png");
        this.gestionnaire = new GestionnaireDInscription();
        this.verification = new boolean[4];
    }

    public ImagePanel initialisation() {
        this.contenuInscription();
        return this.champsInscription;
    }

    public void contenuInscription() {
        JPanel contenuInsc = new JPanel();
        contenuInsc.setLayout((new BoxLayout(contenuInsc, BoxLayout.PAGE_AXIS)));
        contenuInsc.setOpaque(false);

        for (int i = 0; i < 10; i++) {
            contenuInsc.add(new JLabel("     "));
        }


        champsInscription.setLayout((new BoxLayout(champsInscription, BoxLayout.PAGE_AXIS)));
        champsInscription.setPreferredSize(new Dimension(400, 500));

        //contenuInsc.add(champsInscription);

        champsInscription.add(new JLabel("     "));

        JLabel consigne = new JLabel("Il est préférable d'appuier sur ENTRER pour valider et voir les erreurs éventuelles de vos champs");
        Font consigneFont = new Font("Courier New", Font.ITALIC, 8);
        consigne.setFont(consigneFont);
        champsInscription.add(consigne);
        
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
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    verification[0] = gestionnaire.verifierPseudo(contenuPseudo.getText());
                    if (!verification[0]) {
                        System.out.println("erreur");
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Votre pseudo n'est pas bon", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        contenuPseudo.setText("");
                    } else {
                        System.out.println("c'est bon");
                    }
                }
            }
        });

        //MAIL

        JLabel mail = new JLabel("Mail: ");
        final JTextField contenuMail = new JTextField("entrez votre mail");
        contenuMail.setPreferredSize(new Dimension(150, 30));

        JPanel panelMail = new JPanel();
        panelMail.setOpaque(false);
        panelMail.add(mail);
        panelMail.add(contenuMail);
        champsInscription.add(panelMail);

        contenuMail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ("entrez votre mail".equals(contenuMail.getText())) {
                    contenuMail.setText("");
                }
            }
        });

        contenuMail.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    verification[1] = gestionnaire.verifierMail(contenuMail.getText());
                    if (!verification[1]) {
                        System.out.println("erreur");
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Votre mail est galère", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        contenuMail.setText("");
                    } else {
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
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    verification[2] = gestionnaire.verifierPassword(contenuPassword.getText());
                    if (!verification[2]) {
                        System.out.println("erreur");
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Votre password est mauvaise", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        contenuPassword.setText("");
                    } else {
                        System.out.println("c'est bon");
                    }
                }
            }
        });

        //PASSWORD CONF

        JLabel passwordConf = new JLabel("password de confirmation: ");
        final JTextField contenuPasswordConf = new JTextField("entrez votre password de confirmation");
        contenuPasswordConf.setPreferredSize(new Dimension(150, 30));

        JPanel panelpasswordConf = new JPanel();
        panelpasswordConf.setOpaque(false);
        panelpasswordConf.add(passwordConf);
        panelpasswordConf.add(contenuPasswordConf);
        champsInscription.add(panelpasswordConf);

        contenuPasswordConf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ("entrez votre password de confirmation".equals(contenuPasswordConf.getText())) {
                    contenuPasswordConf.setText("");
                }
            }
        });

        contenuPasswordConf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    verification[3] = gestionnaire.verifierPasswordConf(contenuPasswordConf.getText());
                    if (!verification[3]) {
                        System.out.println("erreur");
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Votre password de confirmation est mauvais", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        contenuPasswordConf.setText("");
                    } else {
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
                verification[0] = gestionnaire.verifierPseudo(contenuPseudo.getText());
                verification[1] = gestionnaire.verifierMail(contenuMail.getText());
                verification[2] = gestionnaire.verifierPassword(contenuPassword.getText());
                
                
                for (int i = 0; i < verification.length; i++) {
                    if (!gestionnaire.equals(contenuPasswordConf.getText(), contenuPassword.getText())) {
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Le mot de passe de confirmation n'est pas identique au mot de passe", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        verification[3] = false;
                        break;
                    }

                    if (verification[i] == false) {
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Il y a une erreur dans la saisie " + (i + 1), "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        break;
                    }
                }
                if (verification[0] && verification[1]) {
                    try {
                        gestionnaire.inscriptionJoueur(contenuPseudo.getText(), contenuMail.getText(), contenuPassword.getText());
                        System.out.println("inscription finie");
                        champsInscription.removeAll();
                        Fenetre f = new Fenetre("K.I.R");
                        MenuPrincipal menu = new MenuPrincipal();
                        f.setContentPane(menu.initialisation());
                    } catch (SQLException ex) {
                        Logger.getLogger(InscriptionJoueurDesign.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(InscriptionJoueurDesign.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        this.champsInscription.add(contenuInsc);
    }

    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
