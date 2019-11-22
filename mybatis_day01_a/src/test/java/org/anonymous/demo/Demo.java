package org.anonymous.demo;

import org.anonymous.dao.ContactDao;
import org.anonymous.dao.ContactDaoImpl;
import org.anonymous.domain.Contact;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author child
 * 2019/4/9 21:37
 * 自定义框架的测试
 * 基本实现： 需要接口的实现类
 */
public class Demo {
    @Test
    public void test1() throws DocumentException, ClassNotFoundException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //测试自定义框架
        //封装 dao
        /*//创建 SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
        //获取 SqlSession
        SqlSession sqlSession = sqlSessionFactory.open();
        //使用 SqlSession: 操作数据库
        List<Contact> list = sqlSession.selectList("user.getAll");*/

        //调用 dao
        ContactDao contactDao = new ContactDaoImpl();
        List<Contact> list = contactDao.findAll();
        for (Contact user : list) {
            System.out.println(user);
        }
    }
}
