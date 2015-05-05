/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.commands;

import dao.DAOFactory;
import dao.StudyGroupDAO;
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
    private StudyGroupDAO dao;
    private List<StudyGroup> groupList;
    private Integer studNumList[];
    private List<Student> studentList;
    private String page;   
    
    public ViewStudyGroupsCommand(){
        dao = DAOFactory.getInstance().getStudyGroupDAO();
    }

    public HashMap<String, Object> execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> hash = new HashMap();          
        groupList = dao.getAll();
        studNumList= new Integer[groupList.size()];
        studentList = DAOFactory.getInstance().getStudentDAO().getAll();
        for(int i=0;i<groupList.size();i++){
            studNumList[i]=0;            
            for(int j=0;j<studentList.size();j++){
                if(studentList.get(j).getStudyGroup().getGroupID()==groupList.get(i).getGroupID()){
                    studNumList[i]++;
                }
            }
        }
        if (groupList.isEmpty()) {
            page = "/no_forms.jsp";
        } else {
            page = "/study_groups_info.jsp";
            hash.put("groupList", groupList);
            hash.put("studNumList",studNumList);
        }          
        return hash;
    }
    
    public ArrayList<String> getAttributeName() {
        ArrayList<String> list = new ArrayList();
        list.add("groupList");
        list.add("studNumList");
        return list;
    }
    
    public String getResponsePage(){
        return page;
    }
}