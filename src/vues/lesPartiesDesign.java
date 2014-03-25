/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Jeu.Jeu;
import Jeu.SingletonJeu;
import Joueur.GestionnaireDInscription;
import Joueur.GestionnaireJoueur;
import Joueur.SingletonJoueur;
import java.applet.Applet;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author ilanmalka
 */
public class lesPartiesDesign extends Applet implements Observateur {

    private JPanel monContenu;
    private GestionnaireDInscription gestionnaire;
    private Jeu j;

    public lesPartiesDesign() throws SQLException {
        this.j = new Jeu() {
        };
        this.monContenu = new JPanel();
        this.monContenu.setOpaque(false);
        //this.monPanel = new ImagePanel("leJeu.png");
        //this.monPanel.setPreferredSize(new Dimension(1000, 700));
    }

    public JPanel initialisation() throws IOException {
        this.contenu();
        return this.monContenu;
    }

    public void contenu() throws IOException {
        final JPanel lesBoutons = new JPanel();
        lesBoutons.setOpaque(false);

        JButton HelloWord = new JButton("Hello Word");
        HelloWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SingletonJeu.getInstance().setNiveau(0);
                lesBoutons.removeAll();
                monContenu.add(TypeNiveau());
            }
        });
        lesBoutons.add(HelloWord);


        JButton If = new JButton("if");
        If.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SingletonJeu.getInstance().setNiveau(1);
                lesBoutons.removeAll();
                monContenu.add(TypeNiveau());
            }
        });
        lesBoutons.add(If);

        JButton doWhile = new JButton("Do ...  While");
        doWhile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SingletonJeu.getInstance().setNiveau(2);
                lesBoutons.removeAll();
                monContenu.add(TypeNiveau());
            }
        });
        lesBoutons.add(doWhile);

        JButton While = new JButton("While");
        While.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SingletonJeu.getInstance().setNiveau(3);
                lesBoutons.removeAll();
                monContenu.add(TypeNiveau());
            }
        });
        lesBoutons.add(While);

        JButton For = new JButton("for");
        For.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SingletonJeu.getInstance().setNiveau(4);
                lesBoutons.removeAll();
                monContenu.add(TypeNiveau());
            }
        });
        lesBoutons.add(For);

        JButton tableau = new JButton("tableaux");
        tableau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SingletonJeu.getInstance().setNiveau(5);
                lesBoutons.removeAll();
                monContenu.add(TypeNiveau());
            }
        });
        lesBoutons.add(tableau);

        monContenu.add(lesBoutons);

        monContenu.add(precedent());
    }

    public JPanel TypeNiveau() {
        JPanel type = new JPanel();
        type.setOpaque(false);
        type.setLayout((new BoxLayout(type, BoxLayout.PAGE_AXIS)));

        JButton afficher = new JButton("1. Afficher les résultats");
        type.add(afficher);
        afficher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SingletonJeu.getInstance().setTypeNiveau(1);
                     GestionnaireJoueur joueur=new GestionnaireJoueur();
                    if(joueur.verifierNv(SingletonJeu.getInstance().getNiveau() * 4 + SingletonJeu.getInstance().getTypeNiveau(),SingletonJoueur.getInstance().getPseudo())){
                        DesignJeu jeu = new DesignJeu();
                    monContenu.removeAll();
                    try {
                        monContenu.add(jeu.initialisation());
                        monContenu.setOpaque(false);
                    } catch (IOException ex) {
                        Logger.getLogger(lesPartiesDesign.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }else{
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(null, "Vous n'avez pas accès encore à ce niveau mais ça va venir ...", "Impossible d'accès", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Images/pleurer.png"));
                    }
                    
                    //monPanel = new JPanel();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(lesPartiesDesign.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton completer = new JButton("2. Compléter");
        type.add(completer);
        completer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SingletonJeu.getInstance().setTypeNiveau(2);
                    GestionnaireJoueur joueur=new GestionnaireJoueur();
                    if(joueur.verifierNv(SingletonJeu.getInstance().getNiveau() * 4 + SingletonJeu.getInstance().getTypeNiveau(),SingletonJoueur.getInstance().getPseudo())){
                        DesignJeu jeu = new DesignJeu();
                    monContenu.removeAll();
                    try {
                        monContenu.add(jeu.initialisation());
                        monContenu.setOpaque(false);
                    } catch (IOException ex) {
                        Logger.getLogger(lesPartiesDesign.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }else{
                        //ilan
                    }
                    
                    //monPanel = new JPanel();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(lesPartiesDesign.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton erreur = new JButton("3. Trouver les erreurs");
        type.add(erreur);
        erreur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SingletonJeu.getInstance().setTypeNiveau(3);
                     GestionnaireJoueur joueur=new GestionnaireJoueur();
                    if(joueur.verifierNv(SingletonJeu.getInstance().getNiveau() * 4 + SingletonJeu.getInstance().getTypeNiveau(),SingletonJoueur.getInstance().getPseudo())){
                        DesignJeu jeu = new DesignJeu();
                    monContenu.removeAll();
                    try {
                        monContenu.add(jeu.initialisation());
                        monContenu.setOpaque(false);
                    } catch (IOException ex) {
                        Logger.getLogger(lesPartiesDesign.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }else{
                        //ilan
                    }
                    
                    //monPanel = new JPanel();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(lesPartiesDesign.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton programme = new JButton("4. Ecrire le programme");
        type.add(programme);
        programme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SingletonJeu.getInstance().setTypeNiveau(4);
                    GestionnaireJoueur joueur=new GestionnaireJoueur();
                    if(joueur.verifierNv(SingletonJeu.getInstance().getNiveau() * 4 + SingletonJeu.getInstance().getTypeNiveau(),SingletonJoueur.getInstance().getPseudo())){
                        DesignJeu jeu = new DesignJeu();
                    monContenu.removeAll();
                    try {
                        monContenu.add(jeu.initialisation());
                        monContenu.setOpaque(false);
                    } catch (IOException ex) {
                        Logger.getLogger(lesPartiesDesign.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }else{
                        //ilan
                    }
                    
                    //monPanel = new JPanel();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(lesPartiesDesign.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        return type;
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
                DesignInfoJeu d;
                try {
                    d = new DesignInfoJeu();
                    monContenu.add(d.initialisation());
                } catch (SQLException ex) {
                    Logger.getLogger(DesignConnexion.class.getName()).log(Level.SEVERE, null, ex);
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
