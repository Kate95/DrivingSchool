/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import logic.Car;

/**
 *
 * @author Kate
 */
public interface CarDAO {
    public void create(Car car);

    public void update(Car car);

    public Car read(Integer id);

    public List getAll();

    public void delete(Integer id);
}
