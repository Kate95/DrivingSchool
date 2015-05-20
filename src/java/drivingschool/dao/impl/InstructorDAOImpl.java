/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drivingschool.dao.impl;

import drivingschool.dao.InstructorDAO;
import java.util.ArrayList;
import java.util.List;
import drivingschool.logic.Instructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import drivingschool.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Kate
 */
public class InstructorDAOImpl implements InstructorDAO {
    static Logger logger = Logger.getLogger(InstructorDAOImpl.class);

    @Override
    public void create(Instructor instructor) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(instructor);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't create new instructor. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Instructor instructor){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(instructor);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't update instructor info. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Instructor read(Integer id){
        Session session = null;
        Instructor instructor = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            instructor = (Instructor) session.get(Instructor.class, id);
        } catch (HibernateException e) {
            logger.error("Can't read instructor info from database. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return instructor;
    }

    @Override
    public List<Instructor> getAll() {
        Session session = null;
        List<Instructor> instructors = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            instructors = session.createCriteria(Instructor.class).list();
        } catch (HibernateException e) {
            logger.error("Can't get all instructors info. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return instructors;
    }

    @Override
    public void delete(Integer id){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Instructor instructor = (Instructor) session.get(Instructor.class, id);
            session.delete(instructor);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't delete instructor info. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
