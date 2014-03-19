package BDD;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DOA {

    private String URL = "";
    private String user = "";
    private String password = "";
    private java.sql.Connection dbConnect = null;
    private java.sql.Statement dbStatement = null;

    public DOA(String url, String user, String password) {
        this.URL = url;
        this.user = user;
        this.password = password;
    }

    public String getURL() {
        return this.URL;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean connexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException ie) {
            ie.printStackTrace();
            return false;
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
            return false;
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            return false;
        }
        try {
//            java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_kir?zeroDateTimeBehavior=convertToNull", "root", "root");
            java.sql.Connection connection = DriverManager.getConnection(this.URL, this.user, this.password);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ResultSet resultatRequete(String sql) {
        try {
            ResultSet rs = this.dbStatement.executeQuery(sql);
            return rs;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return null;
    }
    
    public void close() {
        try {
            this.dbStatement.close();
            this.dbConnect.close();
            this.dbConnect.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}