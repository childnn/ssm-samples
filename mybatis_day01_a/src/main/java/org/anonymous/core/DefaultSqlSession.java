package org.anonymous.core;

import org.anonymous.domain.Configuration;
import org.anonymous.domain.Mapper;
import org.anonymous.utils.Executor;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author child
 * 2019/4/10 9:12
 * 操作数据库： Configuration
 */
//@SuppressWarnings("all")
public class DefaultSqlSession implements SqlSession {
    private final Configuration configuration;
    private final Executor executor;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        //创建 sql 执行工具类对象: 传递 数据库连接核心配置文件对象
        executor = new Executor(configuration);
    }

    //封装对象到list
    public <E> List<E> selectList(String key) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Map<String, Mapper> map = configuration.getMappers();
        //根据 key 获取 指定 的 value : map
        Mapper mapper = map.get(key);
        //获取 Mapper 对象的 属性值
        String sql = mapper.getQuerySql();
        String resultType = mapper.getResultType();

        //工具类
        List<E> list = executor.executeQuery(sql, resultType);

        //封装工具类
        /*//加载驱动
        Class.forName(configuration.getDriver());
        Connection connection = DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(), configuration.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        //元数据：数据库有关，可以获取数据库查询结果的所有字段名
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount(); //字段数量

        //获取所有字段名
        List<String> columnNames = new ArrayList<String>();
        for (int i = 1; i < columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }

        //反射，创建对象，调用 set 方法
        Class clazz = Class.forName(resultType);
        Method[] methods = clazz.getDeclaredMethods();
        //封装对象
        List list = new ArrayList();
        while (resultSet.next()) {
            Object obj = clazz.newInstance();
            //反射 set 方法，一边循环一边设置
            for (String columnName : columnNames) { //字段名：对应 JavaBean 中 属性名
                for (Method method : methods) {
                    if (method.getName().equalsIgnoreCase("set" + columnName)) {
                        //用查到的数据 给 对应的字段赋值
                        method.invoke(obj, resultSet.getObject(columnName));
                    }
                }
            }
            //封装对象到集合
            list.add(obj);
        }*/
        return list;
    }
}
