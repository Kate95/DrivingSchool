/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drivingschool.dao;

import java.util.List;
import drivingschool.logic.Instructor;

/**
 *
 * @author Kate
 */
public interface InstructorDAO {
    public void create(Instructor instructor);

    public void update(Instructor instructor);

    public Instructor read(Integer id);

    public List getAll();

    public void delete(Integer id);
}
