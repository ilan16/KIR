/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Joueur;

import BDD.DOA;
import BDD.Textui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ilanmalka
 */
public class Connect {

    private Textui u = new Textui();
    private GestionnaireDInscription gi;
    private Connection con;
    private DOA doa;
    private String pseudo;
    private String password;
    private boolean isConnexion;

    public Connect() throws SQLException {
        this.isConnexion = false;
        this.doa = new DOA();
        if (this.doa.connexion()) {
            this.con = DriverManager.getConnection(doa.getURL(), doa.getUser(), doa.getPassword());
        }
    }

    public void entrePseudo() {
        this.pseudo = u.readString("Pseudo: ");
    }

    public void entrePassword() {
        this.password = u.readString("Password: ");
    }

    public boolean verifier() {
        String query = "SELECT * FROM joueur WHERE pseudo = '" + this.pseudo + "' AND password = '" + this.password + "'";
        try {
            Statement requete = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet result = requete.executeQuery(query);
            while (result.next()) {
                String pseudo = result.getString(1);
                if (pseudo != "") {
                    return true;
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return false;
    }
    
    public boolean verifier(String pseudo, String password) {
        String query = "SELECT * FROM joueur WHERE pseudo = '" + pseudo + "' AND password = '" + password + "'";
        try {
            Statement requete = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet result = requete.executeQuery(query);
            while (result.next()) {
                String Lepseudo = result.getString(1);
                if (Lepseudo != "") {
                    return true;
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return false;
    }

    public void isConnexion() {
        if (this.verifier()) {
            this.isConnexion = true;
        }
        
    }

    public boolean getIsConnexion() {
        return this.isConnexion;
    }

    private void setIsConnexion(boolean conn) {
        this.isConnexion = conn;
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
}
