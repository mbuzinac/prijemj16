/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prijem.view;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.TextFilterator;
import ca.odell.glazedlists.swing.DefaultEventComboBoxModel;
import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.components.DatePicker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import prijem.controller.Obrada;
import prijem.model.Artikl;
import prijem.model.Dobavljac;
import prijem.model.Narudzba;
import prijem.model.Vrsta;
import prijem.pomocno.HibernateUtil;

/**
 *
 * @author Matija
 */
public class FormaNarudzba extends Forma<Narudzba> {
    private DatePicker datumIsporuke;
    private DatePicker datumNarudzbe;
    private List<Artikl> artikli;
    /**
     * Creates new form FormaNarudzba
     */
    public FormaNarudzba() {
       // System.out.println("wwwwww");
         initComponents();
         nakonInitComponents();
         obrada = new Obrada();
         definirajKalendar();
         ucitajDobavljace();
         ucitajVrste();
         ucitajArtikle();
         definirajDesniKlikNaArtiklima();
    
         ucitaj();
    }
    
    private void ucitajArtikle(){
        
        Dobavljac odabraniDobavljac = (Dobavljac)cmbDobavljaci.getSelectedItem();
        
        
       // System.out.println("ucitajArtikle");
         artikli =HibernateUtil.getSession().createQuery("from Artikl a where a.obrisan=false "
                 + " and a.dobavljac.sifra=:dobavljac").setLong("dobavljac", odabraniDobavljac.getSifra()).list();
      // System.out.println(artikli.size());
        EventList<Artikl> el = new BasicEventList<>();
         artikli.stream().forEach((p)->{
             System.out.println(p.getNaziv ());
                     el.add(p);
        });
        DefaultEventComboBoxModel<Artikl> model = new DefaultEventComboBoxModel<Artikl>(el);
        cmbArtikli.setModel(model);

        //AutoCompleteSupport autocomplete = AutoCompleteSupport.install(cmbArtikli, el, new StationTextFilterator());
        //autocomplete.setFilterMode(TextMatcherEditor.CONTAINS);
    }
     private void definirajDesniKlikNaArtiklima() {
        lstArtikli.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                   
                    if (SwingUtilities.isRightMouseButton(e)) {
                        
                        if(lstArtikli.getSelectedValue()==null){
                            return;
                        }
                        
                        JPopupMenu menu = new JPopupMenu();
                        JMenuItem item = new JMenuItem("Obriši");
                        item.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Artikl p = lstArtikli.getSelectedValue();
                                entitet.getArtikli().remove(p);
                                spremi();
                            }
                        });
                        menu.add(item);
                        menu.show(lstArtikli,25, lstArtikli.getCellBounds(
                                lstArtikli.getSelectedIndex() + 1,
                                lstArtikli.getSelectedIndex() + 1).y);
                    }
                }
            });
    }
     
      private void ucitajVrste() {
        DefaultComboBoxModel<Vrsta> m = new DefaultComboBoxModel<>();
        cmbVrste.setModel(m);
        List<Vrsta> naziv = HibernateUtil.getSession().
                createQuery("from Vrsta a where "
                        + "a.obrisan=false  ").list();
        for (Vrsta p : naziv ) {

            m.addElement(p);
            cmbVrste.setSelectedItem(p);
   
        }
   
        }

  

    
      class StationTextFilterator implements TextFilterator<Artikl> {
        @Override
        public void getFilterStrings(List<String> baseList, Artikl artikl) {
            baseList.add(artikl.getNaziv() + " " + artikl.getCijena());
        }
    }
         @Override
    protected void ucitaj() {
        DefaultListModel<Narudzba> m = new DefaultListModel<>();
        lstNarudzbe.setModel(m);
        List<Narudzba> l = HibernateUtil.getSession().createQuery("from Narudzba a where a.obrisan=false").list();
        l.forEach((s) -> {
            m.addElement(s);
        });
        
        System.out.println(entitet);
        if(entitet!=null){
             for(int i=0;i<lstNarudzbe.getModel().getSize();i++){
            //System.out.println(lstEntiteti.getModel());
            if(lstNarudzbe.getModel().getElementAt(i).getSifra().equals(entitet.getSifra())){
                lstNarudzbe.setSelectedIndex(i);
                break;
            }
        }
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbVrste = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbDobavljaci = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbArtikli = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstArtikli = new javax.swing.JList<>();
        btnDodajArtikl = new javax.swing.JButton();
        pndDatumNarudzbe = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstNarudzbe = new javax.swing.JList<>();
        btnPromjeni = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        pndDatumIsporuke = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Vrsta");

        cmbVrste.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbVrsteItemStateChanged(evt);
            }
        });
        cmbVrste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVrsteActionPerformed(evt);
            }
        });

        jLabel2.setText("Dobavljac");

        cmbDobavljaci.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDobavljaciItemStateChanged(evt);
            }
        });
        cmbDobavljaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDobavljaciActionPerformed(evt);
            }
        });

        jLabel3.setText("Artikl");

        cmbArtikli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbArtikliActionPerformed(evt);
            }
        });

        jLabel4.setText("Kolicina");

        jLabel5.setText("Datum Isporuke");

        jLabel6.setText("Datum Narudžbe");

        lstArtikli.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstArtikli.setInheritsPopupMenu(true);
        jScrollPane2.setViewportView(lstArtikli);

        btnDodajArtikl.setText("Naruci");
        btnDodajArtikl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajArtiklActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pndDatumNarudzbeLayout = new javax.swing.GroupLayout(pndDatumNarudzbe);
        pndDatumNarudzbe.setLayout(pndDatumNarudzbeLayout);
        pndDatumNarudzbeLayout.setHorizontalGroup(
            pndDatumNarudzbeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );
        pndDatumNarudzbeLayout.setVerticalGroup(
            pndDatumNarudzbeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        lstNarudzbe.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstNarudzbeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstNarudzbe);

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pndDatumIsporukeLayout = new javax.swing.GroupLayout(pndDatumIsporuke);
        pndDatumIsporuke.setLayout(pndDatumIsporukeLayout);
        pndDatumIsporukeLayout.setHorizontalGroup(
            pndDatumIsporukeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );
        pndDatumIsporukeLayout.setVerticalGroup(
            pndDatumIsporukeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pndDatumNarudzbe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pndDatumIsporuke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbDobavljaci, 0, 140, Short.MAX_VALUE)
                                    .addComponent(cmbVrste, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnDodaj)
                            .addGap(18, 18, 18)
                            .addComponent(btnPromjeni)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnObrisi))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDodajArtikl))
                                .addComponent(cmbArtikli, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbArtikli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodajArtikl)
                            .addComponent(jLabel4)
                            .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(pndDatumNarudzbe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 14, Short.MAX_VALUE))
                            .addComponent(pndDatumIsporuke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbVrste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbDobavljaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPromjeni)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi))
                .addGap(159, 159, 159))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbVrsteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVrsteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVrsteActionPerformed

    private void cmbDobavljaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDobavljaciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDobavljaciActionPerformed

    private void cmbArtikliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbArtikliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbArtikliActionPerformed

    private void btnDodajArtiklActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajArtiklActionPerformed
        
 if(cmbArtikli.getSelectedItem()==null){
            return;
        }
        Artikl p = (Artikl)cmbArtikli.getSelectedItem();
        entitet.getArtikli().add(p);
        spremi();
      
        
    }//GEN-LAST:event_btnDodajArtiklActionPerformed

    private void lstNarudzbeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstNarudzbeValueChanged

        if (evt.getValueIsAdjusting()) {
            return;
        }

        if(lstNarudzbe.getSelectedValue()==null){
            return;
        }

        try {
            this.entitet = lstNarudzbe.getSelectedValue();
            cmbVrste.setSelectedItem(entitet.getVrsta());
            cmbDobavljaci.setSelectedItem(entitet.getDobavljac());
           
            
            entitet.setKolicina(txtKolicina.getText());
//            LocalDate date = entitet.getDatumIsporuke().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  //          calendarPanel.setSelectedDate(date);
    //        datePicker.setDate(date);

            DefaultListModel<Artikl> m = new DefaultListModel<>();
            lstArtikli.setModel(m);
            entitet.getArtikli().forEach((s) -> {
                m.addElement(s);
            });
            //ucitajArtikle();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lstNarudzbeValueChanged

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if (lstArtikli.getSelectedValue() == null) {
            JOptionPane.showConfirmDialog(rootPane, "Prvo odaberite stavku");
        }
        spremi();
    }//GEN-LAST:event_btnPromjeniActionPerformed
