package org.anonymous.dao;

import org.anonymous.domain.User;

import java.util.List;

/**
 * @author child
 * 2019/4/12 16:03
 */
public interface UserDao {
    //根据 uid 查询所有用户
    User findUserById(int uid);

    //查询所有用户
    List<User> findUsers();
}
