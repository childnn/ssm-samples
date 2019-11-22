package org.anonymous.utils;

import org.anonymous.service.AccountService;
import org.anonymous.serviceimpl.AccountServiceImpl;

/**
 * @author child
 * 2019/4/13 21:28
 * spring 创建对象的方法二:
 * 静态工厂: static factory method
 * 工厂的静态方法： 如果 创建的对象需要参数，可以选则传参
 */
public abstract class BeanFactory {
    //静态方法
    public static AccountService getBean(){
        return new AccountServiceImpl();
    }
}
