/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import logic.ExamType;

/**
 *
 * @author Kate
 */
public interface ExamTypeDAO {
    public void create(ExamType examType);

    public void update(ExamType examType);

    public ExamType read(String id);

    public List getAll();

    public void delete(String id);
    
}
