/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.commands.Command;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kate
 */
public class Controller extends HttpServlet implements javax.servlet.Servlet{
    RequestHelper requestHelper=RequestHelper.getInstance();
    
    public Controller(){
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        processRequest(request,response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //открытие нового сеанса(сессии)
        HttpSession session = request.getSession(true);
        HashMap<String, Object> hash;
        ArrayList<String>list;
        Command command = requestHelper.getCommand(request);
        hash = command.execute(request, response);
        list = command.getAttributeName();
        for (String string : list) {            
            session.setAttribute(string, hash.get(string));
        }        
        String page = command.getResponsePage();
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
