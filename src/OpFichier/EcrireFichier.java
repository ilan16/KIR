package OpFichier;

import BDD.Textui;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EcrireFichier {

    private File output;
    private PrintWriter fileout;
    private Textui u;

    public EcrireFichier(String output) throws FileNotFoundException {
        this.output = new File(output);
        this.fileout = new PrintWriter(this.output);
        this.u = new Textui();
    }

    public PrintWriter getFileout() {
        return this.fileout;
    }

    public void setFileout(PrintWriter fileout) {
        this.fileout = fileout;
    }

    public String getInput() {
        return this.output.getName();
    }

    public void setInput(String input) {
        this.output = new File(input);
    }

    public boolean verifierFichier() {
        boolean ok = true;

        if (!output.exists() || !output.isDirectory() || !output.canRead()) {
            ok = false;
        }
        return ok;
    }

    public boolean close() throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        boolean rep = false;

        if (bw != null) {
            try {
                bw.flush();
                bw.close();
                bw = null;
                rep = true;
            } catch (IOException ex) {
                bw = null;
                rep = false;

            }
        }

        return rep;
    }

    public void ecrireLigneDansFichier(String texte) throws IOException {
//        if (!verifierFichier()) {
//            throw new IOException();
//        }
        if (texte.equals("close")) {
            fileout.close();
        }
        fileout.println(texte);
        
    }
    
    public void ecrireDansFichier() throws FileNotFoundException, IOException{
        //EcrireFichier e = new EcrireFichier("brouillon.txt");
        for(;;){
            String text = u.readString("");
            this.ecrireLigneDansFichier(text);
            if(text.equals("close")) break ;
        }
    }
}