package BDD;

import java.util.Arrays;
import java.util.Scanner;

//Ilan MALKA et Reouven KIDOUCHIM 


public class Textui {

    static Scanner in = new Scanner(System.in);

    public String readString(String mesg) {

        System.out.println(mesg);
        return in.nextLine();
    }

    public float readFloat(String msg) {
        System.out.println(msg);
        return in.nextFloat();
    }

    public double readDouble(String msg) {
        System.out.println(msg);
        return in.nextDouble();
    }

    public int readInt(String msg) {
        System.out.println(msg);
        return in.nextInt();
    }
    

    public void afficherMsg(Object msg) {
        System.out.println(msg);
    }
    
    
}