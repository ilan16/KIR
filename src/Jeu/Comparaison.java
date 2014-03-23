/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import Joueur.GestionnaireJoueur;
import Joueur.Information;
import OpFichier.EcrireFichier;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class Comparaison{ 

    protected EcrireFichier ef;
    
    public Comparaison() {
        try {
            this.ef = new EcrireFichier("brouillon.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void infoTotalJoueur(String pseudo) throws SQLException{
        GestionnaireJoueur j = new GestionnaireJoueur();
        Information info=j.demandeInformation(pseudo);
        
    }
    
    
}
