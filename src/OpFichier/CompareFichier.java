package OpFichier;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CompareFichier {

    private LireFichier corr;
    private String nomFichier;
    private LireFichier mesReps;

    public CompareFichier(String nomFichier) {
        this.nomFichier = nomFichier;
        this.corr = new LireFichier(this.nomFichier);
        this.mesReps = new LireFichier("Monresultat.txt");
    }

    public boolean comparerFichier() throws IOException {
        this.corr.lireText();
        ArrayList corrList = this.corr.getText();
        this.mesReps.lireText();
        ArrayList repList = this.mesReps.getText();

        if (corrList.size() != repList.size()) {
            System.out.println("merde");
            return false;
        }
String a ="";
String b=repList.get(1).toString();
 b = b.replace(" ", "");
        for (int i = 0; i < corrList.size(); i++) {
             a+=corrList.get(i).toString();
           
            a = a.replace(" ", "");
           

        }
        if (!a.equals(b)) {
            return false;
        }
        System.out.println("rentre à la maison");
        return true;
    }
}
