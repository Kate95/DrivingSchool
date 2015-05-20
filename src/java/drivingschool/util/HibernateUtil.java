/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.util;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Kate
 */
public class HibernateUtil {

    static Logger logger = Logger.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory = null;

    static {
        try {
            //creates the session factory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            logger.error("Can't create session factory. Exception:", e);           
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
