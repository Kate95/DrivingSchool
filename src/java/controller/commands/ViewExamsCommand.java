/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import dao.DAOFactory;
import dao.ExamDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Exam;

/**
 *
 * @author Kate
 */
public class ViewExamsCommand implements Command {
    private ExamDAO dao;
    private List<Exam> examList;
    private String page;   
    
    public ViewExamsCommand(){
        dao = DAOFactory.getInstance().getExamDAO();
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();          
        examList = dao.getAll();
        if (examList.isEmpty()) {
            page = "/no_forms.jsp";
        } else {
            page = "/exams_info.jsp";
            hash.put("examList", examList);
        }   
        
        return hash;
    }
    
    public ArrayList<String> getAttributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("examList");
        return list;
    }
    
    public String getResponsePage(){
        return page;
    }
}
