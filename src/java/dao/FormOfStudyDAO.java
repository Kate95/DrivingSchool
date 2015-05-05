/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import logic.FormOfStudy;

/**
 *
 * @author Kate
 */
public interface FormOfStudyDAO {

    public void create(FormOfStudy form);

    public void update(FormOfStudy form);

    public FormOfStudy read(String id);

    public List getAll();

    public void delete(String id);
}
