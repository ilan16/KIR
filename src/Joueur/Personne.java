package Joueur;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Personne {

    private String nom;
    private String prenom;
    private String adresse;
    private Calendar dateNaissance;
    private boolean sexe;
    private String tel;
    private static int numPersonne;

    /**
     *
     * @param nom
     * @param prenom
     * @param adresse
     * @param dateNaissance
     * @param sexe
     * @param tel
     */
    public Personne(String nom, String prenom, String adresse, Calendar dateNaissance, boolean sexe, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.tel = tel;
    }

    /**
     *
     * @param nom
     * @param prenom
     */
    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return this.nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    /**
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    /**
     *
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Calendar getCalendarNaissance() {
        return this.dateNaissance;
    }

    /**
     *
     * @param dateNaissance
     */
    public void setCalendarNaissance(Calendar dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public boolean getSexe() {
        return this.sexe;
    }

    /**
     *
     * @param sexe
     */
    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    public String getTel() {
        return this.tel;
    }

    /**
     *
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    public int age() {
        Calendar cal = new GregorianCalendar();
        int anneeDate= 0, auj = 0;
        auj = cal.get(Calendar.YEAR);
        anneeDate = this.dateNaissance.get(Calendar.YEAR);
        return (auj - anneeDate);
    }

    public int getNumPersonne() {
        return this.numPersonne;
    }

    /**
     *
     * @param numPersonne
     */
    public void setNumPersonne(int numPersonne) {
        this.numPersonne = numPersonne;
    }
}