package org.anonymous.service.serviceimpl;

import org.anonymous.dao.AccountDao;
import org.anonymous.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author child
 * 2019/4/19 11:53
 */
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(isolation = Isolation.DEFAULT, readOnly = false, propagation = Propagation.REQUIRED, timeout = -1)
    public void transfer() {
        accountDao.outMoney();
        int i = 1 / 0;
        accountDao.inMoney();
    }
}
