/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Joueur;

/**
 *
 * @author ilanmalka
 */
public final class SingletonJoueur {

    private String pseudo;
    private String password;
    private static volatile SingletonJoueur instance = null;

    private SingletonJoueur() {
        super();
    }

    public final static SingletonJoueur getInstance() {
        if (SingletonJoueur.instance == null) {
            synchronized (SingletonJoueur.class) {
                if (SingletonJoueur.instance == null) {
                    SingletonJoueur.instance = new SingletonJoueur();
                }
            }
        }
        return SingletonJoueur.instance;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
