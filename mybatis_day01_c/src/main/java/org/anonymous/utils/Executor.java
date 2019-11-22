package org.anonymous.utils;

import org.anonymous.domain.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author child
 * 2019/4/10 9:42
 *
 * 执行 sql 工具类: 专门用于执行 sql 语句
 */
public class Executor {
    private Configuration configuration;

    public Executor(Configuration configuration) {
        this.configuration = configuration;
    }
    @SuppressWarnings("deprecation")
    public <E> List<E> executeQuery(String sql, String resultType) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
         //加载驱动
        Class.forName(configuration.getDriver());
        //建立连接
        Connection connection = DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(), configuration.getPassword());
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        //元数据：数据库有关，可以获取数据库查询结果的所有字段名
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount(); //字段数量

        //获取所有字段名
        List<String> columnNames = new ArrayList<String>();
        //字段索引从 1 开始!
        for (int i = 1; i <= columnCount; i++) {
//            System.out.println(metaData.getColumnName(i)); //测试
            columnNames.add(metaData.getColumnName(i));
        }

        //反射，创建对象，调用 set 方法
        Class clazz = Class.forName(resultType);
        Method[] methods = clazz.getDeclaredMethods();
        //封装对象
        List<E> list = new ArrayList();
        while (resultSet.next()) {
            E obj = (E)clazz.newInstance();
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
        }
        //关闭资源
        connection.close();
        preparedStatement.close();
        resultSet.close();

        return list;
    }
}
