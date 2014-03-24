/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Jeu.Jeu;
import Jeu.SingletonJeu;
import Joueur.GestionnaireDInscription;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author ilanmalka
 */
public class lesPartiesDesign extends Applet implements Observateur{

    private ImagePanel monPanel;
    private GestionnaireDInscription gestionnaire;
    private Jeu j;

    public lesPartiesDesign() throws SQLException {
        this.j = new Jeu() {};
        this.monPanel = new ImagePanel("leJeu.png");
    }

    public JPanel initialisation() throws IOException {
        this.contenu();
        return this.monPanel;
    }

    public void contenu() throws IOException {
        JPanel lesBoutons = new JPanel();
        lesBoutons.setOpaque(false);
        
        JButton HelloWord = new JButton("Hello Word");
        HelloWord.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SingletonJeu.getInstance().setNiveau(0); 
                removeAll();
                monPanel.add(TypeNiveau());
            }
        });
        lesBoutons.add(HelloWord);
        
        
        JButton If = new JButton("if");
        If.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SingletonJeu.getInstance().setNiveau(1); 
                removeAll();
                monPanel.add(TypeNiveau());
            }
        });
        lesBoutons.add(If);
        
        JButton doWhile = new JButton("Do ...  While");
        doWhile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SingletonJeu.getInstance().setNiveau(2); 
                removeAll();
                monPanel.add(TypeNiveau());
            }
        });
        lesBoutons.add(doWhile);
        
        JButton While = new JButton("While");
        While.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SingletonJeu.getInstance().setNiveau(3); 
                removeAll();
                monPanel.add(TypeNiveau());
            }
        });
        lesBoutons.add(While);
        
        JButton For = new JButton("for");
        For.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SingletonJeu.getInstance().setNiveau(4); 
                removeAll();
                monPanel.add(TypeNiveau());
            }
        });
        lesBoutons.add(For);
        
        JButton tableau = new JButton("tableaux");
        tableau.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SingletonJeu.getInstance().setNiveau(5); 
                removeAll();
                monPanel.add(TypeNiveau());
            }
        });
        lesBoutons.add(While);
        
        monPanel.add(lesBoutons);
    }
    
    public JPanel TypeNiveau(){
        JPanel type = new JPanel();
        
        JButton afficher = new JButton("1. Afficher les résultats");
        type.add(afficher);
        
        JButton completer = new JButton("2. Compléter");
        type.add(completer);
        
        JButton erreur = new JButton("3. Trouver les erreurs");
        type.add(erreur);
        
        JButton programme = new JButton("4. Ecrire le programme");
        type.add(programme);
        
        return type;
    }

    
    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
