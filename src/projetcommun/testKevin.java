/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetcommun;

import Jeu.Jeu;
import Joueur.GestionnaireJoueur;
import OpFichier.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.codehaus.commons.compiler.CompileException;

/**
 *
 * @author kevin
 */
public class testKevin {
       public static void main(String[] args) throws CompileException, InvocationTargetException, FileNotFoundException, SQLException, IOException {
//        Inscription insc = new Inscription();
//        insc.entreMail();
//        insc.entrePseudo();
////        insc.entreAdresse();
////        insc.entreNom();
//        insc.entrePassword();
//        insc.entrePasswordConf();
////        insc.entrePrenom();
////        insc.entreTel();
////        insc.entreSexe();
//        
//        try {
//            GestionnaireDInscription g = new GestionnaireDInscription("jdbc:mysql://localhost:3306/bdd_kir?zeroDateTimeBehavior=convertToNull", "root", "", insc);
//            System.out.println("r");
//            g.inscriptionJoueur();
//        } catch (SQLException ex) {
//            System.out.println("m");
//            Logger.getLogger(ProjetCommun.class.getName()).log(Level.SEVERE, null, ex);
//        }

//           GestionnaireJoueur j = new GestionnaireJoueur("jdbc:mysql://localhost:3306/bdd_kir?zeroDateTimeBehavior=convertToNull", "root", "");
//           int a=j.compareToScore("kvn0026","azerty" );
//           boolean a =j.remiseAZero("szdzd");
//           int a =j.getNv("kvn0026");
//           boolean a =j.verifierNv(2, "kvn0026");
//           System.out.println(a);
//           j.connectionReussie("kvn0026");
//           Information i=j.demandeInformation("kvn0026");
//           System.out.println(i.getNbconnecte());
//           System.out.println(j.newScore(2, "kvn0026", 50));
//           j.nvSuivant("azerty");
//             int[] a=j.recupererTemp(0);
//             for(int i=0;i<3;i++){
//                 System.out.println(a[i]);
//             }
           
           
            Jeu j =new Jeu() {};
//            j.AfficherEnoncer(1);
           
//           int a = 7;
//        System.out.println("a");
//        System.out.println(a);
//        System.out.println("a: " + a);
//        
//        int b=8;
//        System.out.println(b);
//        System.out.println("a + b : " + a+b);
//        System.out.println("a - b : " + (a-b));
//        System.out.println((a + 2) > b);
           
//           CompareFichier l = new CompareFichier("nosExos\\rep\\rep1.1.2.txt");
//        ArrayList<String> a = new ArrayList<String>();
//        l.comparerFichier();
            String a="           int a = 7;\n" +
"        System.out.println(\"a\");\n" +
"        System.out.println(a);\n" +
"        System.out.println(\"a: \" + a);\n" +
"        \n" +
"        int c=8;\n" +
"        System.out.println(c);\n" +
"        System.out.println(\"a + c : \" + a+c);\n" +
"        System.out.println(\"a - c : \" + (a-c));\n" ;
            j.resultatCompleter(1, a);
            CompareFichier l = new CompareFichier("nosExos\\rep\\rep1.1.2.txt");
//        ArrayList<String> a = new ArrayList<String>();
        l.comparerFichier();
            
            
    }
}