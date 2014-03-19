package Jeu;

import OpFichier.EcrireFichier;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Jeu {

	private File inputexo; 
	private File inputcorr;
	private File outputrep;
        protected EcrireFichier ef;
        
        public Jeu(){
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
	public void nvAfficherResultat(int nv) throws FileNotFoundException, IOException{
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

}