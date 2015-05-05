/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import logic.Exam;

/**
 *
 * @author Kate
 */
public interface ExamDAO {
    public void create(Exam exam);

    public void update(Exam exam);

    public Exam read(Integer id);

    public List getAll();

    public void delete(Integer id);
    
}
