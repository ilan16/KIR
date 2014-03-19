/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ilanmalka
 */
public class Design extends Applet implements Observateur {
    
    private JPanel monPanel;
    
    public Design (){
        this.monPanel = new JPanel();
    }

    public JPanel initialisation(){
        this.monPanel.setLayout((new BoxLayout(this.monPanel, BoxLayout.PAGE_AXIS)));
        this.contenuInscription();
        return this.monPanel;
    }
    
    public void contenuInscription(){
        JPanel champsInscription = new JPanel();
        champsInscription.setLayout((new BoxLayout(champsInscription, BoxLayout.PAGE_AXIS)));
        
        // NOM
        
        JLabel nom = new JLabel("Nom: ");
        JTextField contenuNom = new JTextField("entrez votre nom");
        contenuNom.setPreferredSize(new Dimension(150, 30));
        
        JPanel panelNom = new JPanel();
        panelNom.add(nom);
        panelNom.add(contenuNom);
        champsInscription.add(panelNom);
        
        //PRENOM
        
        JLabel prenom = new JLabel("Prenom: ");
        JTextField contenuPrenom = new JTextField("entrez votre prenom");
        contenuPrenom.setPreferredSize(new Dimension(150, 30));
        
        JPanel panelPrenom = new JPanel();
        panelPrenom.add(prenom);
        panelPrenom.add(contenuPrenom);
        champsInscription.add(panelPrenom);
        
        //ADRESSE
        
        JLabel adresse = new JLabel("Adresse: ");
        JTextField contenuAdresse = new JTextField("entrez votre adresse");
        contenuAdresse.setPreferredSize(new Dimension(150, 30));
        
        JPanel panelAdresse = new JPanel();
        panelAdresse.add(adresse);
        panelAdresse.add(contenuAdresse);
        champsInscription.add(panelAdresse);
        
        //TELEPHONE
        
        JLabel tel = new JLabel("Numéro de téléphone: ");
        JTextField contenuTel = new JTextField("entrez votre numéro");
        contenuTel.setPreferredSize(new Dimension(150, 30));
        
        JPanel panelTel = new JPanel();
        panelTel.add(tel);
        panelTel.add(contenuTel);
        champsInscription.add(panelTel);
        
        // SEXE
        
        JLabel sexe = new JLabel("Sexe: ");
        JCheckBox homme = new JCheckBox("Homme");
        JCheckBox femme = new JCheckBox("Femme");

        JPanel panelSexe = new JPanel();
        panelSexe.add(sexe);
        panelSexe.add(homme);
        panelSexe.add(femme);
        
        
        homme.addActionListener(new StateListener());
        femme.addActionListener(new StateListener());
        
        
        
        this.monPanel.add(champsInscription);
    }
    
    @Override
    public void actualiserInformations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class StateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("source : " + ((JCheckBox)e.getSource()).getText() + " - état : " + ((JCheckBox)e.getSource()).isSelected());        }
    }
    
}
