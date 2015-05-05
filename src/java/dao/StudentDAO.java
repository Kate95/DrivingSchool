/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import logic.Student;

/**
 *
 * @author Kate
 */
public interface StudentDAO {

    public void create(Student student);

    public void update(Student student);

    public Student read(Integer id);

    public List getAll();

    public void delete(Integer id);
    
    public boolean checkLogin(String login, String password); 
}
