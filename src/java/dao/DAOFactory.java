/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.impl.AccountDAOImpl;
import dao.impl.CarBrandDAOImpl;
import dao.impl.CarDAOImpl;
import dao.impl.ExamDAOImpl;
import dao.impl.ExamTypeDAOImpl;
import dao.impl.FormOfStudyDAOImpl;
import dao.impl.InstructorDAOImpl;
import dao.impl.StudentDAOImpl;
import dao.impl.StudyGroupDAOImpl;

/**
 *
 * @author Kate
 */
public class DAOFactory {

    private static StudentDAO studentDAO = null;
    private static StudyGroupDAO studyGroupDAO = null;
    private static FormOfStudyDAO formOfStudyDAO = null;
    private static InstructorDAO instructorDAO = null;
    private static AccountDAO accountDAO = null;
    private static CarDAO carDAO = null;
    private static ExamDAO examDAO = null;
    private static ExamTypeDAO examTypeDAO = null;
    private static CarBrandDAO carBrandDAO = null;
    private static DAOFactory instance = null;

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public StudentDAO getStudentDAO() {
        if (studentDAO == null) {
            studentDAO = new StudentDAOImpl();
        }
        return studentDAO;
    }

    public StudyGroupDAO getStudyGroupDAO() {
        if (studyGroupDAO == null) {
            studyGroupDAO = new StudyGroupDAOImpl();
        }
        return studyGroupDAO;
    }

    public FormOfStudyDAO getFormOfStudyDAO() {
        if (formOfStudyDAO == null) {
            formOfStudyDAO = new FormOfStudyDAOImpl();
        }
        return formOfStudyDAO;
    }
    
    public InstructorDAO getInstructorDAO() {
        if (instructorDAO == null) {
            instructorDAO = new InstructorDAOImpl();
        }
        return instructorDAO;
    }
    
    public AccountDAO getAccountDAO() {
        if (accountDAO == null) {
            accountDAO = new AccountDAOImpl();
        }
        return accountDAO;
    }
    
    public CarDAO getCarDAO() {
        if (carDAO == null) {
            carDAO = new CarDAOImpl();
        }
        return carDAO;
    }
    
    public ExamDAO getExamDAO() {
        if (examDAO == null) {
            examDAO = new ExamDAOImpl();
        }
        return examDAO;
    }
    
    public ExamTypeDAO getExamTypeDAO() {
        if (examTypeDAO == null) {
            examTypeDAO = new ExamTypeDAOImpl();
        }
        return examTypeDAO;
    }
    
    public CarBrandDAO getCarBrandDAO() {
        if (carBrandDAO == null) {
            carBrandDAO = new CarBrandDAOImpl();
        }
        return carBrandDAO;
    }
}
