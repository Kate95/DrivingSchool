/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import dao.DAOFactory;
import dao.FormOfStudyDAO;
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
    private FormOfStudyDAO dao;
    private List<FormOfStudy> formList;
    private String page;   
    
    public ViewAllStudyFormsCommand(){
        dao = DAOFactory.getInstance().getFormOfStudyDAO();
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();          
        formList = dao.getAll();
        if (formList.isEmpty()) {
            page = "/no_forms.jsp";
        } else {
            page = "/study_forms_info.jsp";
            hash.put("formList", formList);
        }   
        
        return hash;
    }
    
    public ArrayList<String> getAttributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("formList");
        return list;
    }
    
    public String getResponsePage(){
        return page;
    }
}
