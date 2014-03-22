package Jeu;

import Joueur.GestionnaireJoueur;
import OpFichier.EcrireFichier;
import OpFichier.LireFichier;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Jeu {

    int rand = 1;
    private File inputexo;
    private File inputcorr;
    private File outputrep;
    protected EcrireFichier ef;

    public Jeu() {
        try {
            this.ef = new EcrireFichier("brouillon.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public File getInputexo() {
        return this.inputexo;
    }

    /**
     *
     * @param inputexo
     */
    public void setInputexo(File inputexo) {
        this.inputexo = inputexo;
    }

    public File getInputcorr() {
        return this.inputcorr;
    }

    /**
     *
     * @param inputcorr
     */
    public void setInputcorr(File inputcorr) {
        this.inputcorr = inputcorr;
    }

    public File getOutputRep() {
        return this.outputrep;
    }

    /**
     *
     * @param output
     */
    public void setOutputRep(File output) {
        this.outputrep = output;
    }

    /**
     *
     * @param nv
     */
    public void nvAfficherResultat(int nv) throws FileNotFoundException, IOException {
        ef.ecrireDansFichier();
    }

    /**
     *
     * @param nv
     */
    public abstract void nvCompleterTrous(int nv);

    /**
     *
     * @param nv
     */
    public abstract void nvTrouverErreurs(int nv);

    /**
     *
     * @param nv
     */
    public abstract void nvCreerProg(int nv);

    public void AfficherEnoncer(int nv) throws IOException {
        int type = (nv / 4) + 1;
        int level = 0;
        if(nv % 4==0){
            level=4;
        }else{
            level=nv % 4;
        }
        Random r = new Random();
        rand = 1 + r.nextInt(1);
        LireFichier l = new LireFichier("nosExos\\exos\\exo" + type + "." + level + "." + this.rand + ".txt");
        ArrayList<String> a = new ArrayList<String>();
        l.lireText();
        l.afficherText();
    }

    public void AfficherZoneRep(int nv) throws IOException {
        if ((nv % 4) == 1 || (nv % 4) == 0) {
            LireFichier l = new LireFichier("nosExos\\rep\\pageBlanche.txt");
            ArrayList<String> a = new ArrayList<String>();
            l.lireText();
            l.afficherText();
        } else {
            int type = (nv / 4) + 1;
            int level = nv % 4;
            LireFichier l = new LireFichier("nosExos\\rep\\rep" + type + "." + level + "." + this.rand + ".txt");
            ArrayList<String> a = new ArrayList<String>();
            l.lireText();
            l.afficherText();
        }
    }
    
        public String recupererReponse(){
        return null;
    }
    
    public boolean resultatAfficherResultat(int nv){ 
        String result=recupererReponse();
        
        return false;
    }
    
     public boolean resultatCompleter(int nv){
        return false;
    }
     
     public boolean ajouterPointAfficher(int nv,String pseudo,int temp) throws SQLException{
         if(resultatAfficherResultat(nv)){
             GestionnaireJoueur j = new GestionnaireJoueur("jdbc:mysql://localhost:3306/bdd_kir?zeroDateTimeBehavior=convertToNull", "root", "");
             int score2=0;
             int [] interval=j.recupererTemp(nv);
             if(temp<= interval[0]){
                 score2=150;
             }else if(temp<= interval[1]){
                 score2=100;
             }else if(temp<= interval[2]){
                 score2=75;
             }else{
                 score2=50;
             }
             j.newScore(nv, pseudo,score2);
             j.nvSuivant(pseudo,nv);
             return true;
         }
        return false;
     }

}
