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
import drivingschool.logic.Student;

/**
 *
 * @author Kate
 */
public class AddPaymentCommand implements Command {
    
    public AddPaymentCommand(){ 
    }

    @Override
    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();  
        List<Student> studentList = DAOFactory.getInstance().getStudentDAO().getAll();        
        hash.put("studentList", studentList);   
        return hash;
    }
    
    @Override
    public List<String> getAttributeName() {
        List<String> list = new ArrayList();   
        list.add("studentList");        
        return list;
    }
    
    @Override
    public String getResponsePage(){
        return "/add_payment.jsp";
    }
}
