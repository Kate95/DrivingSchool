/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import dao.ExamTypeDAO;
import java.util.ArrayList;
import java.util.List;
import logic.ExamType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Kate
 */
public class ExamTypeDAOImpl implements ExamTypeDAO {

    public void create(ExamType examType){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(examType);
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

    public void update(ExamType examType){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(examType);
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

    public ExamType read(String id){
        Session session = null;
        ExamType examType = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            examType = (ExamType) session.get(ExamType.class, id);
        } catch (Exception e) {
            System.out.println("Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return examType;
    }

    public List<ExamType> getAll(){
        Session session = null;
        List<ExamType> examTypes = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            examTypes = session.createCriteria(ExamType.class).list();
        } catch (Exception e) {
            System.out.println("Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return examTypes;
    }

    public void delete(String id){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            ExamType examType = (ExamType) session.get(ExamType.class, id);
            session.delete(examType);
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
