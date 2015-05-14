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
import logic.Exam;
import logic.ExamType;
import logic.Student;

/**
 *
 * @author Kate
 */
public class CheckExamDataCommand implements Command {

    public CheckExamDataCommand(){      
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    
        HashMap<String, Object> hash = new HashMap();
        String comment;
        Exam exam = new Exam();
        List<Exam> examList = DAOFactory.getInstance().getExamDAO().getAll();
        Integer studentID = Integer.parseInt(request.getParameter("studentID"));
        Student student = DAOFactory.getInstance().getStudentDAO().read(studentID);
        exam.setStudent(student);
        ExamType examType = DAOFactory.getInstance().getExamTypeDAO().read(request.getParameter("examType"));
        exam.setExamType(examType);
        exam.setValue(Integer.parseInt(request.getParameter("value")));
        exam.setExamNumber(Integer.parseInt(request.getParameter("examNumber")));
        boolean fl = true;
        for(Exam ex:examList){
            if(exam.getExamNumber() == ex.getExamNumber()&& exam.getStudent().getStudentID() == ex.getStudent().getStudentID()){
                fl=false;
            }
        }        
        if (fl) {
            comment = null;
        } else {
            comment = "Данные об этом экзамене уже есть в базе.";
        }
        hash.put("exam", exam);
        hash.put("comment", comment);
        return hash;
    }

    public List<String> getAttributeName() {
        List<String> list = new ArrayList(); 
        list.add("exam");
        list.add("comment");
        return list;
    }
    
    public String getResponsePage(){
        return "/exam_data.jsp";
    }
}
