/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import dao.DAOFactory;
import dao.StudentDAO;
import dao.StudyGroupDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Account;
import logic.Student;
import logic.StudyGroup;

/**
 *
 * @author Kate
 */
public class ViewStudentsCommand implements Command {
    private StudentDAO dao;
    private List<Student> studentList;
    private String paymentList[];
    private List<Account> accountList;
    private String page;   
    
    public ViewStudentsCommand(){
        dao = DAOFactory.getInstance().getStudentDAO();
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();          
        studentList = dao.getAll();
        paymentList= new String[studentList.size()];
        accountList = DAOFactory.getInstance().getAccountDAO().getAll();
        for(int i=0;i<studentList.size();i++){
            paymentList[i]="Не оплачено";            
            for(int j=0;j<accountList.size();j++){
                if(studentList.get(i).getStudentID()==accountList.get(j).getStudent().getStudentID()){
                    int payment=studentList.get(i).getStudyGroup().getFormOfStudy().getCostOfEducation();
                    int paid=accountList.get(j).getAmountOfMoney();
                    if(payment<=paid){
                        paymentList[i]="Оплачено";
                    }
                    else{
                        paymentList[i]="Частично оплачено";
                    }                    
                }
            }
        }
        if (studentList.isEmpty()) {
            page = "/no_forms.jsp";
        } else {
            page = "/students_info.jsp";
            hash.put("studentList", studentList);
            hash.put("paymentList",paymentList);
        }          
        return hash;
    }
    
    public ArrayList<String> getAttributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("studentList");
        list.add("paymentList");
        return list;
    }
    
    public String getResponsePage(){
        return page;
    }
}
