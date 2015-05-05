/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import dao.InstructorDAO;
import java.util.ArrayList;
import java.util.List;
import logic.Instructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Kate
 */
public class InstructorDAOImpl implements InstructorDAO {

    public void create(Instructor instructor) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(instructor);
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

    public void update(Instructor instructor){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(instructor);
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

    public Instructor read(Integer id){
        Session session = null;
        Instructor instructor = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            instructor = (Instructor) session.get(Instructor.class, id);
        } catch (Exception e) {
            System.out.println("Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return instructor;
    }

    public List<Instructor> getAll() {
        Session session = null;
        List<Instructor> instructors = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            instructors = session.createCriteria(Instructor.class).list();
        } catch (Exception e) {
            System.out.println("Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return instructors;
    }

    public void delete(Integer id){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Instructor instructor = (Instructor) session.get(Instructor.class, id);
            session.delete(instructor);
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
