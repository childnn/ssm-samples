package org.anonymous.core;

import org.anonymous.domain.Configuration;
import org.anonymous.utils.XMLConfigBuilder;
import org.dom4j.DocumentException;

import java.io.InputStream;

/**
 * @author child
 * 2019/4/9 21:45
 * 封装好的 Configuration 对象
 * 创建 SqlSessionFactory 对象, 传递 Configuration 对象
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream is) throws DocumentException {
        //解析配置文件封装 configuration 对象
        Configuration configuration = XMLConfigBuilder.builderConfiguration(is);
        //创建 sqlSessionFactory 对象且传递 configuration 对象
        return new SqlSessionFactory(configuration);
    }
}


