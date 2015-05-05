/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import dao.CarBrandDAO;
import dao.ExamTypeDAO;
import java.util.ArrayList;
import java.util.List;
import logic.CarBrand;
import logic.ExamType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Kate
 */
public class CarBrandDAOImpl implements CarBrandDAO {

    public void create(CarBrand carBrand){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(carBrand);
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

    public void update(CarBrand carBrand){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(carBrand);
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

    public CarBrand read(String id){
        Session session = null;
        CarBrand carBrand = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            carBrand = (CarBrand) session.get(CarBrand.class, id);
        } catch (Exception e) {
            System.out.println("Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return carBrand;
    }

    public List<CarBrand> getAll(){
        Session session = null;
        List<CarBrand> carBrands = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            carBrands = session.createCriteria(CarBrand.class).list();
        } catch (Exception e) {
            System.out.println("Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return carBrands;
    }

    public void delete(String id){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            CarBrand carBrand = (CarBrand) session.get(CarBrand.class, id);
            session.delete(carBrand);
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
