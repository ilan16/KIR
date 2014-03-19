package Joueur;

import BDD.DOA;
import BDD.Textui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import projetcommun.Test;

public class GestionnaireDInscription {

    private String passwordConf = "";
    private Connection con;
    private DOA doa;
    private String chaine = "([a-zA-Z -]*)";
    private String tout = "([a-zA-Z0-9 ._-]*)";
    private String chiffre = "([0-9]*)";
    private String mail = "(^[0-9a-z._-]+@{1}[0-9a-z.-]{3,}[.]{1}[a-z]{2,3}$)";
    private Inscription inscription;
    private Joueur joueur;
    private Textui u = new Textui();

    public GestionnaireDInscription(String url, String user, String pwd, Inscription insc) throws SQLException {
        this.inscription = insc;
        this.doa = new DOA(url, user, pwd);
        if (this.doa.connexion()) {
            this.con = DriverManager.getConnection(doa.getURL(), doa.getUser(), doa.getPassword());
        }
    }
    
    public GestionnaireDInscription(String url, String user, String pwd) throws SQLException {
        this.doa = new DOA(url, user, pwd);
        if (this.doa.connexion()) {
            this.con = DriverManager.getConnection(doa.getURL(), doa.getUser(), doa.getPassword());
        }
    }

    public boolean inscriptionPersonne() {
        System.out.println("d");
        if (this.verifierNom() && this.verifierPrenom() && this.verifierAdresse() && this.verifierTel()) {
            String query = "INSERT INTO personne (nom,prenom,adresse,sexe,tel) VALUES ('" + this.inscription.getNom() + "','" + this.inscription.getPrenom() + "','" + this.inscription.getAdresse() + "'," + this.inscription.getSexe() + ",'" + this.inscription.getTel() + "')";
            System.out.println("etape 1");
            try {
                System.out.println("etape 2r");
                Statement requete = con.createStatement();
                System.out.println("etape 2rprme");
                requete.executeUpdate(query);
                System.out.println("etape 3r");
            } catch (Exception e1) {
                System.out.println("etape 2m");
                e1.printStackTrace();
            }
            return true;
        }
        System.out.println("etape merdique");
        return false;
    }

    public int recupDernierId() {
        String query = "SELECT MAX(id_personne) FROM personne";
        try {
            Statement requete = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet result = requete.executeQuery(query);
            while (result.next()) {
                int id = result.getInt(1);
                return id;
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return 0;
    }

    public boolean inscriptionJoueur() {
        if (this.verifierMail()&& this.verifierPassword() && this.verifierPasswordConf() && this.equals()) {
            String query = "INSERT INTO joueur (pseudo, mail, password, id_personne) "
                    + "VALUES ('" + this.inscription.getPseudo() + "','" + this.inscription.getMail() + "','" + this.inscription.getPassword() + "'," + this.recupDernierId() + ")";
            System.out.println("etape 1");
            try {
                Statement requete = con.createStatement();
                requete.executeUpdate(query);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            return true;
        }
        System.out.println("etape merdique");
        return false;
    }

    public boolean verifierNom() {
        System.out.println("nom");
        if (this.inscription.getNom().matches(this.chaine)) {
            return true;
        }
        return false;
    }

    public boolean verifierPrenom() {
        System.out.println("prenom");
        if (this.inscription.getPrenom().matches(this.chaine)) {
            return true;
        }
        return false;
    }

    public boolean verifierDateNaissance() {
        // TODO - implement GestionnaireDInscription.verifierDateNaissance
        throw new UnsupportedOperationException();
    }

    public boolean verifierAdresse() {
        System.out.println("ADRESSE");
        if (this.inscription.getAdresse().matches(this.tout)) {
            return true;
        }
        return false;
    }

    public boolean verifierTel() {
        System.out.println("tel");
        if (this.inscription.getTel().length() != 10) {
            return false;
        }
        if (this.inscription.getTel().matches(this.chiffre)) {
            return true;
        }
        return false;
    }

    public boolean verifierPassword() {
        if (this.inscription.getPassword().length() < 6 || this.inscription.getPassword().length() > 16) {
            return false;
        }
        if (this.inscription.getPassword().matches(this.tout)) {
            return true;
        }
        return false;
    }

    public boolean verifierPasswordConf() {
        if (this.inscription.getPassword().length() < 6 || this.inscription.getPassword().length() > 16) {
            return false;
        } else {
        }
        if (this.inscription.getPassword().matches(this.tout)) {
            return true;
        }
        return false;
    }

    public boolean verifierPseudo() {
        if (this.inscription.getPseudo().length() > 10) {
            return false;
        }
        if (this.inscription.getPseudo().matches(this.tout)) {
            return true;
        }
        return false;
    }

    public boolean verifierMail() {
        if (this.inscription.getMail().matches(this.mail)) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param password
     */
    public boolean equals() {
        if (this.verifierPassword() && this.verifierPasswordConf()) {
            if (inscription.getPassword().equals(inscription.getPasswordConf())) {
                return true;
            }
        }
        return false;
    }
}
