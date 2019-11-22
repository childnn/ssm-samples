package org.anonymous.dao;

import org.anonymous.domain.Contact;
import org.anonymous.domain.PageBean;

import java.util.List;

/**
 * @author child
 * 2019/4/10 19:33
 * 动态代理
 */
public interface ContactDao {
    //保存用户
    void saveContact(Contact contact);

    //更新
    void updateContact(Contact contact);

    //删除
    void deleteContact(Contact contact);

    //删除
    void deleteContact0(int id);

    //查询全部
    List<Contact> findAll();

    //根据 id 查询
    Contact findById(int id);

    //模糊查询
    List<Contact> findLike(String name);

    //统计用户数量
    int count();

    //映射
    List<Contact> find();

    //补充
    Contact findBC(PageBean pageBean);
}
