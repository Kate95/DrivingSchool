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
import logic.Account;

/**
 *
 * @author Kate
 */
public class AddPaymentIntoDBCommand implements Command {
    
    public AddPaymentIntoDBCommand(){   
        
    }

    public HashMap<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> hash = new HashMap();        
        int payment = Integer.parseInt(request.getParameter("payment"));
        Account account = DAOFactory.getInstance().getAccountDAO().read(Integer.parseInt(request.getParameter("accountNumber")));
        int newAmountOfMoney = account.getAmountOfMoney()+payment;
        account.setAmountOfMoney(newAmountOfMoney);
        DAOFactory.getInstance().getAccountDAO().update(account);        
        return hash;
    }
    
    public List<String> getAttributeName() {
        List<String> list = new ArrayList();         
        return list;
    }
    
    public String getResponsePage(){
        return "/index.jsp";
    }
}
