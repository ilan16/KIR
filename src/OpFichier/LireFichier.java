//Ilan MALKA et Reouven KIDOUCHIM

package OpFichier;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LireFichier {

    private File input;
    private ArrayList text;
    private int nbLigne = 0;
    
    public void afficherText(){
        for(Object o : this.text){
            System.out.println(o.toString());
        }
    }

    public LireFichier(String input) {
        this.input = new File(input);
        this.text = new ArrayList();
    }
    
    public int getNbLigne(){
        return this.nbLigne;
    }
    
    public void setText(ArrayList text) {
        this.text = text;
    }

    public ArrayList getText() {
        ArrayList clone = new ArrayList();
        for (Object o : this.text) {
            clone.add(o);
        }
        return clone;
    }

    public String getInput() {
        return input.getName();
    }

    public void setInput(String input) {
        this.input = new File(input);
    }

    public boolean verifierFichier() {
        boolean ok = true;

        if (!input.exists() || !input.isDirectory() || !input.canRead()) {
            ok = false;
        }
        return ok;
    }

    public ArrayList lireText() throws IOException {
//        if (!verifierFichier()) {
//            return null;
//        }

        FileReader fr = new FileReader(input);
        BufferedReader br = new BufferedReader(fr);

        while (br.ready()) {
            text.add(br.readLine());
            this.nbLigne++;
        }

        return text;
    }

    public boolean close() throws FileNotFoundException {
        FileReader fr = new FileReader(input);
        boolean rep = false;

        if (fr != null) {
            try {
                fr.close();
                rep = true;
            } catch (IOException io) {
                rep = false;
            }
        }
        return rep;
    }
}
