/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import Joueur.Connect;
import Joueur.GestionnaireDInscription;
import Joueur.GestionnaireJoueur;
import Joueur.Information;
import com.toedter.calendar.JDateChooser;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ilanmalka
 */
public class DesignInfoJeu extends Applet implements Observateur {

    private JPanel monContenu;
    private Connect connexion;
    private GestionnaireDInscription gestionnaire;

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

    public void contenu(){
        JPanel lesBoutons = new JPanel();
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
        
        vertical.add(comparer);
        
        JButton jouer = new JButton(new ImageIcon("Images/Boutons/jouer.png"));
        jouer.setOpaque(false);
        jouer.setContentAreaFilled(false);
        jouer.setBorderPainted(false);
        
        lesBoutons.add(vertical);
        lesBoutons.add(jouer);
        
        this.monContenu.add(lesBoutons);
        
    }
    
    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
