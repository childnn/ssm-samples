package org.anonymous.service;

import org.anonymous.domain.Account;

import java.util.List;

/**
 * @author child
 * 2019/4/14 16:41
 */
public interface AccountService {
    void save(Account account);

    void delete(int id);

    void update(Account account);

    List<Account> find();
}
