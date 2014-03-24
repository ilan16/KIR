/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Joueur;

import BDD.DOA;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author kevin
 */
public class Information {

    private String nom;
    private String prenom;
    private String adresse;
    private String dateNaissance;
    private boolean sexe;
    private String tel;
    private String pseudo;
    private String mail;
    private int score;
    private int niveau;
    private int nbconnecte;
    private String password;
    private Connection con;
    private DOA doa;

    public Information(String nom, String prenom, String adresse, String dateNaissance, boolean sexe, String tel, String pseudo, String mail, int score, int nv, int nbconnecte) throws SQLException {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.tel = tel;
        this.pseudo = pseudo;
        this.mail = mail;
        this.score = score;
        this.niveau = nv;
        this.nbconnecte = nbconnecte;
        this.doa = new DOA();
        if (this.doa.connexion()) {
            this.con = DriverManager.getConnection(doa.getURL(), doa.getUser(), doa.getPassword());
        }
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
        String query = "UPDATE personne SET nom = '" + nom + "' WHERE pseudo = '" + pseudo + "'";
        try {
            Statement requete = con.createStatement();
            requete.executeUpdate(query);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

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

    public String getCalendarNaissance() {
        return this.dateNaissance;
    }

    /**
     *
     * @param dateNaissance
     */
    public void setCalendarNaissance(String dateNaissance) {
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
}
