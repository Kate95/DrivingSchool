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
import logic.ExamType;
import logic.Student;

/**
 *
 * @author Kate
 */
public class AddExamResultCommand implements Command {
    
    public AddExamResultCommand(){ 
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();  
        List<Student> studentList = DAOFactory.getInstance().getStudentDAO().getAll();
        List<ExamType> examTypeList = DAOFactory.getInstance().getExamTypeDAO().getAll();
        String[] paymentList= new String[studentList.size()];
        List<Account> accountList = DAOFactory.getInstance().getAccountDAO().getAll();
        int i=0;
        for(Student student:studentList){
            paymentList[i]="Не оплачено";
            for(Account account:accountList){
                if(student.getStudentID()==account.getStudent().getStudentID()){
                    int payment=student.getStudyGroup().getFormOfStudy().getCostOfEducation();
                    int paid=account.getAmountOfMoney();
                    if(payment<=paid){
                        paymentList[i]="Оплачено";
                    }
                    else{
                        paymentList[i]="Частично оплачено";
                    }                    
                }
            }
            i++;
        }        
        hash.put("studentList", studentList);
        hash.put("paymentList",paymentList);
        hash.put("examTypeList",examTypeList);      
        return hash;
    }
    
    public List<String> getAttributeName() {
        List<String> list = new ArrayList();   
        list.add("studentList");
        list.add("paymentList");
        list.add("examTypeList");
        return list;
    }
    
    public String getResponsePage(){
        return "/add_exam_result.jsp";
    }
}


