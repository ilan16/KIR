/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.JFrame;


/**
 *
 * @author ilanmalka
 */
public class Fenetre extends JFrame {
    
    Design leDesign = new Design();
    
    public Fenetre(String text) throws SQLException, Exception{
        
        
        this.setTitle(text);
        this.setSize(1200,800);       
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //this.setExtendedState(this.MAXIMIZED_BOTH); 
      
        this.getContentPane().add(leDesign.initialisation());
       
        this.setVisible(true); 
        this.setResizable(true);
        
    }    

 
}
