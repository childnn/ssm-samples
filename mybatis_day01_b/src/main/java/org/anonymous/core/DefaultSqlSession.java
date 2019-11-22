package org.anonymous.core;

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

    //封装对象: 需要用户指定 key: sql 映射配置文件中的 namespace.id -- 唯一
    public <E> List<E> selectList(String key) throws ClassNotFoundException,
            SQLException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //获取 Configuration 对象的 mappers 属性值 -- Mapper 对象的 集合
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
        Object proxyInstance = Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass}, (proxy, method, args) -> {
                    //业务逻辑
    //                System.out.println("代理对象调用任何方法,我都执行!");
                    //直接调用 selectList(String key)
                    /*
                     * key: namespace.id
                     *      namespace: 当前接口的全限定名: org.anonymous.dao.ContactDao
                     *      id: 方法名 -- 代理对象调用的方法的方法名 --  method.getName()
                     */
                    Type[] genericInterfaces = proxy.getClass().getGenericInterfaces();
    //                System.out.println(Arrays.toString(genericInterfaces));
                    String namespace = genericInterfaces[0].getTypeName();
                    String id = method.getName();
                    String key = namespace + "." + id;
    //                System.out.println(key);
                    return selectList(key); //返回值由 代理对象 调用方法后 接收
                });
        return (E)proxyInstance; //返回 指定接口的 代理对象
    }
}
