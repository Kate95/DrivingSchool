/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.dao.impl;

import drivingschool.dao.StudyGroupDAO;
import java.util.ArrayList;
import java.util.List;
import drivingschool.logic.StudyGroup;
import org.hibernate.Session;
import org.hibernate.Transaction;
import drivingschool.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Kate
 */
public class StudyGroupDAOImpl implements StudyGroupDAO {
    static Logger logger = Logger.getLogger(StudyGroupDAOImpl.class);

    @Override
    public void create(StudyGroup group){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(group);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't create new study group. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(StudyGroup group){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(group);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't update study group info. Exception: ", e); 
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public StudyGroup read(Integer id){
        Session session = null;
        StudyGroup group = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            group = (StudyGroup) session.get(StudyGroup.class, id);
        } catch (HibernateException e) {
            logger.error("Can't read study group info from database. Exception: ", e); 
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return group;
    }

    @Override
    public List<StudyGroup> getAll(){
        Session session = null;
        List<StudyGroup> groups = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            groups = session.createCriteria(StudyGroup.class).list();
        } catch (HibernateException e) {
            logger.error("Can't get all study groups info. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return groups;
    }

    @Override
    public void delete(Integer id){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            StudyGroup group = (StudyGroup) session.get(StudyGroup.class, id);
            session.delete(group);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't delete study group info. Exception: ", e); 
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
