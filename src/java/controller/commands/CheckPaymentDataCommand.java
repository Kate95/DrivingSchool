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
import logic.Student;

/**
 *
 * @author Kate
 */
public class CheckPaymentDataCommand implements Command {

    public CheckPaymentDataCommand(){
    }

    public HashMap<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> hash = new HashMap();
        String comment = "";
        Integer sufficientPayment;
        Account account = new Account();
        List<Account> accounts = DAOFactory.getInstance().getAccountDAO().getAll();
        Student student = DAOFactory.getInstance().getStudentDAO().read(Integer.parseInt(request.getParameter("studentID")));
        Integer payment = Integer.parseInt(request.getParameter("payment"));
        boolean fl = false;
        for (Account a : accounts) {
            if (a.getStudent().equals(student)) {
                account = a;
                fl = true;
            }
        }
        if (!fl) {
            account.setAmountOfMoney(0);
            account.setStudent(student);
            account.setAccountNumber((accounts.get(accounts.size() - 1).getAccountNumber()) + 1);
            DAOFactory.getInstance().getAccountDAO().create(account);
            comment = "Т.к. оплата производится впервые,создан счет для данного слушателя. ";
        }

        int necessary = account.getStudent().getStudyGroup().getFormOfStudy().getCostOfEducation() - account.getAmountOfMoney();
        if (necessary <= 0) {
            comment += "Обучение уже полностью оплачено ранее. Больше оплачивать ничего не надо.";
            sufficientPayment = 0;
        } else if (necessary <= payment) {
            sufficientPayment = payment;
            comment += "Заявленная сумма больше необходимой для полной оплаты. Будет принята только необходимая для оплаты сумма.";
        } else {
            sufficientPayment = necessary;
            comment += "";
        }
        hash.put("account", account);
        hash.put("payment", sufficientPayment);
        hash.put("comment", comment);
        return hash;
    }
    
    public List<String> getAttributeName() {
        List<String> list = new ArrayList(); 
        list.add("account");
        list.add("payment");
        list.add("comment");
        return list;
    }
    
    public String getResponsePage(){
        return "/payment_data.jsp";
    }
}
