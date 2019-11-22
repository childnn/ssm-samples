package org.anonymous.demo;

import org.anonymous.core.SqlSession;
import org.anonymous.core.SqlSessionFactory;
import org.anonymous.core.SqlSessionFactoryBuilder;
import org.anonymous.dao.ContactDao;
import org.anonymous.domain.Contact;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author child
 * 2019/4/9 21:37
 * 基于动态代理 + 注解 : 取消 sql 映射配置文件
 * 在 dao 接口的方法上定义 注解
 *  目标对象： 接口的实现类
 *  代理对象： 动态代理实现接口,得到接口实现类
 */
public class Demo {
    @Test
    public void test1() throws DocumentException, ClassNotFoundException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
        SqlSession sqlSession = sqlSessionFactory.open();
        //返回 dao 层 接口 的 代理对象
        ContactDao contactDao = sqlSession.getMapper(ContactDao.class);
        List<Contact> list = contactDao.findAll(); // invoke 方法执行
        for (Contact user : list) {
            System.out.println(user);
        }
    }
}
