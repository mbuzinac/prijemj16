/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prijem.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Matija
 */
@Entity
@Table
public class Narudzba extends Entitet implements Serializable {
         @ManyToOne
         private Vrsta vrsta;
         @ManyToOne
         private Dobavljac dobavljac;
         @ManyToMany
         private List<Artikl> artikli = new ArrayList<>();
         private String kolicina;
         private Date datumNarudzbe;
         private Date datumIsporuke;
         
          public Vrsta getVrsta() {
        return vrsta;
    
          } 
          public void setVrsta(Vrsta vrsta) {
        this.vrsta = vrsta;
    }
          
           public Dobavljac getDobavljac() {
        return dobavljac;
    
          } 
          public void setDobavljac(Dobavljac dobavljac) {
        this.dobavljac = dobavljac;
    }
          
           public List<Artikl> getArtikli() {
        return artikli;
    
          } 
          public void setArtikli(List<Artikl> artikli) {
        this.artikli = artikli;
    }
          
           public String getKolicina() {
        return kolicina;
    
          } 
          public void setKolicina(String kolicina) {
        this.kolicina = kolicina;
    }
          
           public Date getDatumNarudzbe() {
        return datumNarudzbe;
    }

    public void setDatumNarudzbe(Date datumNarudzbe) {
        this.datumNarudzbe = datumNarudzbe;
    }
         
     public Date getDatumIsporuke() {
        return datumIsporuke;
    }

    public void setDatumIsporuke(Date datumIsporuke) {
        this.datumIsporuke = datumIsporuke;
    }

    public Iterable<Artikl> getArtikl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
   
      @Override
    public String toString() {
        return getDobavljac() + " " + getDatumIsporuke();
    }  
     }

