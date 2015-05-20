/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drivingschool.dao.impl;

import drivingschool.dao.ExamDAO;
import java.util.ArrayList;
import java.util.List;
import drivingschool.logic.Exam;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import drivingschool.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Kate
 */
public class ExamDAOImpl implements ExamDAO {
    static Logger logger = Logger.getLogger(ExamDAOImpl.class);
    
    @Override
    public void create(Exam exam) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(exam);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't create new exam. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Exam exam){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(exam);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't update exam info. Exception: ", e); 
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Exam read(Integer studentID, Integer examNumber){
        Session session = null;
        Exam exam = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.getNamedQuery("Exam.readByExamNumberAndStudentID");
            query.setParameter("examNumber", examNumber);
            query.setParameter("studentID", studentID);
            exam =(Exam) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Can't read exam info from database. Exception: ", e);  
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return exam;
    }

    @Override
    public List<Exam> getAll() {
        Session session = null;
        List<Exam> exams = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            exams = session.createCriteria(Exam.class).list();
        } catch (HibernateException e) {
            logger.error("Can't get all exams info. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return exams;
    }

    @Override
    public void delete(Integer studentID, Integer examNumber){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();            
            Exam exam =read(studentID,examNumber);            
            session.delete(exam);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't delete exam info. Exception: ", e);  
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}