/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drivingschool.controller.commands;

import drivingschool.dao.DAOFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import drivingschool.logic.Exam;

/**
 *
 * @author Kate
 */
public class ViewExamsCommand implements Command {

    public ViewExamsCommand(){        
    }

    @Override
    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();          
        List<Exam> examList = DAOFactory.getInstance().getExamDAO().getAll();
        hash.put("examList", examList);
        return hash;
    }
    
    @Override
    public List<String> getAttributeName() {
        List<String> list = new ArrayList();
        list.add("examList");
        return list;
    }
    
    @Override
    public String getResponsePage(){
        return "/exams_info.jsp";
    }
}
