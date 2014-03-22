/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ilanmalka
 */
public class MenuPrincipal extends Applet implements Observateur {

    private ImagePanel monPanel;

    public MenuPrincipal() {
        this.monPanel = new ImagePanel("fondJeu.png");
        this.monPanel.setLayout(new BorderLayout());
        this.monPanel.setPreferredSize(new Dimension(700, 400));
    }
    
    public JPanel initialisation() {
        this.lesBoutons();
        return this.monPanel;
    }

    public void lesBoutons() {
        
        JPanel sud = new JPanel();
        sud.setLayout((new BoxLayout(sud, BoxLayout.PAGE_AXIS)));
        
        JButton connexion = new JButton(new ImageIcon("Images/Boutons/connexion.png"));
        connexion.setOpaque(false);
        connexion.setContentAreaFilled(false);
        connexion.setBorderPainted(false);
        
        connexion.setAlignmentX(Component.CENTER_ALIGNMENT);
        //sud.add(Box.createVerticalGlue()); 
        sud.add(connexion);
        
        connexion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   DesignConnexion connexion = new DesignConnexion();
                    try {
                        Fenetre f = new Fenetre("Inscription");
                        f.setContentPane(connexion.initialisation());
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                } catch (SQLException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });

        JButton inscription = new JButton(new ImageIcon("Images/Boutons/inscription.png"));
        inscription.setOpaque(false);
        inscription.setContentAreaFilled(false);
        inscription.setBorderPainted(false);
        
        inscription.setAlignmentX(Component.CENTER_ALIGNMENT);
        sud.add(inscription);
        sud.setOpaque(false);
        
        inscription.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   InscriptionPersonne ip = new InscriptionPersonne();
                    try {
                        Fenetre f = new Fenetre("Inscription");
                        f.setContentPane(ip.initialisation());
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                } catch (SQLException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
        
        this.monPanel.add(sud, BorderLayout.SOUTH);
    }

    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
