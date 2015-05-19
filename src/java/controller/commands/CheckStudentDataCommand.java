/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import controller.ConfigurationManager;
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
import logic.Student;
import logic.StudyGroup;

/**
 *
 * @author Kate
 */
public class CheckStudentDataCommand implements Command {
    
    String page;
    
    public CheckStudentDataCommand(){        
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    
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
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        if (!request.getParameter("dateOfBirth").equals("")) {
            try {
                date = format.parse(request.getParameter("dateOfBirth"));
            } catch (ParseException ex) {
                Logger.getLogger(CheckStudentDataCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        student.setDateOfBirth(date);
        int fl=0;
        for(Student st:students){
            if(st.getLogin().equals(student.getLogin())||st.getLogin().equals(ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_LOGIN))){
                fl=1;
            }
            else if(st.getPassword().equals(student.getPassword())||st.getPassword().equals(ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_PASSWORD))){
                fl=2;
            }
        }
        if(student.getLogin().equals(ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_LOGIN))){
            fl=1;
        }
        else if(student.getPassword().equals(ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_PASSWORD))){
            fl=2;
        }
        if(fl == 0){
            hash.put("groupList", null);
            hash.put("comment", null);  
            hash.put("birthDate",null);
            page = "/student_data.jsp";
        }
        else if(fl == 1){
            List<StudyGroup> groupList = DAOFactory.getInstance().getStudyGroupDAO().getAll();
            hash.put("groupList", groupList);
            hash.put("comment", "Данный логин уже занят.");  
            hash.put("birthDate",request.getParameter("dateOfBirth"));
            page = "/add_student.jsp";
        }
        else{
            List<StudyGroup> groupList = DAOFactory.getInstance().getStudyGroupDAO().getAll();
            hash.put("groupList", groupList);
            hash.put("comment", "Данный пароль уже занят.");  
            hash.put("birthDate",request.getParameter("dateOfBirth"));
            page = "/add_student.jsp";
        }
        hash.put("student", student);        
        return hash;
    }
    
    public List<String> getAttributeName() {
        List<String> list = new ArrayList(); 
        list.add("student");
        list.add("groupList");
        list.add("comment");
        list.add("birthDate");
        return list;
    }
    
    public String getResponsePage(){
        return page;
    }
}
