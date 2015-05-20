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
import drivingschool.logic.Student;
import drivingschool.logic.StudyGroup;
import org.apache.log4j.Logger;

/**
 *
 * @author Kate
 */
public class AddStudentIntoDBCommand implements Command {
    static Logger logger = Logger.getLogger(AddStudentIntoDBCommand.class);
    
    public AddStudentIntoDBCommand(){   
    }

    @Override
    public HashMap<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> hash = new HashMap();
        Student student = new Student();
        Integer groupID = Integer.parseInt(request.getParameter("groupID"));
        StudyGroup group = DAOFactory.getInstance().getStudyGroupDAO().read(groupID);
        List<Student> students = DAOFactory.getInstance().getStudentDAO().getAll();
        student.setStudentID((students.get(students.size() - 1).getStudentID()) + 1);
        student.setStudyGroup(group);
        student.setStudentName(request.getParameter("studentName"));
        student.setAddress(request.getParameter("address"));
        student.setPhoneNumber(request.getParameter("phoneNumber"));
        student.setLogin(request.getParameter("login"));
        student.setPassword(request.getParameter("password"));
        DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        Date date = null;
        if (!request.getParameter("dateOfBirth").equals("")) {
            try {
                date = format.parse(request.getParameter("dateOfBirth"));
            } catch (ParseException ex) {
                logger.error("Can't parse date correctly. Exception: ", ex);
            }
        }
        student.setDateOfBirth(date);
        DAOFactory.getInstance().getStudentDAO().create(student);
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
