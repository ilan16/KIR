package Joueur;

import Joueur.*;
import BDD.DOA;
import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionnaireJoueur {

    private boolean[] validerNv;
    private DOA doa;
    private Connection con;

    public GestionnaireJoueur() throws SQLException {
        this.doa = new DOA();
        if (this.doa.connexion()) {
            this.con = DriverManager.getConnection(doa.getURL(), doa.getUser(), doa.getPassword());
        }
    }

    public boolean[] getValiderNv() {
        return this.validerNv;
    }

    /**
     *
     * @param validerNv
     */
    public void setValiderNv(boolean[] validerNv) {
        this.validerNv = validerNv;
    }

    /**
     *
     * @param j
     */
    public boolean demandeExistance(String pseudo) {
        String query = "SELECT * FROM joueur WHERE pseudo = '" + pseudo + "'";

//        mysql_num_rows($result0) = 0 , alors la requête $result0 n'a rien retourné. 
        try {
            Statement requete = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet result = requete.executeQuery(query);
            while (result.next()) {
                int nombreColonnes = result.getRow();
                if (nombreColonnes == 1) {
                    return true;
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param j
     */
    public int compareToNv(String monPseudo, String pseudo2) {
        int monId_partie = getNv(monPseudo);
        int id_partie2 = getNv(pseudo2);
        return (monId_partie - id_partie2);
    }

    /**
     *
     * @param j
     */
    public int compareToScore(String monPseudo, String pseudo2) {
        int monScore = getScoreFinal(monPseudo);
        int score2 = getScoreFinal(pseudo2);
        return (monScore - score2);
    }

    public int getScoreFinal(String pseudo) {
        if (demandeExistance(pseudo)) {
            int monScore = 0;
            String query1 = "SELECT score FROM joueur WHERE pseudo = '" + pseudo + "'";
            try {
                Statement requete = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                ResultSet result1 = requete.executeQuery(query1);
                while (result1.next()) {
                    monScore = result1.getInt(1);
                }
                return (monScore);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * @param nv
     * @param pseudo
     * @return
     */
    public int scoreNv(int nv, String pseudo) {
        if (verifierNv(nv, pseudo)) {
            int monScore = 0;
            String query1 = "SELECT score FROM score WHERE pseudo = '" + pseudo + "' and id_partie=" + nv + "";
            try {
                Statement requete = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                ResultSet result1 = requete.executeQuery(query1);
                while (result1.next()) {
                    monScore = result1.getInt(1);
                }
                return (monScore);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return 0;

    }

    public boolean newScore(int nv, String pseudo, int score2) {

        if (verifierNv(nv, pseudo)) {
            String query = "";
            int diff = 0;
            if (monNiveau(nv, pseudo)) {
                diff = score2;
                query = "INSERT INTO score (id_partie,pseudo,score) VALUES (" + nv + ",'" + pseudo + "'," + score2 + ")";
            }
            if (scoreNv(nv, pseudo) < score2) {
                System.out.println("zertyuioertyuio");
                diff = score2 - scoreNv(nv, pseudo);
                query = "UPDATE score SET score = " + score2 + " WHERE pseudo = '" + pseudo + "' and id_partie=" + nv + "";
            } 
            if(scoreNv(nv, pseudo) >= score2){
                return false;
            }
            String query2 = "UPDATE joueur SET score = " + (getScoreFinal(pseudo) + diff) + " WHERE pseudo = '" + pseudo + "'";
            try {
                Statement requete = con.createStatement();
                requete.executeUpdate(query);
                requete.executeUpdate(query2);
                return true;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return false;
    }

    /**
     *
     * @param nv
     */
    public boolean verifierNv(int nv, String pseudo) {
        if (demandeExistance(pseudo)) {
            int monId_partie = getNv(pseudo);
            if (nv <= monId_partie) {
                return true;
            }
        }
        return false;
    }

    public int getNv(String pseudo) {
        if (demandeExistance(pseudo)) {
            int monId_partie = 0;
            String query1 = "SELECT id_partie FROM joueur WHERE pseudo = '" + pseudo + "'";
            try {
                Statement requete = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                ResultSet result1 = requete.executeQuery(query1);
                while (result1.next()) {
                    monId_partie = result1.getInt(1);
                }
                return (monId_partie);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return 0;
    }

    public boolean remiseAZero(String pseudo) {
        if (demandeExistance(pseudo)) {
            String query1 = "UPDATE joueur SET score = 0  WHERE pseudo = '" + pseudo + "'";
            String query2 = "UPDATE joueur SET id_partie=1 WHERE pseudo = '" + pseudo + "'";
            String query3 = "UPDATE score SET score = 0  WHERE pseudo = '" + pseudo + "'";
            try {
                Statement requete = con.createStatement();
                requete.executeUpdate(query1);
                requete.executeUpdate(query2);
                requete.executeUpdate(query3);
                return true;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return false;
    }

    public Information demandeInformation(String pseudo) {
        if (demandeExistance(pseudo)) {
            String query = "SELECT pseudo,mail,nbconnexion,score,id_personne,id_partie FROM joueur WHERE pseudo = '" + pseudo + "'";

            try {
                Statement requete = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                ResultSet result = requete.executeQuery(query);

                String pseudo2 = "";
                String mail = "";
                int nbconnection = 0;
                int score = 0;
                int id_personne = 0;
                int id_partie = 0;
                while (result.next()) {
                    pseudo2 = result.getString(1);
                    mail = result.getString(2);
                    nbconnection = result.getInt(3);
                    score = result.getInt(4);
                    id_personne = result.getInt(5);
                    id_partie = result.getInt(6);
                }
                query = "SELECT nom,prenom,adresse,naissance,sexe,tel FROM personne WHERE id_personne = '" + id_personne + "'";
                result = requete.executeQuery(query);
                while (result.next()) {
                    String nom = result.getString(1);
                    String prenom = result.getString(2);
                    String adresse = result.getString(3);
                    String naissance = result.getString(4);
                    int sexe = result.getInt(5);
                    String tel = result.getString(6);
                    boolean a;
                    if (sexe == 1) {
                        a = false;
                    } else {
                        a = true;
                    }
                    Information i = new Information(nom, prenom, adresse, naissance, a, tel, pseudo, mail, score, id_partie, nbconnection);
                    return i;
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    public int recupNbCo(String pseudo) {
        if (demandeExistance(pseudo)) {
            String query = "SELECT nbconnexion FROM joueur WHERE pseudo = '" + pseudo + "'";
            try {
                int monNbCo = 0;
                Statement requete = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                ResultSet result1 = requete.executeQuery(query);
                while (result1.next()) {
                    monNbCo = result1.getInt(1);
                }
                return (monNbCo);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return 0;
    }

    public void connectionReussie(String pseudo) {
        if (demandeExistance(pseudo)) {
            int nbConnection = recupNbCo(pseudo);
            String query = "UPDATE joueur SET nbconnexion = " + (nbConnection + 1) + " WHERE pseudo = '" + pseudo + "'";
            try {
                Statement requete = con.createStatement();
                requete.executeUpdate(query);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public void nvSuivant(String pseudo,int nv) {
        if (monNiveau(nv,pseudo)) {
            int monNv = getNv(pseudo);
            String query = "UPDATE joueur SET id_partie = " + (monNv + 1) + " WHERE pseudo = '" + pseudo + "'";
            try {
                Statement requete = con.createStatement();
                requete.executeUpdate(query);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public boolean monNiveau(int nv, String pseudo) {
        if (demandeExistance(pseudo)) {
            int monId_partie = getNv(pseudo);
            if (nv == monId_partie) {
                return true;
            }
        }
        return false;
    }

    public int[] recupererTemp(int nv) {
        int[] ti = new int[3];
        String query = "SELECT tps1,tps2,tps3 FROM partie WHERE id_partie = '" + nv + "'";
        try {
            Statement requete = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet result1 = requete.executeQuery(query);
            while (result1.next()) {
                ti[0] = result1.getInt(1);
                ti[1] = result1.getInt(2);
                ti[2] = result1.getInt(3);
            }
            return ti;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return ti;
    }
    
        
}