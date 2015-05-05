/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import dao.DAOFactory;
import dao.ExamTypeDAO;
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
import logic.ExamType;
import logic.Student;
import logic.StudyGroup;

/**
 *
 * @author Kate
 */
public class AddExamResultCommand implements Command {

    private StudentDAO dao;
    private ExamTypeDAO examTypeDao;
    private List<Student> studentList;
    private List<ExamType> examTypeList;
    private String paymentList[];
    private List<Account> accountList;
    private String page;
    
    public AddExamResultCommand(){        
        dao = DAOFactory.getInstance().getStudentDAO();
        examTypeDao = DAOFactory.getInstance().getExamTypeDAO();
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();  
        studentList = dao.getAll();
        examTypeList = examTypeDao.getAll();
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
        hash.put("studentList", studentList);
        hash.put("paymentList",paymentList);
        hash.put("examTypeList",examTypeList);
        page = "/add_exam_result.jsp";        
        return hash;
    }
    
    public ArrayList<String> getAttributeName() {
        ArrayList<String> list = new ArrayList();   
        list.add("studentList");
        list.add("paymentList");
        list.add("examTypeList");
        return list;
    }
    
    public String getResponsePage(){
        return page;
    }
}


