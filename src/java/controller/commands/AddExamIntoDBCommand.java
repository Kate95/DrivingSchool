/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import dao.DAOFactory;
import dao.ExamDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
public class AddExamIntoDBCommand implements Command {
    private ExamDAO dao;
    private String page;   
    
    public AddExamIntoDBCommand(){   
        dao=DAOFactory.getInstance().getExamDAO();
    }

    public HashMap<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> hash = new HashMap();
        Exam exam = new Exam();
        Integer studentID = Integer.parseInt(request.getParameter("studentID"));
        Student student = DAOFactory.getInstance().getStudentDAO().read(studentID);
        exam.setStudent(student);
        ExamType examType = DAOFactory.getInstance().getExamTypeDAO().read(request.getParameter("examType"));
        exam.setExamType(examType);
        exam.setValue(Integer.parseInt(request.getParameter("value")));
        exam.setExamNumber(Integer.parseInt(request.getParameter("examNumber")));
        dao.create(exam);
        page = "/index.jsp";
        return hash;
    }
    
    public ArrayList<String> getAttributeName() {
        ArrayList<String> list = new ArrayList();         
        return list;
    }
    
    public String getResponsePage(){
        return page;
    }
}

