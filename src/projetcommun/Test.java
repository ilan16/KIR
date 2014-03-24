/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetcommun;

import OpFichier.LireFichier;
import Joueur.*;
import Joueur.GestionnaireDInscription;
import Joueur.Inscription;
import OpFichier.CompareFichier;
import OpFichier.EcrireFichier;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilanmalka
 */
public class Test {
//    private static Connection con;
//    private static DOA doa;
    
   
    static Scanner sc =  new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println("hbds");
//        try {
//            Connect c = new Connect("jdbc:mysql://localhost:3306/bdd_kir?zeroDateTimeBehavior=convertToNull", "root", "");
//            c.entrePseudo();
//            c.entrePassword();
//            c.isConnexion();
//           // g.inscriptionJoueur();
//            System.out.println("r");
//        } catch (SQLException ex) {
//            System.out.println("m");
//            ex.printStackTrace();
//        }
//        try {
//            String pseudo="azerty";
//            GestionnaireJoueur g = new GestionnaireJoueur("jdbc:mysql://127.0.0.1/phpmyadmin/index.php?db=bdd_kir&token=9ae199269d86e0b5b14d5c1ec2412787", "root", "root");
//            System.out.println("r");
//            String query = "SELECT * FROM joueur WHERE pseudo = '" + pseudo + "'";
//                    try {
//            Statement requete = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//            ResultSet result = requete.executeQuery(query);
//            while (result.next()) {
//                String pseudo = result.getString(1);
//                if (pseudo != "") {
//                    return true;
//                }
//            }
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//            
//        } catch (SQLException ex) {
//            System.out.println("m");
//            Logger.getLogger(ProjetCommun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

