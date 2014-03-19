package Joueur;

import BDD.Textui;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Inscription {

    private String nom;
    private String prenom;
    private Calendar dateNaissance;
    private String adresse;
    private boolean sexe;
    private String password;
    private String pseudo;
    private Textui u = new Textui();
    private String passwordConf;
    private String tel;
    private String mail;

    public void entreNom() {
        this.nom = u.readString("Nom: ");
    }

    public void entrePrenom() {
        this.prenom = u.readString("Prenom: ");
    }

    public void entreAdresse() {
        this.adresse = u.readString("Adresse: ");
    }

    public void entreSexe() {
        int sex;
        do {
            sex = u.readInt("Sexe (0:F / 1:H): ");
        } while (sex != 0 && sex != 1);

        if (sex == 0) {
            this.sexe = false;
        } else {
            this.sexe = true;
        }
    }

    public void entrePseudo() {
        this.pseudo = u.readString("Pseudo: ");
    }

    public void entreMail() {
        this.mail = u.readString("Entre mail");
    }

    public void entrePassword() {
        this.password = u.readString("Password: ");
    }

    public void entrePasswordConf() {
        this.passwordConf = u.readString("Password de confirmation: ");
    }
    
    public void entreTel() {
        this.tel = u.readString("Tel: ");
    }

//    public Calendar entreDate(){
//        int year = u.readInt("Année: ");
//        int month = u.readInt("Mois: ");
//        int date = u.readInt("Date: ");
//        return this.dateNaissance.set(year, month, date);
//    }
    
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

    public Calendar getDateNaissance() {
        return this.dateNaissance;
    }
    
    public String afficherDateNaissance() {
        return this.dateNaissance.toString();
    }

    /**
     *
     * @param dateNaissance
     */
    public void setDateNaissance(Calendar dateNaissance) {
        this.dateNaissance = dateNaissance;
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

    public String getPasswordConf() {
        return this.passwordConf;
    }

    /**
     *
     * @param passwordConf
     */
    public void setPasswordConf(String passwordConf) {
        this.passwordConf = passwordConf;
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
}
