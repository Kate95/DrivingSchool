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
public class LoginCommand implements Command {

    public LoginCommand(){        
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    
            HashMap<String, Object> hash = new HashMap();
            String login=request.getParameter("login");
            String password=request.getParameter("password");
            if(login.equals("admin")&&password.equals("admin")){
                String admin="администратор";                
                hash.put("admin", admin);
                hash.put("client", null);
            }
            else{
            Student stud = null;               
            List<Student> students= DAOFactory.getInstance().getStudentDAO().getAll();           
            for(Student student:students){
                if(student.getLogin().equals(login)&&student.getPassword().equals(password)){
                    stud = student;
                    break;
                }
            }            
            hash.put("client", stud);
            hash.put("admin", null);
            }
            return hash;      
    }
    
    public List<String> getAttributeName() {
        List<String> list = new ArrayList(); 
        list.add("admin");
        list.add("client");
        return list;
    }
    
    public String getResponsePage(){
        return "/index.jsp";
    }
}

