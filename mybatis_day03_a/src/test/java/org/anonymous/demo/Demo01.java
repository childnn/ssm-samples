package org.anonymous.demo;

import org.anonymous.dao.ContactDao;
import org.anonymous.domain.Contact;
import org.anonymous.domain.POJOContact;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author child
 * 2019/4/11 15:46
 * org.apache.ibatis.type.TypeAliasRegistry -- 查 java 的数据类型 对应的配置文件中的 别名
 * 动态 sql:
 *  条件查询
 *  in : 包含查询
 */
public class Demo01 {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }
    @Test //条件查询
    public void test1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ContactDao mapper = sqlSession.getMapper(ContactDao.class);
        Contact contact = new Contact();
        contact.setName("张三丰");

        List<Contact> list = mapper.findContact(contact);
        sqlSession.close();
        list.forEach(System.out::println);
    }

    @Test //in 包含查询: 动态sql -- 数组
    public void test2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ContactDao mapper = sqlSession.getMapper(ContactDao.class);
        int[] arr = {4, 5, 6};
        List<Contact> list = mapper.findById(arr);

        sqlSession.close();
        list.forEach(System.out::println);
    }

    @Test //list
    public void test3() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ContactDao mapper = sqlSession.getMapper(ContactDao.class);
        List<Contact> list = mapper.findByList(new ArrayList<>() {{
            add(4);
            add(5);
            add(6);
        }});

        sqlSession.close();
        list.forEach(System.out::println);
    }

    @Test //pojo 对象
    public void test4() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ContactDao mapper = sqlSession.getMapper(ContactDao.class);
        POJOContact pojoContact = new POJOContact();
        pojoContact.setAbcd(new ArrayList<>(){{
            add(4);
            add(5);
            add(7);
        }});
        List<Contact> list = mapper.findByPojo(pojoContact);
        for (Contact contact : list) {
            System.out.println(contact);
        }
    }
}
