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
import logic.Student;
import logic.StudyGroup;

/**
 *
 * @author Kate
 */
public class ViewStudyGroupsCommand implements Command {  
    
    public ViewStudyGroupsCommand(){
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();          
        List<StudyGroup> groupList = DAOFactory.getInstance().getStudyGroupDAO().getAll();
        Integer[] studNumList= new Integer[groupList.size()];
        List<Student> studentList = DAOFactory.getInstance().getStudentDAO().getAll();
        int i=0;
        for(StudyGroup group:groupList){
            studNumList[i]=0;   
            for(Student student:studentList){
                if(student.getStudyGroup().getGroupID()==group.getGroupID()){
                    studNumList[i]++;
                }
            }
            i++;
        }                
        hash.put("groupList", groupList);
        hash.put("studNumList",studNumList);
        return hash;
    }
    
    public List<String> getAttributeName() {
        List<String> list = new ArrayList();
        list.add("groupList");
        list.add("studNumList");        
        return list;
    }
    
    public String getResponsePage(){
        return "/study_groups_info.jsp";
    }
}