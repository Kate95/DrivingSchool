/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drivingschool.dao.impl;

import drivingschool.dao.ExamTypeDAO;
import java.util.ArrayList;
import java.util.List;
import drivingschool.logic.ExamType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import drivingschool.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Kate
 */
public class ExamTypeDAOImpl implements ExamTypeDAO {
    static Logger logger = Logger.getLogger(ExamTypeDAOImpl.class);

    @Override
    public void create(ExamType examType){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(examType);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't create new exam type. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(ExamType examType){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(examType);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't update exam types info. Exception: ", e); 
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public ExamType read(String id){
        Session session = null;
        ExamType examType = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            examType = (ExamType) session.get(ExamType.class, id);
        } catch (HibernateException e) {
            logger.error("Can't read exam type info from database. Exception: ", e);  
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return examType;
    }

    @Override
    public List<ExamType> getAll(){
        Session session = null;
        List<ExamType> examTypes = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            examTypes = session.createCriteria(ExamType.class).list();
        } catch (HibernateException e) {
            logger.error("Can't get all exam type info. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return examTypes;
    }

    @Override
    public void delete(String id){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            ExamType examType = (ExamType) session.get(ExamType.class, id);
            session.delete(examType);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't delete exam type info. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
