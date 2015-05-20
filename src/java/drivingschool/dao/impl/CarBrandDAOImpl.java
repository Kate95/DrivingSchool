/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drivingschool.dao.impl;

import drivingschool.dao.CarBrandDAO;
import java.util.ArrayList;
import java.util.List;
import drivingschool.logic.CarBrand;
import org.hibernate.Session;
import org.hibernate.Transaction;
import drivingschool.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Kate
 */
public class CarBrandDAOImpl implements CarBrandDAO {
    static Logger logger = Logger.getLogger(CarBrandDAOImpl.class);

    @Override
    public void create(CarBrand carBrand){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(carBrand);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't create new car brand. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(CarBrand carBrand){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(carBrand);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't update car brand info. Exception: ", e); 
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public CarBrand read(String id){
        Session session = null;
        CarBrand carBrand = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            carBrand = (CarBrand) session.get(CarBrand.class, id);
        } catch (HibernateException e) {
            logger.error("Can't read car brand info from database. Exception: ", e);  
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return carBrand;
    }

    @Override
    public List<CarBrand> getAll(){
        Session session = null;
        List<CarBrand> carBrands = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            carBrands = session.createCriteria(CarBrand.class).list();
        } catch (HibernateException e) {
            logger.error("Can't get all car brands info. Exception: ", e);   
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return carBrands;
    }

    @Override
    public void delete(String id){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            CarBrand carBrand = (CarBrand) session.get(CarBrand.class, id);
            session.delete(carBrand);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't delete car brand info. Exception: ", e);  
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
