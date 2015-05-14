/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import logic.StudyGroup;

/**
 *
 * @author Kate
 */
public interface StudyGroupDAO {

    public void create(StudyGroup group);

    public void update(StudyGroup group);

    public StudyGroup read(Integer id);

    public List getAll();

    public void delete(Integer id);
}
