/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import logic.CarBrand;

/**
 *
 * @author Kate
 */
public interface CarBrandDAO {
    public void create(CarBrand carBrand);

    public void update(CarBrand carBrand);

    public CarBrand read(String id);

    public List getAll();

    public void delete(String id);
}
