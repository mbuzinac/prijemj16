/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prijem.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Matija
 */
@Entity
@Table
public class Vrsta extends Entitet implements Serializable {
     private String naziv;
     
     public String getNaziv() {
        return naziv;
    
} public void setNaziv(String naziv) {
        this.naziv = naziv;
    }


@Override
    public String toString() {
        return getNaziv() ;
      }}  
    