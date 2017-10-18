/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prijem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import prijem.model.Dobavljac;
import prijem.model.Entitet;
import prijem.pomocno.HibernateUtil;

/**
 *
 * @author Matija
 */
public class Obrada<T extends Entitet> {

    private final Session session;

    public Obrada() {
        session = HibernateUtil.getSession();
    }

    //Create ili Update ili Delete jer imamo atribut delete
    public T save(T entitet) {
        Date d = new Date();
        if (entitet.getSifra() == null) {
            entitet.setDatumKreiranja(d);
        }
        entitet.setDatumPromjene(d);
        session.beginTransaction();
       //System.out.println(entitet.hashCode());
        session.saveOrUpdate(entitet);
        session.getTransaction().commit();
        return entitet;
    }

    //Read
    @Deprecated
    public List<T> createQuery(String hql) {
        Query q = session.createQuery(hql);
        return q.list();
    }

    //Delete
    public void delete(T entitet) {
        entitet.setObrisan(true);
        save(entitet);
    }

    public List<T> save(List<T> lista) {
        Date d = new Date();
        session.beginTransaction();
        lista.stream().forEach((entitet) -> {
            if (entitet.getSifra() == null) {
                entitet.setDatumKreiranja(d);
            }
            entitet.setDatumPromjene(d);
            session.saveOrUpdate(entitet);
        });
        session.getTransaction().commit();
        return lista;
    }

}
