/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prijem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Matija
 */
@Entity
@Table
public class Artikl extends Entitet implements Serializable {
  
    @ManyToOne
    private Dobavljac dobavljac;
    @ManyToOne
    private Kategorija kategorija;
    private String naziv;
    private String ean;
    private String lot;
    private BigDecimal cijena;
    private String pakiranje;
    
     public Dobavljac getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(Dobavljac dobavljac) {
        this.dobavljac = dobavljac;
    }
    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }
    
     public String getNaziv() {
        return naziv;
    
} public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
 public String getEan() {
        return ean;
    
} public void setEan(String ean) {
        this.ean = ean;
    }
 public String getLot() {
        return lot;
    
} public void setLot(String lot) {
        this.lot = lot;
    }
    
 public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }
    public String getPakiranje() {
        return pakiranje;
    
} public void setPakiranje(String pakiranje) {
        this.pakiranje = pakiranje;
    }

    @Override
    public String toString() {
        return getNaziv() ;
        
    }}

    //public Object getSifra() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }

//}
