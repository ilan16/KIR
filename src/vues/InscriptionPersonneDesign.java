/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Joueur.GestionnaireDInscription;
import com.toedter.calendar.JDateChooser;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
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
public class InscriptionPersonneDesign extends Applet implements Observateur {

    private ImagePanel monPanel;
    private JButton contenuDate;
    private boolean sexe;
    private JDateChooser calendrier;
    private GestionnaireDInscription gestionnaire;
    private boolean[] verification;

    public InscriptionPersonneDesign() throws SQLException {
        this.monPanel = new ImagePanel("fondJeu.png");
        this.calendrier = new JDateChooser();
        this.gestionnaire = new GestionnaireDInscription();
        this.verification = new boolean[4];
    }

    public JPanel initialisation() {
        this.contenuInscription();
        return this.monPanel;
    }

    public void contenuInscription() {
        JPanel contenuInsc = new JPanel();
        contenuInsc.setLayout((new BoxLayout(contenuInsc, BoxLayout.PAGE_AXIS)));
        contenuInsc.setOpaque(false);

        for (int i = 0; i < 10; i++) {
            contenuInsc.add(new JLabel("     "));
        }


        final ImagePanel champsInscription = new ImagePanel("contenuIns.png");
        champsInscription.setLayout((new BoxLayout(champsInscription, BoxLayout.PAGE_AXIS)));
        champsInscription.setPreferredSize(new Dimension(400, 500));

        contenuInsc.add(champsInscription);

        champsInscription.add(new JLabel("     "));

        // NOM

        JLabel nom = new JLabel("Nom: ");
        final JTextField contenuNom = new JTextField("entrez votre nom");
        contenuNom.setPreferredSize(new Dimension(150, 30));

        JPanel panelNom = new JPanel();
        panelNom.setOpaque(false);
        panelNom.add(nom);
        panelNom.add(contenuNom);
        champsInscription.add(panelNom);

        contenuNom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ("entrez votre nom".equals(contenuNom.getText())) {
                    contenuNom.setText("");
                }
            }
        });

        contenuNom.addKeyListener(new KeyListener() {
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
                    verification[0] = gestionnaire.verifierNom(contenuNom.getText());
                    if (!verification[0]) {
                        System.out.println("erreur");
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Votre nom ne peut être composé que de lettres", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        contenuNom.setText("");
                    } else {
                        System.out.println("c'est bon");
                    }
                }
            }
        });

        //PRENOM

        JLabel prenom = new JLabel("Prenom: ");
        final JTextField contenuPrenom = new JTextField("entrez votre prenom");
        contenuPrenom.setPreferredSize(new Dimension(150, 30));

        JPanel panelPrenom = new JPanel();
        panelPrenom.setOpaque(false);
        panelPrenom.add(prenom);
        panelPrenom.add(contenuPrenom);
        champsInscription.add(panelPrenom);

        contenuPrenom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ("entrez votre prenom".equals(contenuPrenom.getText())) {
                    contenuPrenom.setText("");
                }
            }
        });

        contenuPrenom.addKeyListener(new KeyListener() {
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
                    verification[1] = gestionnaire.verifierPrenom(contenuPrenom.getText());
                    if (!verification[1]) {
                        System.out.println("erreur");
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Votre prénom ne peut être composé que de lettres", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        contenuPrenom.setText("");
                    } else {
                        System.out.println("c'est bon");
                    }
                }
            }
        });

        //ADRESSE

        JLabel adresse = new JLabel("Adresse: ");
        final JTextField contenuAdresse = new JTextField("entrez votre adresse");
        contenuAdresse.setPreferredSize(new Dimension(150, 30));

        JPanel panelAdresse = new JPanel();
        panelAdresse.setOpaque(false);
        panelAdresse.add(adresse);
        panelAdresse.add(contenuAdresse);
        champsInscription.add(panelAdresse);

        contenuAdresse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ("entrez votre adresse".equals(contenuAdresse.getText())) {
                    contenuAdresse.setText("");
                }
            }
        });

        contenuAdresse.addKeyListener(new KeyListener() {
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
                    verification[2] = gestionnaire.verifierAdresse(contenuAdresse.getText());
                    if (!verification[2]) {
                        System.out.println("erreur");
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Votre adresse est mauvaise", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        contenuAdresse.setText("");
                    } else {
                        System.out.println("c'est bon");
                    }
                }
            }
        });

        //TELEPHONE

        JLabel tel = new JLabel("Numéro de téléphone: ");
        final JTextField contenuTel = new JTextField("entrez votre numéro");
        contenuTel.setPreferredSize(new Dimension(150, 30));

        JPanel panelTel = new JPanel();
        panelTel.setOpaque(false);
        panelTel.add(tel);
        panelTel.add(contenuTel);
        champsInscription.add(panelTel);

        contenuTel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ("entrez votre numéro".equals(contenuTel.getText())) {
                    contenuTel.setText("");
                }
            }
        });

        contenuTel.addKeyListener(new KeyListener() {
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
                    verification[3] = gestionnaire.verifierTel(contenuTel.getText());
                    if (!verification[3]) {
                        System.out.println("erreur");
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Votre numéro ne peut contenir que 10 chiffres", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        contenuTel.setText("");
                    } else {
                        System.out.println("c'est bon");
                    }
                }
            }
        });

        // SEXE

        final JLabel sexeLabel = new JLabel("Sexe: ");
        JRadioButton homme = new JRadioButton("Homme");
        homme.setOpaque(false);
        JRadioButton femme = new JRadioButton("Femme");
        femme.setOpaque(false);

        JPanel panelSexe = new JPanel();
        panelSexe.setOpaque(false);
        panelSexe.add(sexeLabel);
        panelSexe.add(homme);
        panelSexe.add(femme);

        homme.setSelected(false);

        ButtonGroup bg = new ButtonGroup();
        bg.add(homme);
        bg.add(femme);

        homme.addActionListener(new StateListener());
        femme.addActionListener(new StateListener());

        champsInscription.add(panelSexe);

        // DATE

        JLabel date = new JLabel("Date de naissance: ");
        this.contenuDate = new JButton("Entrez la date de naissance");
        this.contenuDate.setEnabled(false);
        contenuDate.setPreferredSize(new Dimension(150, 30));
        calendrier.setBounds(960, 10, 230, 200);
        JButton leCalendrier = calendrier.getCalendarButton();

        JPanel panelDate = new JPanel();
        panelDate.setOpaque(false);
        panelDate.add(date);
        panelDate.add(contenuDate);
        panelDate.add(leCalendrier);

        MyDateListener listener = new MyDateListener();
        calendrier.addPropertyChangeListener(listener);

        champsInscription.add(panelDate);

        //BOUTON

        final JButton validation = new JButton("Passez à l'étape suivante");
        champsInscription.add(validation);

        validation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                for (int i = 0; i < verification.length; i++) {
                    if (verification[i] == false) {
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Il y a une erreur dans la saisie " + (i + 1), "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
                        break;
                    }
                }
                if (verification[0] && verification[1] && verification[2] && verification[3]) {
                    gestionnaire.inscriptionPersonne(contenuNom.getText(), contenuPrenom.getText(), contenuAdresse.getText(), sexe, contenuTel.getText());
                    champsInscription.removeAll();
                    try {
                        InscriptionJoueurDesign joueur = new InscriptionJoueurDesign();
                        champsInscription.add(joueur.initialisation());
                    } catch (SQLException ex) {
                        Logger.getLogger(InscriptionPersonneDesign.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        });

        this.monPanel.add(contenuInsc);
    }

    private class MyDateListener implements PropertyChangeListener {

        public void propertyChange(PropertyChangeEvent evt) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, calendrier.getLocale());
            calendrier.setMaxSelectableDate(new Date(2005, 01, 01));
            System.out.println();
//            if (calendrier.getDate().before(calendrier.getMaxSelectableDate())) {
                contenuDate.setText(df.format(calendrier.getDate()));
//            } else {
//                JOptionPane error = new JOptionPane();
//                error.showMessageDialog(null, "Votre date de naissance est improbable pour apprendre le JAVA", "Attention", JOptionPane.WARNING_MESSAGE, new ImageIcon("Images/erreur.png"));
//                System.out.println("error");
//            }
        }
    }

    public void actualiserDate() {
        MyDateListener listener = new MyDateListener();
        listener.propertyChange(null);
    }

    @Override
    public void actualiserInformations() {
        actualiserDate();
    }

    class StateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("source : " + ((JRadioButton) e.getSource()).getText() + " - état : " + ((JRadioButton) e.getSource()).isSelected());
            if ("homme".equals(((JRadioButton) e.getSource()).getText())) {
                sexe = true;
            } else if (((JRadioButton) e.getSource()).getText() == "femme") {
                sexe = false;
            }
        }
    }
}
