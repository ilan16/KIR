/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import Joueur.SingletonJoueur;

/**
 *
 * @author ilanmalka
 */
public final class SingletonJeu {
    private int niveau;
    private int typeNiveau;
    private static volatile SingletonJeu instance = null;

    private SingletonJeu() {
        super();
    }

    public final static SingletonJeu getInstance() {
        if (SingletonJeu.instance == null) {
            synchronized (SingletonJeu.class) {
                if (SingletonJeu.instance == null) {
                    SingletonJeu.instance = new SingletonJeu();
                }
            }
        }
        return SingletonJeu.instance;
    }

    public int getNiveau() {
        return this.niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getTypeNiveau() {
        return this.typeNiveau;
    }
    
    public void setTypeNiveau(int typeNiveau) {
        this.typeNiveau = typeNiveau;
    }
}
