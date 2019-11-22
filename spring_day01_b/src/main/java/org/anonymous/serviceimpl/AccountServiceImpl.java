package org.anonymous.serviceimpl;

import org.anonymous.service.AccountService;

/**
 * @author child
 * 2019/4/13 19:47
 */
public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl() {
        System.out.println("我是单例对象...");
    }

    @Override
    public void save() {
        System.out.println("single");
    }

    //配置的初始化方法
    public void aaa() {
        System.out.println("111111111111111单例初始化方法1111111111111");
    }
    //配置销毁方法
    public void bbb() {
        System.out.println("11111111111111单例销毁方法111111111111111");
    }
}
