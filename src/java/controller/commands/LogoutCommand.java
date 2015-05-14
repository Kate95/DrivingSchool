/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kate
 */
public class LogoutCommand implements Command {
    
    public LogoutCommand(){        
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> hash = new HashMap();
        hash.put("admin", null);
        hash.put("client", null);
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