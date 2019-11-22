package org.anonymous.spring_junit;

import org.anonymous.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author child
 * 2019/4/19 11:07
 * 半 xml 方式
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean1.xml") //bean1: 全 xml
public class SpringJunit1 {
    @Autowired
    @Qualifier("accountServiceImpl1")
    private AccountService accountService;

    @Test
    public void test1() {
        accountService.transfer();
    }
}
