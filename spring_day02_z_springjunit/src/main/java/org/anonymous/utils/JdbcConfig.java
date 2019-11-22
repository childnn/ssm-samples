package org.anonymous.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

/**
 * @author child
 * 2019/4/14 16:48
 * 配置类加载时, 所有 带有 @Bean 注解的 方法都会 被执行,并将 方法返回值的 对象 存入 ioc 容器
 */
@PropertySource("jdbc.properties") //解析 properties 配置文件: 数据库连接信息
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 数据库相关第三方 资源
     */
    //方式一: 通过 当前配置类 加载 .properties 文件, 获取 数据库连接信息
    @Bean("druid0")
    public DataSource getDataSource0() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        System.out.println("注解解析properties配置文件");
        return druidDataSource;
    }

    //方式二: 通过 类加载器 加载配置文件
    @Bean("druid")
    public DataSource getDataSource() throws Exception {
        Properties properties = new Properties();
        properties.load(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("jdbc.properties")));
        System.out.println("类加载器");
        return DruidDataSourceFactory.createDataSource(properties);
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(@Qualifier("druid0") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
