package org.anonymous.daoimpl;

import org.anonymous.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author child
 * 2019/4/14 15:49
 */
@Repository("accountDao") //将对象 放入 ioc: service 层调用 接口的方法时, 回去 ioc 中找接口的实现类对象
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void save() {
        System.out.println("ok");
    }
}
