package org.anonymous.core;

import org.anonymous.domain.Configuration;

/**
 * @author child
 * 2019/4/9 21:48
 * 生产 操作数据库的 SqlSession 接口的实现类 对象
 */
public class SqlSessionFactory {
    private Configuration configuration;

    public SqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    //生产 SqlSession
    public SqlSession open() {
        return new DefaultSqlSession(configuration);
    }
}
