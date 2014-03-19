/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.applet.Applet;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author ilanmalka
 */
public class Design extends Applet implements Observateur {

    private JPanel monPanel;
    private JTextField contenuDate;
    private JDateChooser calendrier;

    public Design() {
        this.monPanel = new JPanel();
        this.calendrier = new JDateChooser();
    }

    public JPanel initialisation() {
        this.monPanel.setLayout((new BoxLayout(this.monPanel, BoxLayout.PAGE_AXIS)));
        this.contenuInscription();
        return this.monPanel;
    }

    public void contenuInscription() {
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
        JRadioButton homme = new JRadioButton("Homme");
        JRadioButton femme = new JRadioButton("Femme");

        JPanel panelSexe = new JPanel();
        panelSexe.add(sexe);
        panelSexe.add(homme);
        panelSexe.add(femme);

        homme.setSelected(true);

        ButtonGroup bg = new ButtonGroup();
        bg.add(homme);
        bg.add(femme);

        homme.addActionListener(new StateListener());
        femme.addActionListener(new StateListener());

        champsInscription.add(panelSexe);

        // DATE

        JLabel date = new JLabel("Date de naissance: ");
        this.contenuDate = new JTextField("Entrez la date de naissance");
        contenuDate.setPreferredSize(new Dimension(150, 30));
        calendrier.setBounds(960, 10, 230, 200);
        JButton leCalendrier = calendrier.getCalendarButton();

        JPanel panelDate = new JPanel();
        panelDate.add(date);
        panelDate.add(contenuDate);
        panelDate.add(leCalendrier);

        MyDateListener listener = new MyDateListener();
        calendrier.addPropertyChangeListener(listener);

        champsInscription.add(panelDate);

        this.monPanel.add(champsInscription);
    }

    private class MyDateListener implements PropertyChangeListener {

        public void propertyChange(PropertyChangeEvent evt) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, calendrier.getLocale());
            contenuDate.setText(df.format(calendrier.getDate()));
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
        }
    }
}
