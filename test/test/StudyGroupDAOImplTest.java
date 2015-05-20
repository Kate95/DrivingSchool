/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import drivingschool.dao.DAOFactory;
import drivingschool.dao.StudyGroupDAO;
import java.sql.SQLException;
import java.util.Date;
import drivingschool.logic.FormOfStudy;
import drivingschool.logic.StudyGroup;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Kate
 */
public class StudyGroupDAOImplTest {
    static StudyGroupDAO dao;
    private static StudyGroup group1;
    private static StudyGroup group2;
    private static StudyGroup group3;    
    private static FormOfStudy form;
    
    public StudyGroupDAOImplTest() throws SQLException {
        form= new FormOfStudy("evening",6000,170,50);
        group1=new StudyGroup(1,15501,new Date(115,5,1),new Date(115,8,10),form);
        group2=new StudyGroup(2,15401,new Date(115,4,1),new Date(115,7,10),form);
        group3=new StudyGroup(3,15502,new Date(115,5,5),new Date(115,8,15),form);
        DAOFactory.getInstance().getFormOfStudyDAO().create(form);     
    }
    
    @BeforeClass
    public static void runBeforeAllTests() {
        dao = DAOFactory.getInstance().getStudyGroupDAO();        
    }

    @AfterClass
    public static void runAfterAllTests() throws SQLException {        
        DAOFactory.getInstance().getFormOfStudyDAO().delete(form.getFormOfStudy());
        dao = null;
    }
    
    @Test
    public void create() throws SQLException {        
        dao.create(group1);
        assertNotNull(dao.read(group1.getGroupID()));
        dao.delete(group1.getGroupID());
    }
    
    
    @Test
    public void update() throws SQLException{ 
        dao.create(group2);
        group2.setGroupNumber(15410);
        dao.update(group2);       
        assertEquals(dao.read(group2.getGroupID()).getGroupNumber(),(Integer)15410);
        group2.setGroupNumber(15401);
        dao.delete(group2.getGroupID());
    }
    
    
    @Test
    public void read() throws SQLException{
        dao.create(group3);
        assertEquals(dao.read(group3.getGroupID()),group3);
        dao.delete(group3.getGroupID());
    }
    
    
    @Test
    public void delete() throws SQLException{
        dao.create(group1);
        assertNotNull(dao.read(group1.getGroupID()));
        dao.delete(group1.getGroupID());
        assertNull(dao.read(group1.getGroupID()));
    }
    
    
    @Test
    public void getAll() throws SQLException{
        dao.create(group1);
        dao.create(group2);
        dao.create(group3);
        assertSame(dao.getAll().size(),3);
        dao.delete(group1.getGroupID());
        dao.delete(group2.getGroupID());
        dao.delete(group3.getGroupID());
    }
}
