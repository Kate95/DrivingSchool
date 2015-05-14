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
import logic.Exam;

/**
 *
 * @author Kate
 */
public class ViewExamsCommand implements Command {

    public ViewExamsCommand(){        
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();          
        List<Exam> examList = DAOFactory.getInstance().getExamDAO().getAll();
        if (examList.isEmpty()) {
            hash.put("comment", "В базе нет требуемых данных");
        } else {
            hash.put("comment", null);
        }
        hash.put("examList", examList);
        return hash;
    }
    
    public List<String> getAttributeName() {
        List<String> list = new ArrayList();
        list.add("examList");
        list.add("comment");
        return list;
    }
    
    public String getResponsePage(){
        return "/exams_info.jsp";
    }
}
