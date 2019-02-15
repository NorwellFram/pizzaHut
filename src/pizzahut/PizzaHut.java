/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzahut;

import java.awt.Dimension;

/**
 *
 * @author p1700594
 */
public class PizzaHut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fenetre f=new Fenetre();
        f.setPreferredSize(new Dimension(500, 500));
        f.setVisible(true);
    }
    
}
