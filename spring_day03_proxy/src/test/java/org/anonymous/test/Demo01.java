package org.anonymous.test;

import org.anonymous.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author child
 * 2019/4/16 21:47
 */
public class Demo01 {
    @Test //前置,后置,最终,异常通知
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }

    @Test //环绕通知
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean0.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }
}
