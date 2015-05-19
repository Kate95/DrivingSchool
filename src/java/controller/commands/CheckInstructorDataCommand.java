/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import dao.DAOFactory;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Instructor;

/**
 *
 * @author Kate
 */
public class CheckInstructorDataCommand implements Command {

    public CheckInstructorDataCommand(){        
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    
        HashMap<String, Object> hash = new HashMap();
        Integer instructorID = Integer.parseInt(request.getParameter("instructorID"));
        Instructor instructor = DAOFactory.getInstance().getInstructorDAO().read(instructorID);
        instructor.setInstructorName(request.getParameter("instructorName"));
        instructor.setPhoneNumber(request.getParameter("phoneNumber"));
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        if (!request.getParameter("dateOfBirth").equals("")) {
            try {            
                date = format.parse(request.getParameter("dateOfBirth"));
            } catch (ParseException ex) {
                Logger.getLogger(CheckInstructorDataCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        instructor.setDateOfBirth(date);
        //hash.put("birthDate", request.getParameter("dateOfBirth"));
        hash.put("instructor", instructor);
        return hash;
    }
    
    public List<String> getAttributeName() {
        List<String> list = new ArrayList(); 
        list.add("instructor");
        //list.add("birthDate");
        return list;
    }
    
    public String getResponsePage(){
        return "/instructor_data.jsp";
    }
}
