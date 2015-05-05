/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import dao.DAOFactory;
import dao.InstructorDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Instructor;

/**
 *
 * @author Kate
 */
public class ViewInstructorsCommand  implements Command {
    private InstructorDAO dao;
    private List<Instructor> instructorList;
    private String page;   
    
    public ViewInstructorsCommand(){
        dao = DAOFactory.getInstance().getInstructorDAO();
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();
        System.out.println("ok1");
        instructorList = dao.getAll();
        if (instructorList.isEmpty()) {
            page = "/no_forms.jsp";
        } else {
            page = "/instructors_info.jsp";
            hash.put("instructorList", instructorList);
        }       
        System.out.println("ok");
        return hash;
    }
    
    public ArrayList<String> getAttributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("instructorList");
        return list;
    }
    
    public String getResponsePage(){
        return page;
    }
}

