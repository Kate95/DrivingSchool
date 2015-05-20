/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import drivingschool.dao.DAOFactory;
import drivingschool.dao.FormOfStudyDAO;
import java.sql.SQLException;
import drivingschool.logic.FormOfStudy;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Kate
 */
public class FormOfStudyDAOImplTest {
    static FormOfStudyDAO dao;
    private static FormOfStudy form1;
    private static FormOfStudy form2;
    private static FormOfStudy form3;
    
    public FormOfStudyDAOImplTest() {
        form1=new FormOfStudy("evening",6000,170,50);
        form2=new FormOfStudy("morning",5500,165,50);
        form3=new FormOfStudy("weekend",5900,160,50);
    }
    
    @BeforeClass
    public static void runBeforeAllTests() {
        dao = DAOFactory.getInstance().getFormOfStudyDAO();        
        
    }

    @AfterClass
    public static void runAfterAllTests() {
        dao = null;
    }
    
    @Test
    public void create() throws SQLException {        
        dao.create(form1);
        assertNotNull(dao.read(form1.getFormOfStudy()));
        dao.delete(form1.getFormOfStudy());
    }
    
    @Test
    public void update() throws SQLException{ 
        dao.create(form2);
        form2.setCostOfEducation(7000);
        dao.update(form2);       
        assertTrue(dao.read(form2.getFormOfStudy()).getCostOfEducation()==7000);
        form2.setCostOfEducation(5500);
        dao.delete(form2.getFormOfStudy());
    }
    
    @Test
    public void read() throws SQLException{
        dao.create(form3);
        assertEquals(dao.read(form3.getFormOfStudy()),form3);
        dao.delete(form3.getFormOfStudy());
    }
    
    @Test
    public void delete() throws SQLException{
        dao.create(form1);
        assertNotNull(dao.read(form1.getFormOfStudy()));
        dao.delete(form1.getFormOfStudy());
        assertNull(dao.read(form1.getFormOfStudy()));
    }
    
    @Test
    public void getAll() throws SQLException{
        dao.create(form1);
        dao.create(form2);
        dao.create(form3);
        assertSame(dao.getAll().size(),3);
        dao.delete(form1.getFormOfStudy());
        dao.delete(form2.getFormOfStudy());
        dao.delete(form3.getFormOfStudy());
    }
}
