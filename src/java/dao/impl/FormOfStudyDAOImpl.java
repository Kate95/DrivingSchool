/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.FormOfStudyDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.FormOfStudy;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Kate
 */
public class FormOfStudyDAOImpl implements FormOfStudyDAO {

    public void create(FormOfStudy form){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(form);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(FormOfStudy form){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(form);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public FormOfStudy read(String id){
        Session session = null;
        FormOfStudy form = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            form = (FormOfStudy) session.get(FormOfStudy.class, id);
        } catch (Exception e) {
            System.out.println("Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return form;
    }

    public List<FormOfStudy> getAll(){
        Session session = null;
        List<FormOfStudy> forms = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            forms = session.createCriteria(FormOfStudy.class).list();
        } catch (Exception e) {
            System.out.println("Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return forms;
    }

    public void delete(String id){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            FormOfStudy form = (FormOfStudy) session.get(FormOfStudy.class, id);
            session.delete(form);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
