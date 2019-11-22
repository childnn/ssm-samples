package org.anonymous.test;

import org.anonymous.service.AccountService;
import org.anonymous.uitls.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author child
 * 2019/4/14 15:47
 * 没有 xml 配置文件,需要定义一个类,单独设置配置信息: 配置类
 */
public class Demo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.save();
    }
}
