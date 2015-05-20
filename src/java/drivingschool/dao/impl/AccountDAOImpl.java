/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drivingschool.dao.impl;

import drivingschool.dao.AccountDAO;
import java.util.ArrayList;
import java.util.List;
import drivingschool.logic.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;
import drivingschool.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Kate
 */
public class AccountDAOImpl  implements AccountDAO {  
    static Logger logger = Logger.getLogger(AccountDAOImpl.class);

    @Override
    public void create(Account account) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(account);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't create new account. Exception: ", e);            
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(Account account){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(account);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't update account info. Exception: ", e); 
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Account read(Integer id){
        Session session = null;
        Account account = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            account = (Account) session.get(Account.class, id);
        } catch (HibernateException e) {
            logger.error("Can't read account info from database. Exception: ", e);            
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return account;
    }

    @Override
    public List<Account> getAll() {
        Session session = null;
        List<Account> accounts = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();            
            accounts = session.createCriteria(Account.class).list();
        } catch (HibernateException e) {
            logger.error("Can't get all accounts info. Exception: ", e);   
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return accounts;
    }

    @Override
    public void delete(Integer id){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Account account = (Account) session.get(Account.class, id);
            session.delete(account);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("Can't delete account info. Exception: ", e);   
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

