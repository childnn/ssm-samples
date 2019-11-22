package org.anonymous.springjunit;

import org.anonymous.service.AccountService;
import org.anonymous.springConfig.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author child
 * 2019/4/19 11:54
 */
@RunWith(SpringJUnit4ClassRunner.class) //配置加载器
@ContextConfiguration(classes = SpringConfiguration.class) //配置类
public class SpringJunit {

    @Autowired
//    @Qualifier("accountServiceImpl")
    private AccountService accountService;

    @Test
    public void test1() {
        accountService.transfer();
    }
}
