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
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Student;
import logic.StudyGroup;

/**
 *
 * @author Kate
 */
public class AddStudentIntoDBCommand implements Command {
    
    public AddStudentIntoDBCommand(){   
    }

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
        try {
            date = format.parse(request.getParameter("dateOfBirth"));
        } catch (ParseException ex) {
            Logger.getLogger(CheckStudentDataCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        student.setDateOfBirth(date);
        boolean fl = true;
        for (Student st : students) {
            if (student.getLogin().equals(st.getLogin()) || student.getPassword().equals(st.getPassword())) {
                fl = false;
            }
        }
        if (fl) {
            DAOFactory.getInstance().getStudentDAO().create(student);
        }
        return hash;
    }

    public List<String> getAttributeName() {
        List<String> list = new ArrayList();
        return list;
    }
    
    public String getResponsePage(){
        return "/index.jsp";
    }
}
