/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OpFichier;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import org.codehaus.commons.compiler.CompileException;

/**
 *
 * @author kevin
 */
public class OpJanino {

    private String code = "";
    private org.codehaus.commons.compiler.IScriptEvaluator se;

    public OpJanino() {
        se = (new org.codehaus.janino.ScriptEvaluator());
        code += "String janino=\"\";";
    }

    public String ecrireCode(String a) {
        code += a;
        code += "return janino;";
        return code;
    }

    public boolean ecrireResultat(String a) throws CompileException, FileNotFoundException, InvocationTargetException {
        se.setReturnType(String.class);
        String monCode = ecrireCode(a);
        monCode = monCode.replace("System.out.println(\"", "janino+=\"");
        monCode = monCode.replace("\");", " passealaligne \";");
        monCode = monCode.replace("System.out.println(", "janino+=");
        monCode = monCode.replace(");", "+\" passealaligne \";");
        System.out.println(monCode);
        try {
            se.cook(monCode);
            PrintWriter fileout = new PrintWriter("Monresultat.txt");
            Object res = (se.evaluate(new Object[0]));
            String b = res.toString().replace(" ", "");
            
            System.out.println(res);
            System.out.println(b);
            fileout.println(b);
            fileout.flush();
            fileout.close();
            return true;
        } catch (Exception e1) {
            System.out.println("erreur");
            return false;
        }
    }

}
