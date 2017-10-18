/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prijem;

import prijem.controller.Obrada;
import prijem.model.Artikl;
import prijem.model.Dobavljac;
import prijem.model.Kategorija;
import prijem.model.Vrsta;

/**
 *
 * @author Matija
 */
public class PocetniLoad {


    public static void main(String[] args){
        
        Obrada<Dobavljac> od = new Obrada<>();
        
        Dobavljac d1 = new Dobavljac();
        d1.setNaziv("Coca Cola");
        od.save(d1);
        
        Dobavljac d2 = new Dobavljac();
        d2.setNaziv("Badel 1862");
        od.save(d2);
        
        Dobavljac d3 = new Dobavljac();
        d3.setNaziv("Jamnica");
        od.save(d3);
        
        Dobavljac d4 = new Dobavljac();
        d4.setNaziv("Atlantic");
        od.save(d4);
        
        Dobavljac d5 = new Dobavljac();
        d5.setNaziv("TDR");
        od.save(d5);
        
        Dobavljac d6 = new Dobavljac();
        d6.setNaziv("Vindija");
        od.save(d6);
        
        Dobavljac d7 = new Dobavljac();
        d7.setNaziv("Mesna Industrija Ravlić");
        od.save(d7);
        
        Dobavljac d8 = new Dobavljac();
        d8.setNaziv("Zvijezda");
        od.save(d8);
        
        Dobavljac d9 = new Dobavljac();
        d9.setNaziv("Dukat");
        od.save(d9);
        
        Dobavljac d10 = new Dobavljac();
        d10.setNaziv("PP Orahovica");
        od.save(d10);
        
        Dobavljac d11 = new Dobavljac();
        d11.setNaziv("Pneumatik");
        d11.setAdresa("Bosutska 21 Vinkovci");
        od.save(d11);
        
        
        
        Obrada<Kategorija> ka = new Obrada<>();
        
        Kategorija k1 = new Kategorija();
        k1.setNaziv("Suhi asortiman");
        ka.save(k1);
        
        Kategorija k2 = new Kategorija();
        k2.setNaziv("Piće");
        ka.save(k2);
        
        Kategorija k3 = new Kategorija();
        k3.setNaziv("Mlijećni i smrznuto");
        ka.save(k3);
        
        Kategorija k4 = new Kategorija();
        k4.setNaziv("Meso i riba");
        ka.save(k4);
        
        Kategorija k5 = new Kategorija();
        k5.setNaziv("Salame");
        ka.save(k5);
        
        Kategorija k6 = new Kategorija();
        k6.setNaziv("Kemija i kozmetika");
        ka.save(k6);
        
        Kategorija k7 = new Kategorija();
        k7.setNaziv("Pekara");
        ka.save(k7);
        
        Kategorija k8 = new Kategorija();
        k8.setNaziv("Delikatesa");
        ka.save(k8);
        
        Kategorija k9 = new Kategorija();
        k9.setNaziv("Netrgovačka roba");
        ka.save(k9);
        
        Kategorija k10 = new Kategorija();
        k10.setNaziv("Ostalo");
        ka.save(k10);
        
        
        
        Obrada<Artikl> ar = new Obrada<>();
        Artikl a1 = new Artikl();
        a1.setNaziv("Coca cola 2l");
        ar.save(a1);
        
        Artikl a2 = new Artikl();
        a2.setNaziv("Coca cola 1.5l");
        ar.save(a2);
       
        Artikl a3 = new Artikl();
        a3.setNaziv("Šaran živi");
        ar.save(a3);
        
        Artikl a4 = new Artikl();
        a4.setNaziv("Šaran pakirani");
        ar.save(a4);
        
        Artikl a5 = new Artikl();
        a5.setNaziv("Sv potrbušina bk");
        ar.save(a5);
        
        Artikl a6 = new Artikl();
        a6.setNaziv("Teleća lopatica");
        ar.save(a6);
        
        Artikl a7 = new Artikl();
        a7.setNaziv("Margo namaz 250g");
        ar.save(a7);
        
        Artikl a8 = new Artikl();
        a8.setNaziv("Vilkis 200g");
        ar.save(a8);
       
        Artikl a9 = new Artikl();
        a9.setNaziv("Coca cola 0.5l");
        ar.save(a9);
        
        Artikl a10 = new Artikl();
        a10.setNaziv("Osjecko pivo 0.5l P.A.");
        ar.save(a10);
        
        Artikl a11 = new Artikl();
        a11.setNaziv("Fanta 2l");
        ar.save(a11);
        
        Artikl a12 = new Artikl();
        a12.setNaziv("Zvijezda majoneza 80g");
        ar.save(a12);
        
        Artikl a13 = new Artikl();
        a13.setNaziv("Banjalucki cevapi 800g");
        ar.save(a13);
        
        Artikl a14 = new Artikl();
        a14.setNaziv("Cockta 2l");
        ar.save(a14);
        
        Artikl a15 = new Artikl();
        a15.setNaziv("Sv but");
        ar.save(a15);
        
        Artikl a16 = new Artikl();
        a16.setNaziv("Mesarski papir");
        ar.save(a16);
        
        Artikl a17 = new Artikl();
        a17.setNaziv("Amur živi");
        ar.save(a17);
        
        Artikl a18 = new Artikl();
        a18.setNaziv("Dukatos 200g");
        ar.save(a18);
        
        Artikl a19 = new Artikl();
        a19.setNaziv("EU Paleta");
        ar.save(a19);
        
        Artikl a20 = new Artikl();
        a20.setNaziv("Kutjevacka graševina 0,75l");
        ar.save(a20);
        
        Artikl a21 = new Artikl();
        a21.setNaziv("Kutjevacka graševina 1l");
        ar.save(a21);
        
        Artikl a22 = new Artikl();
        a22.setNaziv("Erdutski traminac 0,75l");
        ar.save(a22);
        
        Artikl a23 = new Artikl();
        a23.setNaziv("Erdutska graševina 0,75l");
        ar.save(a23);
        
        Artikl a24 = new Artikl();
        a24.setNaziv("Erdutska graševina 5l");
        ar.save(a24);
        
        Artikl a25 = new Artikl();
        a25.setNaziv("Sv koljenica");
        ar.save(a25);
        
        Artikl a26 = new Artikl();
        a26.setNaziv("Sava eskimo 175/65/13");
        ar.save(a26);
        
   
        Obrada<Vrsta> vr = new Obrada<>();
        
        Vrsta v1 = new Vrsta();
        v1.setNaziv("Standard");
        vr.save(v1);
        Vrsta v2 = new Vrsta();
        v2.setNaziv("Povrat");
        vr.save(v2);
    }}
     