@Override
    protected void spremi() {

        entitet.setVrsta((Vrsta) cmbVrste.getSelectedItem());
        entitet.setDobavljac((Dobavljac)cmbDobavljaci.getSelectedItem());
        entitet.setKolicina(txtKolicina.getText());
        
        Date d = Date.from(datumIsporuke.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        entitet.setDatumIsporuke(d);
        super.spremi();
        
        Date d1 = Date.from(datumNarudzbe.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        entitet.setDatumNarudzbe(d1);
        super.spremi();
       
        
    }
    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        entitet = new Narudzba();
        entitet.setArtikli(new ArrayList<>());
        spremi();
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (lstArtikli.getSelectedValue() == null) {
            JOptionPane.showConfirmDialog(rootPane, "Prvo odaberite stavku");
        }
        obrisi();
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void cmbDobavljaciItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDobavljaciItemStateChanged
        ucitajArtikle();
    }//GEN-LAST:event_cmbDobavljaciItemStateChanged

    private void cmbVrsteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbVrsteItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVrsteItemStateChanged

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnDodajArtikl;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JComboBox<Artikl> cmbArtikli;
    private javax.swing.JComboBox<Dobavljac> cmbDobavljaci;
    private javax.swing.JComboBox<Vrsta> cmbVrste;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Artikl> lstArtikli;
    private javax.swing.JList<Narudzba> lstNarudzbe;
    private javax.swing.JPanel pndDatumIsporuke;
    private javax.swing.JPanel pndDatumNarudzbe;
    private javax.swing.JTextField txtKolicina;
    // End of variables declaration//GEN-END:variables
private void ucitajDobavljace() {
        DefaultComboBoxModel<Dobavljac> m = new DefaultComboBoxModel<>();
        cmbDobavljaci.setModel(m);
        List<Dobavljac> artikl = HibernateUtil.getSession().
                createQuery("from Dobavljac a where "
                        + "a.obrisan=false  ").list();
        

         for (Dobavljac p : artikl ) {

            m.addElement(p);
           
   
           
        }
          cmbDobavljaci.setSelectedIndex(0);
   
        }
 private void definirajKalendar() {

        datumNarudzbe = new DatePicker();
        datumNarudzbe.setDate(LocalDate.now());
        datumNarudzbe.setLocale(new Locale("hr"));
        pndDatumNarudzbe.add(datumNarudzbe);
        datumNarudzbe.setSize(pndDatumNarudzbe.getSize());
        
        datumIsporuke = new DatePicker();
        datumIsporuke.setLocale(new Locale("hr"));
        pndDatumIsporuke.add(datumIsporuke);
        datumIsporuke.setSize(pndDatumIsporuke.getSize());
        
}
}