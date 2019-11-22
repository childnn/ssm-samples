package org.anonymous.core;

import org.anonymous.annotation.Select;
import org.anonymous.domain.Configuration;
import org.anonymous.domain.Mapper;
import org.anonymous.utils.Executor;

import java.lang.reflect.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author child
 * 2019/4/10 9:12
 * 操作数据库： Configuration
 */
@SuppressWarnings("unchecked")
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        executor = new Executor(configuration);
    }

    //封装
    public <E> List<E> selectList(String key) throws ClassNotFoundException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<String, Mapper> map = configuration.getMappers();
        Mapper mapper = map.get(key);
        String sql = mapper.getQuerySql();
        String resultType = mapper.getResultType();

        //工具类: 操作数据库,返回结果
        return executor.executeQuery(sql, resultType);
    }

    //产生 指定接口 的代理对象(接口实现类)
    @Override
    public <E> E getMapper(Class interfaceClass) {
        Object proxyInstance = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //获取 待启动(接口)方法的注解
                Select select = method.getAnnotation(Select.class);
                //获取注解上的属性值
                String sql = select.querySql();
                String resultType = select.resultType();

                return executor.<E>executeQuery(sql, resultType); //返回值由 代理对象 调用方法后 接收
            }
        });
        return (E)proxyInstance; //返回 指定接口的 代理对象
    }
}
