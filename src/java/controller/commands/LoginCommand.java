/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import controller.ConfigurationManager;
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

    private String page;
    
    public LoginCommand() {
    }

    public HashMap<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> hash = new HashMap();
        String admin_login = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_LOGIN);
        String admin_password = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_PASSWORD);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        boolean fl = false;
        if (login.equals(admin_login) && password.equals(admin_password)) {
            String admin = "администратор";
            hash.put("admin", admin);
            hash.put("client", null);
            hash.put("comment", null);
            page = "/index.jsp";
            fl = true;
        } else {
            Student stud = null;
            List<Student> students = DAOFactory.getInstance().getStudentDAO().getAll();
            for (Student student : students) {
                if (student.getLogin().equals(login) && student.getPassword().equals(password)) {
                    stud = student;
                    fl = true;
                    break;
                }
            }
            hash.put("client", stud);
            hash.put("admin", null);
            hash.put("comment", null);
            page = "/index.jsp";
        }
        if (!fl) {
            page = "/login.jsp";
            hash.put("client", null);
            hash.put("admin", null);
            hash.put("comment", "Вы ввели неправильный логин или пароль.");
        }
        return hash;
    }
    
    public List<String> getAttributeName() {
        List<String> list = new ArrayList(); 
        list.add("admin");
        list.add("client");
        list.add("comment");
        return list;
    }
    
    public String getResponsePage(){
        return page;
    }
}

