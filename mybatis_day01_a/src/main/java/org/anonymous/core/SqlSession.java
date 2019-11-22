package org.anonymous.core;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author child
 * 2019/4/10 9:11
 * 操作数据库的接口
 */
public interface SqlSession {
    //queryForList
    public <E> List<E> selectList(String key) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException, InvocationTargetException;
}
