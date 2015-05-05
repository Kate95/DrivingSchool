/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import dao.DAOFactory;
import dao.ExamDAO;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Exam;
import logic.ExamType;
import logic.Student;
import logic.StudyGroup;

/**
 *
 * @author Kate
 */
public class CheckExamDataCommand implements Command {

    private String page; 
    private List<Exam> examList;
    private ExamDAO dao;
    
    public CheckExamDataCommand(){
        dao=DAOFactory.getInstance().getExamDAO();
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    
            HashMap<String, Object> hash = new HashMap();
            Exam exam = new Exam();  
            examList = dao.getAll();
            Integer studentID =Integer.parseInt(request.getParameter("studentID"));
            Student student = DAOFactory.getInstance().getStudentDAO().read(studentID);
            exam.setStudent(student);
            ExamType examType= DAOFactory.getInstance().getExamTypeDAO().read(request.getParameter("examType"));
            exam.setExamType(examType);
            exam.setValue(Integer.parseInt(request.getParameter("value")));
            exam.setExamNumber(Integer.parseInt(request.getParameter("examNumber")));       
            boolean fl=true;
            for(int i=0;i<examList.size();i++){
                if(exam.getExamNumber()==examList.get(i).getExamNumber()&&exam.getStudent().getStudentID()==examList.get(i).getStudent().getStudentID()){
                    fl=false;
                }
            }   
            if(fl){
            page = "/exam_data.jsp";
            }else{
                page= "/such_exam_already_exist.jsp";
            }
            hash.put("exam", exam);
            return hash;      
    }
    
    public ArrayList<String> getAttributeName() {
        ArrayList<String> list = new ArrayList(); 
        list.add("exam");
        return list;
    }
    
    public String getResponsePage(){
        return page;
    }
}
