package org.anonymous.dao.daoimpl;

import org.anonymous.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author child
 * 2019/4/19 9:53
 *
 */
@Repository("accountDaoImpl1")
public class AccountDaoImpl1 implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save() {
        String sql = "";
        jdbcTemplate.update(sql);
    }

    @Override //加钱
    public void inMoney() {
        String sql = "update account set money = money - ? where id = ?";

        jdbcTemplate.update(sql, 1, 5);
    }

    @Override //减钱
    public void outMoney() {
        String sql = "update account set money = money + ? where id = ?";
        jdbcTemplate.update(sql, 1, 7);
    }
}
