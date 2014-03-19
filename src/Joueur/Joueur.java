package Joueur;

import java.util.Calendar;

public class Joueur extends Personne {

	private String pseudo;
	private String mail;
	private int score;
	private int niveau;
	private int nbconnecte;
	private String password;
        

	public Joueur(String nom, String prenom, String adresse, Calendar dateNaissance, boolean sexe, String tel, String pseudo, String mail, String password) {
		super(nom,prenom,adresse,dateNaissance,sexe,tel);
                this.pseudo=pseudo;
                this.mail=mail;
                this.password=password;
	}
        
	public Joueur(String nom, String prenom, String pseudo, String mail, String password) {
		super(nom,prenom);
                
	}

	public String getPseudo() {
		return this.pseudo;
	}

	/**
	 * 
	 * @param pseudo
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMail() {
		return this.mail;
	}

	/**
	 * 
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getScore() {
		return this.score;
	}

	/**
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	public int getNiveau() {
		return this.niveau;
	}

	/**
	 * 
	 * @param niveau
	 */
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getNbconnecte() {
		return this.nbconnecte;
	}

	/**
	 * 
	 * @param nbconnecte
	 */
	public void setNbconnecte(int nbconnecte) {
		this.nbconnecte = nbconnecte;
	}

	public boolean connectionValide(String user,String pwd) {
		// TODO - implement Joueur.connectionValide
		throw new UnsupportedOperationException();
	}

	public void estConnecte() {
		// TODO - implement Joueur.estConnecte
		throw new UnsupportedOperationException();
	}

	public int mondeNiveau() {
		// TODO - implement Joueur.mondeNiveau
		throw new UnsupportedOperationException();
	}

	public int niveauDifficulte() {
		// TODO - implement Joueur.niveauDifficulte
		throw new UnsupportedOperationException();
	}

	public String getPassword() {
		return this.password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @param i
	 * @param m
	 */
	public void informationAmodifier(int i, String m) {
		// TODO - implement Joueur.informationAmodifier
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param i
	 * @param m
	 */
	private void verifInfos(int i, String m) {
		// TODO - implement Joueur.verifInfos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param i
	 * @param m
	 */
	private void modif(int i, String m) {
		// TODO - implement Joueur.modif
		throw new UnsupportedOperationException();
	}

	public void remiseZero() {
		// TODO - implement Joueur.remiseZero
		throw new UnsupportedOperationException();
	}

}