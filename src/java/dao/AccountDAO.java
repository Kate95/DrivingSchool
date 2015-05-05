/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import logic.Account;

/**
 *
 * @author Kate
 */
public interface AccountDAO {
    public void create(Account account);

    public void update(Account account);

    public Account read(Integer id);

    public List getAll();

    public void delete(Integer id);
}
