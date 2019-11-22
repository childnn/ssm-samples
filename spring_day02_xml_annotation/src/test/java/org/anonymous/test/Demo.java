package org.anonymous.test;

import org.anonymous.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author child
 * 2019/4/14 12:13
 * web 控制层 : @Controller
 * service 业务逻辑层 : @Service
 * dao 持久层 : @Repository
 *      通用： @Componnet(value="id")
 * 以上 4 个注解目前都可以通用， 但是 @Component 已经不再维护
 *  另外三个：目前也是通用的，但是建议 按对应的 三层架构使用 三个 注解
 *      另：注解的 value 可以不赋值，如果不赋值，则默认为 当前类的 类名: 首字母必须小写 -- 不推荐这样使用
 *  对象属性的 di(依赖注入) : 替代 set 方法
 *      @Autowired
 *      @Qualifier( value="id 唯一标识"): 配合 @Autowired 使用
 *    jdk 自带注解: @Resource(name="id 唯一标识"): 不推荐使用
 *  基本属性: int,String...
 *      @Value( value = "赋值")
 */
public class Demo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.save();
    }
}
