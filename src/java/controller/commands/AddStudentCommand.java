/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import dao.DAOFactory;
import dao.StudyGroupDAO;
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

    private StudyGroupDAO dao;
    private List<StudyGroup> groupList;
    private String page;
    
    public AddStudentCommand(){        
        dao = DAOFactory.getInstance().getStudyGroupDAO();
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();  
        groupList = dao.getAll();
        hash.put("groupList", groupList);
        page = "/add_student.jsp";        
        return hash;
    }
    
    public ArrayList<String> getAttributeName() {
        ArrayList<String> list = new ArrayList();   
        list.add("groupList");
        return list;
    }
    
    public String getResponsePage(){
        return page;
    }
}

