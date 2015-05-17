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
import logic.FormOfStudy;

/**
 *
 * @author Kate
 */
public class ViewAllStudyFormsCommand implements Command {

    public ViewAllStudyFormsCommand(){        
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();    
        List<FormOfStudy> formList = DAOFactory.getInstance().getFormOfStudyDAO().getAll();  
        hash.put("formList", formList);
        return hash;
    }
    
    public List<String> getAttributeName() {
        List<String> list = new ArrayList();
        list.add("formList");
        return list;
    }
    
    public String getResponsePage(){
        return "/study_forms_info.jsp";
    }
}
