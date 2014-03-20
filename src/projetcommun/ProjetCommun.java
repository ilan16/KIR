/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetcommun;

import Joueur.GestionnaireDInscription;
import com.toedter.calendar.JCalendar;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProjetCommun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JCalendar calendrier = new JCalendar();
        Date d = new Date();
        d.setMonth(0);
        d.setDate(1);
        d.setYear(2000);
         calendrier.setMaxSelectableDate(d);
            System.out.println(d);
//        
//        try {
//            GestionnaireDInscription g = new GestionnaireDInscription("jdbc:mysql://localhost:8889/bdd_kir?zeroDateTimeBehavior=convertToNull", "root", "root");
//            System.out.println("r");
//            System.out.println(g.verifierTel("06608059645"));
//        } catch (SQLException ex) {
//            System.out.println("m");
//            Logger.getLogger(ProjetCommun.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
}