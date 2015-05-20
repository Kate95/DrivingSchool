/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.dao.impl;

import drivingschool.dao.StudentDAO;
import java.util.ArrayList;
import java.util.List;
import drivingschool.logic.Student;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import drivingschool.util.HibernateUtil;

/**
 *
 * @author Kate
 */
public class StudentDAOImpl implements StudentDAO {
    static Logger logger = Logger.getLogger(StudentDAOImpl.class);
    
    @Override
   public void create(Student student) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(student);
            tx.commit();               
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't create new student. Exception: ", e);            
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Student student){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(student);
            tx.commit();                  
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }      
            logger.error("Can't update student info. Exception: ", e);            
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Student read(Integer id){
        Session session = null;
        Student student = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            student = (Student) session.get(Student.class, id);
        } catch (HibernateException e) {            
            logger.error("Can't read student info from database. Exception: ", e);    
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        Session session = null;
        List<Student> students = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            students = session.createCriteria(Student.class).list();            
        } catch (HibernateException e) {   
            logger.error("Can't get all students info. Exception: ", e);           
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return students;
    }

    @Override
    public void delete(Integer id){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Student student = (Student) session.get(Student.class, id);
            session.delete(student);            
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }          
            logger.error("Can't delete student info. Exception: ", e);           
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
