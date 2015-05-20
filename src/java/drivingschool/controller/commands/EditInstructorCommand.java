/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drivingschool.controller.commands;

import drivingschool.dao.DAOFactory;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import drivingschool.logic.Instructor;

/**
 *
 * @author Kate
 */
public class EditInstructorCommand implements Command {
    
    public EditInstructorCommand(){        
    }

    @Override
    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    
        HashMap<String, Object> hash = new HashMap();
        Integer instructorID = Integer.parseInt(request.getParameter("instructorID"));
        Instructor instructor = DAOFactory.getInstance().getInstructorDAO().read(instructorID); 
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String birthDate = df.format(instructor.getDateOfBirth());
        hash.put("instructor", instructor);   
        hash.put("birthDate", birthDate); 
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

