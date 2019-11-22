package org.anonymous.test;

import org.anonymous.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author child
 * 2019/4/14 14:56
 * 多例 与 注解: @Scope(value="singleton/prototype")
 * @Vlaue():
 *      1. 简单属性赋值:
 *      2. 获取 .properties 配置文件信息 -- org.anonymous.serviceimpl.AccountServiceImpl1
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService1 = (AccountService) applicationContext.getBean("accountService1");
        AccountService accountService2 = (AccountService) applicationContext.getBean("accountService1");
        System.out.println(accountService1 == accountService2);
        accountService1.save();

        ((ClassPathXmlApplicationContext) applicationContext).close(); //多例对象: 对象与有容器无关 - 容器销毁,对象不会销毁
    }
}
