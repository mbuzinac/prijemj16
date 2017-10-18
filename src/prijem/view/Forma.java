/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prijem.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import prijem.controller.Obrada;
import prijem.model.Entitet;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public abstract class Forma<T extends Entitet> extends JFrame  {
    
    protected abstract void ucitaj();
    
   
     protected Obrada<T> obrada;
    protected T entitet;
   

    
    protected void obrisi(){
        obrada.delete(entitet);
        ucitaj();
    }
    
    protected  void spremi(){
        entitet=obrada.save(entitet);
        ucitaj();
    }
 protected void nakonInitComponents(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
}
