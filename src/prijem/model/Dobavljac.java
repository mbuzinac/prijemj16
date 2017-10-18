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
public class Dobavljac extends Entitet implements Serializable {
     private String naziv; 
     private String adresa; 
     private String telefon; 
     private String email; 
    
    public String getNaziv() {
        return naziv;
    
} public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
public String getAdresa() {
        return adresa;
    
} public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
public String getTelefon() {
        return telefon;
    
} public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
public String getEmail() {
        return email;
    
} public void setEmail(String email) {
        this.email = email;
    }

@Override
    public String toString() {
        return naziv;
        
        
    }
}
