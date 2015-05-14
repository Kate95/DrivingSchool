/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import dao.ExamDAO;
import java.util.ArrayList;
import java.util.List;
import logic.Exam;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Kate
 */
public class ExamDAOImpl implements ExamDAO {

    public void create(Exam exam) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(exam);
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

    public void update(Exam exam){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(exam);
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

    public Exam read(Integer studentID, Integer examNumber){
        Session session = null;
        Exam exam = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.getNamedQuery("Exam.readByExamNumberAndStudentID");
            query.setParameter("examNumber", examNumber);
            query.setParameter("studentID", studentID);
            exam =(Exam) query.uniqueResult();
        } catch (Exception e) {
            System.out.println("Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return exam;
    }

    public List<Exam> getAll() {
        Session session = null;
        List<Exam> exams = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            exams = session.createCriteria(Exam.class).list();
        } catch (Exception e) {
            System.out.println("Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return exams;
    }

    public void delete(Integer studentID, Integer examNumber){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();            
            Exam exam =read(studentID,examNumber);            
            session.delete(exam);
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