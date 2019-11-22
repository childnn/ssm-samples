package org.anonymous.test;

import org.anonymous.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author child
 * 2019/4/13 21:28
 * spring 创建对象的方式二
 *      静态工厂的方式创建对象
 *  方式三:
 *      实例工厂的方式创建对象
 */
public class Demo02 {
    public static void main(String[] args) {
        //创建容器: 创建 单例对象
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        System.out.println("单例创建之后...");
        //从容器中 获取对象
        AccountService accountService = (AccountService) classPathXmlApplicationContext.getBean("accountService");
        accountService.save();

        System.out.println("================");
        f();
    }

    private static void f() {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        System.out.println("单例创建之后..../多例创建之前...");
        AccountService accountService0 = (AccountService) classPathXmlApplicationContext.getBean("accountService0");
        accountService0.save();
    }

}
