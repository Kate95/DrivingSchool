/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import drivingschool.dao.DAOFactory;
import drivingschool.dao.StudentDAO;
import java.sql.SQLException;
import java.util.Date;
import drivingschool.logic.FormOfStudy;
import drivingschool.logic.Student;
import drivingschool.logic.StudyGroup;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Kate
 */
public class StudentDAOImplTest {
    static StudentDAO dao;
    private static Student student1;
    private static Student student2;
    private static Student student3;
    private static StudyGroup group;
    private static FormOfStudy form;
    
    public StudentDAOImplTest() throws SQLException {
        form= new FormOfStudy("evening",6000,170,50);
        group=new StudyGroup(1,15501,new Date(115,5,1),new Date(115,8,10),form);
        DAOFactory.getInstance().getFormOfStudyDAO().create(form);
        DAOFactory.getInstance().getStudyGroupDAO().create(group);
        student1=new Student(1,group,"Ivanov","123-45-67","Kolasa 13",new Date(91,1,11),"vanya","111");
        student2=new Student(2,group,"Petrov","345-65-87","Kolesnika 22",new Date(90,8,23),"petya","222");
        student3=new Student(3,group,"Sidorov","333-88-99","Gorkogo 3",new Date(92,9,21),"oleg92","333");
        //System.out.println(student2.toString());
    }
    
    @BeforeClass
    public static void runBeforeAllTests() {
        dao = DAOFactory.getInstance().getStudentDAO();        
    }

    @AfterClass
    public static void runAfterAllTests() throws SQLException {
        DAOFactory.getInstance().getStudyGroupDAO().delete(group.getGroupID());
        DAOFactory.getInstance().getFormOfStudyDAO().delete(form.getFormOfStudy());
        dao = null;
    }
    
    @Test
    public void create() throws SQLException {        
        dao.create(student1);
        assertNotNull(dao.read(student1.getStudentID()));
        dao.delete(student1.getStudentID());
    }
    
    
    @Test
    public void update() throws SQLException{ 
        dao.create(student2);
        student2.setPassword("000");
        dao.update(student2);       
        assertEquals(dao.read(student2.getStudentID()).getPassword(),"000");
        student2.setPassword("222");
        dao.delete(student2.getStudentID());
    }
    
    
    @Test
    public void read() throws SQLException{
        dao.create(student3);
        assertEquals(dao.read(student3.getStudentID()),student3);
        dao.delete(student3.getStudentID());
    }
    
    
    @Test
    public void delete() throws SQLException{
        dao.create(student1);
        assertNotNull(dao.read(student1.getStudentID()));
        dao.delete(student1.getStudentID());
        assertNull(dao.read(student1.getStudentID()));
    }
    
    
    @Test
    public void getAll() throws SQLException{
        dao.create(student1);
        dao.create(student2);
        dao.create(student3);
        assertSame(dao.getAll().size(),3);
        dao.delete(student1.getStudentID());
        dao.delete(student2.getStudentID());
        dao.delete(student3.getStudentID());
    }
}
