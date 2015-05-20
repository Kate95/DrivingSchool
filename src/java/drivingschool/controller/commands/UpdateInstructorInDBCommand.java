/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drivingschool.controller.commands;

import drivingschool.dao.DAOFactory;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import drivingschool.logic.Instructor;
import org.apache.log4j.Logger;

/**
 *
 * @author Kate
 */
public class UpdateInstructorInDBCommand implements Command {
    static Logger logger = Logger.getLogger(UpdateInstructorInDBCommand.class);
    
    public UpdateInstructorInDBCommand(){   
    }

    @Override
    public HashMap<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> hash = new HashMap();
        List<Instructor> instructors = DAOFactory.getInstance().getInstructorDAO().getAll();
        Instructor instructor;
        boolean flagCreate = false;
        Integer instructorID = Integer.parseInt(request.getParameter("instructorID"));
        if (instructorID > instructors.get(instructors.size() - 1).getInstructorID()) {
            instructor = new Instructor();
            instructor.setInstructorID(instructorID);
            flagCreate = true;
        } else {
            instructor = DAOFactory.getInstance().getInstructorDAO().read(instructorID);
        }
        instructor.setInstructorName(request.getParameter("instructorName"));
        instructor.setPhoneNumber(request.getParameter("phoneNumber"));
        DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        Date date = null;
        if (!request.getParameter("dateOfBirth").equals("")) {
            try {
                date = format.parse(request.getParameter("dateOfBirth"));
            } catch (ParseException ex) {
                logger.error("Can't parse date correctly. Exception: ", ex);
            }
        }
        instructor.setDateOfBirth(date);
        if (flagCreate) {
            DAOFactory.getInstance().getInstructorDAO().create(instructor);
        } else {
            DAOFactory.getInstance().getInstructorDAO().update(instructor);
        }
        return hash;
    }

    @Override
    public List<String> getAttributeName() {
        List<String> list = new ArrayList();
        return list;
    }
    
    @Override
    public String getResponsePage(){
        return "/index.jsp";
    }
}

