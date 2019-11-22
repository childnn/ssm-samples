package org.anonymous.dao.daoimpl;

import org.anonymous.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author child
 * 2019/4/19 11:49
 */
@Repository("accountDaoImple")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void inMoney() {
        String sql = "update account set money = money - ? where id = ?";

        jdbcTemplate.update(sql, 1, 5);
    }

    @Override
    public void outMoney() {
        String sql = "update account set money = money + ? where id = ?";

        jdbcTemplate.update(sql, 1, 7);
    }
}
