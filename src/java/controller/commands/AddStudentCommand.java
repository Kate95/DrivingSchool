/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import dao.DAOFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.StudyGroup;

/**
 *
 * @author Kate
 */
public class AddStudentCommand implements Command {
    
    public AddStudentCommand(){        
       
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();  
        List<StudyGroup> groupList = DAOFactory.getInstance().getStudyGroupDAO().getAll();
        hash.put("groupList", groupList); 
        hash.put("comment", null);
        hash.put("student",null);
        hash.put("birthDate",null);
        return hash;
    }
    
    public List<String> getAttributeName() {
        List<String> list = new ArrayList();   
        list.add("groupList");
        list.add("comment");
        list.add("student");
        list.add("birthDate");
        return list;
    }
    
    public String getResponsePage(){
        return "/add_student.jsp";
    }
}

