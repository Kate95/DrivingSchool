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
import logic.Instructor;

/**
 *
 * @author Kate
 */
public class ViewInstructorsCommand  implements Command {  
    
    public ViewInstructorsCommand(){        
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();        
        List<Instructor> instructorList = DAOFactory.getInstance().getInstructorDAO().getAll();
        if (instructorList.isEmpty()) {
            hash.put("comment", "В базе нет требуемых данных");
        } else {
            hash.put("comment", null);
        }    
        hash.put("instructorList", instructorList);
        return hash;
    }
    
    public List<String> getAttributeName() {
        List<String> list = new ArrayList();
        list.add("instructorList");
        list.add("comment");
        return list;
    }
    
    public String getResponsePage(){
        return "/instructors_info.jsp";
    }
}

