package org.anonymous.springConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author child
 * 2019/4/19 11:43
 */
@Configuration //定义配置类
@ComponentScan(basePackages = "org.anonymous", scopedProxy = ScopedProxyMode.DEFAULT) //注解扫描器, 指定代理类型
//D:\Develop\IDEA_Project\maven-project\spring_day03_annotation\src\test\java\org\anonymous\springConfig\SpringConfig.java
// @EnableAspectJAutoProxy //<aop:aspectj-autoproxy/> 开启 aop 注解支持 - 自定义的 切面类(事务管理器)
@EnableTransactionManagement //开启 事务支持 //<tx:annotation-driven/> - 使用 spring 的 事务管理器: DataSourceTransactionManager
@Import(JdbcConfig.class)
public class SpringConfiguration {

    @Bean("transactionManager") //事务管理器: 事务管理切面类
//    @Lazy(true) //定义懒加载
//    @Scope(value = "singleton", proxyMode = ScopedProxyMode.DEFAULT) //定义 对象属性(单例/多例) 和 代理类别
    public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("druid") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
