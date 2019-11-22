package org.anonymous.utils;

import org.anonymous.service.AccountService;
import org.anonymous.serviceimpl.AccountServiceImpl0;

/**
 * @author child
 * 2019/4/13 21:37
 * 实例工厂(非静态工厂方法)： instance factory method
 *  工厂的非静态方法创建对像
 */
public class BeanFactory0 {
    public AccountService getBean() {
        return new AccountServiceImpl0();
    }
}
