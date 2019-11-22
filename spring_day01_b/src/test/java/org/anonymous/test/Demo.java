package org.anonymous.test;

import org.anonymous.service.AccountService;
import org.anonymous.serviceimpl.AccountServiceImpl0;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author child
 * 2019/4/13 19:51
 * spring 的 单例工厂
 */
public class Demo {
    public static void main(String[] args) {
        //多态: 加载配置文件, 创建 spring(ioc) 容器, 创建 <bean> 标签 中的 class 属性对应的 全限定名 的 对象
        // 将 id 与 class 以 k-v 的形式 放入 Map<String, Object> map 中:  key: <bean> 标签的 id, value: <bean> 标签的 class
        // 执行第一句话的时候,就已经 创建出了 指定配置文件中的 所有单例对象（singleton）
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println("就看看单例对象什么时候创建----0----");
        //从容器中获取对象: 通过 xml 中配置的 id  -- 注意: 是获取,而不是创建 -- 通过 id (配置文件中配置的 id) 获取 对象
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.save();
        AccountService accountService1 = (AccountService) applicationContext.getBean("accountService");
        System.out.println(accountService == accountService1); //true

        System.out.println("--------------------------");
        //getBean() 调用, 多例对象 产生
        AccountServiceImpl0 accountServiceImpl0 = applicationContext.getBean(AccountServiceImpl0.class);
        System.out.println(accountServiceImpl0);
        //容器销毁: 单例对象随之销毁
        ((ClassPathXmlApplicationContext) applicationContext).close();
//        ConfigurableListableBeanFactory beanFactory = ((ClassPathXmlApplicationContext) applicationContext).getBeanFactory();
//        proto();
    }

    //多例
    private static void proto(){
        //解析配置文件: 不会创建对象-- 会创建 AccountServiceImpl 的对象, 不会创建 AccountServiceImpl0 的对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println("就看看多例对象什么时候创建 ---1 ---");
        //调用 getBean() : 创建对象
        AccountService accountService0 = (AccountService) applicationContext.getBean("accountService0");
        accountService0.save();
        //调用一次: 创建一次
        AccountService accountService01 = (AccountService) applicationContext.getBean("accountService0");
        System.out.println(accountService0 == accountService01);
    }
}
