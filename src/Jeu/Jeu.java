package Jeu;

import Joueur.GestionnaireJoueur;
import OpFichier.CompareFichier;
import OpFichier.EcrireFichier;
import OpFichier.LireFichier;
import OpFichier.OpJanino;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.commons.compiler.CompileException;

public class Jeu {

    int rand = 0;
    private File inputexo;
    private File inputcorr;
    private File outputrep;
    protected EcrireFichier ef;

    public Jeu() {
        try {
            this.ef = new EcrireFichier("Monresultat.txt");
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
    
    public String AfficherEnoncer(int nv) throws IOException {
        int type = (nv / 4) + 1;
        int level = nv % 4;
        if (nv % 4 == 0) {
            type--;
        }
        Random r = new Random();
        rand = 1 + r.nextInt(2);
        LireFichier l = new LireFichier("nosExos//exos//exo" + type + "." + level + "." + this.rand + ".txt");
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<String> text = l.lireText();
        String enoncer = ArrayToString(text);
        return enoncer;
    }

    public String AfficherZoneRep(int nv) throws IOException {
        if ((nv % 4) == 1 || (nv % 4) == 0) {
            LireFichier l = new LireFichier("nosExos//rep//pageBlanche.txt");
            ArrayList<String> a = new ArrayList<String>();
            l.lireText();

        } else {
            int type = (nv / 4) + 1;
            int level = nv % 4;
            if (nv % 4 == 0) {
                type--;
            }
            LireFichier l = new LireFichier("nosExos//exos//exobis" + type + "." + level + "." + this.rand + ".txt");
            ArrayList<String> a = new ArrayList<String>();
            ArrayList<String> text = l.lireText();
            String enoncer = ArrayToString(text);
            return enoncer;
        }
        return null;
    }

    public boolean resultatAfficherResultat(int nv, String rep) throws IOException {
        int type = (nv / 4) + 1;
        int level = nv % 4;
        if (nv % 4 == 0) {
            type--;
        }
        rep = rep.replace(" ", "");

        PrintWriter fileout = new PrintWriter("Monresultat.txt");
        fileout.println(rep);
        fileout.flush();
        fileout.close();    
        CompareFichier l = new CompareFichier("nosExos//rep//rep" + type + "." + level + "." + this.rand + ".txt");
        boolean reussi = l.comparerFichier();
        return reussi;

    }

    public boolean resultatCompleter(int nv, String rep) throws CompileException, FileNotFoundException, InvocationTargetException, IOException {
        if (rep.length() > 200) {
            OpJanino o = new OpJanino();
            o.ecrireResultat(rep);
            int type = (nv / 4) + 1;
            int level = nv % 4;
            if (nv % 4 == 0) {
                type--;
            }
            CompareFichier l = new CompareFichier("nosExos//rep//rep" + type + "." + level + "." + this.rand + ".txt");
            boolean reussi = l.comparerFichier();
            return reussi;
        }

        return false;
    }

    public boolean nvReussi(int nv, String a) throws IOException, FileNotFoundException, CompileException {
        if (resultatAfficherResultat(nv, a)) {
            return true;
        }
        try {
            if (resultatCompleter(nv, a)) {
                return true;
            }
        } catch (InvocationTargetException ex) {
            return false;
        }
        return false;
    }

    public boolean ajouterPointAfficher(int nv, String pseudo, int temp, String a) throws SQLException, IOException, FileNotFoundException {
        GestionnaireJoueur j = new GestionnaireJoueur();
        int score2 = score(nv, temp);
        j.newScore(nv, pseudo, score2);
        j.nvSuivant(pseudo, nv);
        return true;
    }

    public String ArrayToString(ArrayList<String> chaine) {
        String chaine2 = "";
        for (int i = 0; i < chaine.size(); i++) {
            chaine2 += chaine.get(i) + "\n";
        }
        return chaine2;
    }

    public int score(int nv, int temp) throws SQLException {
        GestionnaireJoueur j = new GestionnaireJoueur();
        int score2 = 0;
        int[] interval = j.recupererTemp(nv);
        if (temp <= interval[0]) {
            score2 = 150;
        } else if (temp <= interval[1]) {
            score2 = 100;
        } else if (temp <= interval[2]) {
            score2 = 75;
        } else {
            score2 = 50;
        }
        return score2;
    }

}
