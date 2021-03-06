package Joueur;

import BDD.DOA;
import BDD.Textui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

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

    public GestionnaireDInscription(Inscription insc) throws SQLException {
        this.inscription = insc;
        this.doa = new DOA();
        if (this.doa.connexion()) {
            this.con = DriverManager.getConnection(doa.getURL(), doa.getUser(), doa.getPassword());
        }
    }

    public GestionnaireDInscription() throws SQLException {
        this.doa = new DOA();
        if (this.doa.connexion()) {
            this.con = DriverManager.getConnection(doa.getURL(), doa.getUser(), doa.getPassword());
        }
    }

    public boolean inscriptionPersonne(String nom, String prenom, String adresse, boolean sexe, String tel) {
        String query = "INSERT INTO personne (nom,prenom,adresse,sexe,tel) VALUES ('" + nom + "','" + prenom + "','" + adresse + "'," + sexe + ",'" + tel + "')";

        try {
            Statement requete = con.createStatement();
            requete.executeUpdate(query);
            return true;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
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

     public boolean inscriptionJoueur(String pseudo, String mail, String password) {
        String query = "INSERT INTO joueur (pseudo, mail, password, id_personne) "
                + "VALUES ('" + pseudo + "','" + mail + "','" + password + "'," + this.recupDernierId() + ")";
        try {
            Statement requete = con.createStatement();
            requete.executeUpdate(query);
            return true;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return false;
    }

    public boolean verifierNom(String nom) {
        if (nom.matches(this.chaine)) {
            return true;
        }
        return false;
    }

    public boolean verifierPrenom(String prenom) {
        if (prenom.matches(this.chaine)) {
            return true;
        }
        return false;
    }

    public boolean verifierDateNaissance() {
        // TODO - implement GestionnaireDInscription.verifierDateNaissance
        throw new UnsupportedOperationException();
    }

    public boolean verifierAdresse(String adresse) {
        if (adresse.matches(this.tout)) {
            return true;
        }
        return false;
    }

    public boolean verifierTel(String tel) {
        if (tel.length() != 10) {
            return false;
        }
        if (tel.matches(this.chiffre)) {
            return true;
        }
        return false;
    }

    public boolean verifierPassword(String pwd) {
        if (pwd.length() < 6 || pwd.length() > 16) {
            return false;
        }
        if (pwd.matches(this.tout)) {
            return true;
        }
        return false;
    }

    public boolean verifierPasswordConf(String pwd) {
        if (pwd.length() < 6 || pwd.length() > 16) {
            return false;
        } else {
        }
        if (pwd.matches(this.tout)) {
            return true;
        }
        return false;
    }

    public boolean verifierPseudo(String pseudo) {
        if (pseudo.length() > 10) {
            return false;
        }
        if (pseudo.matches(this.tout)) {
            return true;
        }
        return false;
    }

    public boolean verifierMail(String mail) {
        if (mail.matches(this.mail)) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param password
     */
    public boolean equals(String pwd, String pwdc) {
        if (this.verifierPassword(pwd) && this.verifierPasswordConf(pwdc)) {
            if (pwd.equals(pwdc)) {
                return true;
            }
        }
        return false;
    }
}
