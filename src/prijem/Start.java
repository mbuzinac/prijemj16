/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prijem;

import prijem.pomocno.HibernateUtil;
import prijem.view.FormaDobavljac;
import prijem.view.Izbornik;

/**
 *
 * @author Matija
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         new Izbornik().setVisible(true);
          HibernateUtil.getSession();
        
        // TODO code application logic here
    }
    
}
