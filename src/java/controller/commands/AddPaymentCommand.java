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
import logic.Student;

/**
 *
 * @author Kate
 */
public class AddPaymentCommand implements Command {
    
    public AddPaymentCommand(){ 
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();  
        List<Student> studentList = DAOFactory.getInstance().getStudentDAO().getAll();        
        hash.put("studentList", studentList);   
        return hash;
    }
    
    public List<String> getAttributeName() {
        List<String> list = new ArrayList();   
        list.add("studentList");        
        return list;
    }
    
    public String getResponsePage(){
        return "/add_payment.jsp";
    }
}
