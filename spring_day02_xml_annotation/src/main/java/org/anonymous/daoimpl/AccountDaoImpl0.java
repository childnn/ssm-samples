package org.anonymous.daoimpl;

import org.anonymous.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author child
 * 2019/4/14 14:09
 */
@Repository("accountDao0")
public class AccountDaoImpl0 implements AccountDao {
    @Override
    public void save() {
        System.out.println("00000000000");
    }
}
