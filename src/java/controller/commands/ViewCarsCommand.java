/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import dao.CarDAO;
import dao.DAOFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Car;

/**
 *
 * @author Kate
 */
public class ViewCarsCommand implements Command {
    private CarDAO dao;
    private List<Car> carList;
    private String page;   
    
    public ViewCarsCommand(){
        dao = DAOFactory.getInstance().getCarDAO();
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();          
        carList = dao.getAll();
        if (carList.isEmpty()) {
            page = "/no_forms.jsp";
        } else {
            page = "/cars_info.jsp";
            hash.put("carList", carList);
        }   
        
        return hash;
    }
    
    public ArrayList<String> getAttributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("carList");
        return list;
    }
    
    public String getResponsePage(){
        return page;
    }
}

