/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drivingschool.controller.commands;

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
public class NoCommand implements Command {  
    
    public NoCommand(){        
    }

    @Override
    public HashMap<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> hash = new HashMap();
        return hash;
    }
    
    @Override
    public List<String> getAttributeName() {
        List<String> list = new ArrayList(); 
        return list;
    }
    
    @Override
    public String getResponsePage(){
        return "/index.jsp";
    }
}

