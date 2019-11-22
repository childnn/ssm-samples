package org.anonymous.demo;

import org.anonymous.dao.ContactDao;
import org.anonymous.domain.Contact;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author child
 * 2019/4/10 14:02
 * 反射/注解/接口/动态代理/配置文件
 * 使用 mybatis 框架: 动态代理 + 配置文件
 */
public class Demo {
    @Test
    public void test1() throws IOException {
        //创建 SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取 SqlSessionFactory
//        InputStream is = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行: 传递 接口,底层就是 动态代理,返回接口的代理对象(实现类)
        ContactDao mapper = sqlSession.getMapper(ContactDao.class);
        List<Contact> list = mapper.findAll();
        for (Contact contact : list) {
            System.out.println(contact);
        }
    }
}
