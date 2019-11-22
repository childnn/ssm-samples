package org.anonymous.test;

import org.anonymous.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author child
 * 2019/4/13 20:37
 * 初始化方法与销毁方法: 单例与多例 与 容器
 */
public class Demo01 {
    public static void main(String[] args) {
        /*
         *   容器, 单例与初始化方法/销毁方法
         * //容器创建:
         *   1.单例对象创建(无参构造执行),
         *   2.初始化方法执行
         */
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println("我就看看 单例对象 的初始化方法什么时候执行...");
        //从 容器中获取对象
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        AccountService accountService1 = (AccountService) applicationContext.getBean("accountService");
        System.out.println(accountService == accountService1);

        /*
         * 容器销毁
         *   单例对象销毁
         *   销毁方法执行
         */
        applicationContext.close(); //容器销毁
        System.out.println("-----------------0000-----------------");

        proto();
    }

    //容器, 多例 与 初始化方法
    private static void proto() {
        /*
         * 容器创建:
         *  多例对象不会创建
         *  初始化方法不会执行
         */
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println("我就看看 多例对象的 初始化什么时候执行...");
        //多例对象创建
        AccountService accountService0 = (AccountService) applicationContext.getBean("accountService0");
        System.out.println("再次创建多例对象");
        //再次创建对象
        AccountService accountService01 = (AccountService) applicationContext.getBean("accountService0");
        /*
         * 容器销毁
         *   多例对象不会销毁
         *   销毁方法不会执行: 多例对象的销毁方法无效,用永远不会执行!
         */
        applicationContext.close(); //容器销毁: 单例销毁
    }
}
