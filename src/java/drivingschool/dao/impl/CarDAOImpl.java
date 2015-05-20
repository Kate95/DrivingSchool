/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drivingschool.dao.impl;

import drivingschool.dao.CarDAO;
import java.util.ArrayList;
import java.util.List;
import drivingschool.logic.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;
import drivingschool.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Kate
 */
public class CarDAOImpl  implements CarDAO {
    static Logger logger = Logger.getLogger(CarDAOImpl.class);

    @Override
    public void create(Car car) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(car);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't create new car. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Car car){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(car);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't update car info. Exception: ", e); 
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Car read(Integer id){
        Session session = null;
        Car car = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            car = (Car) session.get(Car.class, id);
        } catch (HibernateException e) {
            logger.error("Can't read car info from database. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return car;
    }

    @Override
    public List<Car> getAll() {
        Session session = null;
        List<Car> cars = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            cars = session.createCriteria(Car.class).list();
        } catch (HibernateException e) {
            logger.error("Can't get all cars info. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cars;
    }

    @Override
    public void delete(Integer id){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Car car = (Car) session.get(Car.class, id);
            session.delete(car);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't delete car info. Exception: ", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}