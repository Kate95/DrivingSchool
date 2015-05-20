/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drivingschool.dao;

import java.util.List;
import drivingschool.logic.Exam;

/**
 *
 * @author Kate
 */
public interface ExamDAO {
    public void create(Exam exam);

    public void update(Exam exam);

    public Exam read(Integer studentID, Integer examNumber);

    public List getAll();

    public void delete(Integer studentID, Integer examNumber);
    
}
