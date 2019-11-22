package org.anonymous.dao;

import org.anonymous.domain.Account;

import java.util.List;

/**
 * @author child
 * 2019/4/14 16:40
 */
public interface AccountDao {
    void save(Account account);

    void delete(int id);

    void update(Account account);

    List<Account> find();
}
