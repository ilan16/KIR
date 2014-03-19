package Joueur;

import BDD.DOA;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionnaireJoueur {

	private boolean[] validerNv;
        private DOA doa;
        private Connection con;
        
        public GestionnaireJoueur(String url, String user, String pwd) throws SQLException {
        this.doa = new DOA(url, user, pwd);
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
       
//        try {
//            Statement requete = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//            ResultSet result = requete.executeQuery(query);
//            while (result.next()) {
//                String pseudo = result.getString(1);
//                if (pseudo != "") {
//                    return true;
//                }
//            }
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
       return false;
    }
		
               
	

	/**
	 * 
	 * @param j
	 */
	private boolean verifierExistance(Joueur j) {
		// TODO - implement GestionnaireJoueur.verifierExistance
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param j
	 */
	public boolean compareToNv(String pseudo) {
		// TODO - implement GestionnaireJoueur.compareToNv
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param j
	 */
	public boolean compareToScore(String pseudo) {
		// TODO - implement GestionnaireJoueur.compareToScore
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nv
	 */
	public int getScore(int nv) {
		// TODO - implement GestionnaireJoueur.getScore
		throw new UnsupportedOperationException();
	}

	public int scoreFinal() {
		// TODO - implement GestionnaireJoueur.scoreFinal
		throw new UnsupportedOperationException();
	}

	public int scoreNv() {
		// TODO - implement GestionnaireJoueur.scoreNv
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nv
	 */
	public void scoreNv(int nv) {
		// TODO - implement GestionnaireJoueur.scoreNv
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nv
	 */
	public boolean verifierNv(int nv) {
		// TODO - implement GestionnaireJoueur.verifierNv
		throw new UnsupportedOperationException();
	}

}