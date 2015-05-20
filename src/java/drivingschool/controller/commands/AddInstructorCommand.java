/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drivingschool.controller.commands;

import drivingschool.dao.DAOFactory;
import drivingschool.logic.Instructor;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kate
 */
public class AddInstructorCommand implements Command {
    
    public AddInstructorCommand(){        
    }

    @Override
    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    
        HashMap<String, Object> hash = new HashMap();          
        Instructor instructor = new Instructor();
        List<Instructor> instructors = DAOFactory.getInstance().getInstructorDAO().getAll();
        instructor.setInstructorID((instructors.get(instructors.size() - 1).getInstructorID()) + 1);
        instructor.setInstructorName(null);
        instructor.setPhoneNumber(null);
        hash.put("instructor", instructor);   
        hash.put("birthDate", null); 
        return hash;
    }
    
    @Override
    public List<String> getAttributeName() {
        List<String> list = new ArrayList();
        list.add("instructor");  
        list.add("birthDate"); 
        return list;
    }
    
    @Override
    public String getResponsePage(){
        return "/edit_instructor.jsp";
    }
}
