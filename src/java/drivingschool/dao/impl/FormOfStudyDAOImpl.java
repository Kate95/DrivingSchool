/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.dao.impl;

import drivingschool.dao.FormOfStudyDAO;
import java.util.ArrayList;
import java.util.List;
import drivingschool.logic.FormOfStudy;
import org.hibernate.Session;
import org.hibernate.Transaction;
import drivingschool.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Kate
 */
public class FormOfStudyDAOImpl implements FormOfStudyDAO {
    static Logger logger = Logger.getLogger(FormOfStudyDAOImpl.class);

    @Override
    public void create(FormOfStudy form){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(form);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't create new form of study. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(FormOfStudy form){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(form);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't update form of study info. Exception: ", e); 
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public FormOfStudy read(String id){
        Session session = null;
        FormOfStudy form = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            form = (FormOfStudy) session.get(FormOfStudy.class, id);
        } catch (HibernateException e) {
            logger.error("Can't read form of study info from database. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return form;
    }

    @Override
    public List<FormOfStudy> getAll(){
        Session session = null;
        List<FormOfStudy> forms = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            forms = session.createCriteria(FormOfStudy.class).list();
        } catch (HibernateException e) {
            logger.error("Can't get all forms of study info. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return forms;
    }

    @Override
    public void delete(String id){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            FormOfStudy form = (FormOfStudy) session.get(FormOfStudy.class, id);
            session.delete(form);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't delete form of study info. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
