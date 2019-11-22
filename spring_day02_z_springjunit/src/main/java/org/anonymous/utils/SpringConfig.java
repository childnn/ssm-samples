package org.anonymous.utils;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author child
 * 2019/4/14 16:43
 */
@Configuration //为当前类定义 配置类
@ComponentScan(basePackages = "org.anonymous") //本地资源 注解扫描器
@Import(value={JdbcConfig.class}) //引入 配置类
public class SpringConfig {
}
